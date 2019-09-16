import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board implements IFactoryBalls{

    private List<Ball> balls = new ArrayList<>();
    private int width;

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    private int lenght;

    public Board(int width, int lenght) {
        this.width = width;
        this.lenght = lenght;
    }
    public Board() {

    }

    public void generateBalls(int pQuantity, Color pColor, int pDireccion, int pVelocidad, int pPattern){
        switch (pPattern) {
            case Patterns.PROTOTYPE:
                Ball newBall = new Ball(pColor, pDireccion, pVelocidad);
                generatePrototype(pQuantity, newBall);
                break;
            case Patterns.FACTORY:
                generateFactory(pQuantity, pColor, pDireccion, pVelocidad);
                break;
            case Patterns.BUILDER:
                generateBuilder(pQuantity, pColor, pDireccion, pVelocidad);
                break;
            case Patterns.POOL:
                generatePool(pQuantity, pColor, pDireccion, pVelocidad);
                break;
        }
    }
    private void generatePool(int pQuantity, Color pColor, int pDireccion, int pVelocidad){
        ConcreteObjectPool objectPool = ConcreteObjectPool.getInstance(pQuantity, pColor, pDireccion, pVelocidad);
        for (int i=0; i<pQuantity; i++){
            balls.add((Ball) objectPool.unlockedPool.get(i));
        }

    }

    private void generatePrototype(int pQuantity, Ball base){
        for (int i=0; i<pQuantity; i++){
            balls.add(base.clone());
        }
    }

    private void generateFactory(int pQuantity, Color pColor, int pDireccion, int pVelocidad){
        for (int i=0; i<pQuantity; i++){
            IFactory newBall = new Ball(pColor, pDireccion, pVelocidad);
            balls.add((Ball) newBall);
        }
    }

    private void generateBuilder(int pQuantity, Color pColor, int pDireccion, int pVelocidad){
        for (int i=0; i<pQuantity; i++){
            Ball.BallBuilder ballBuilder = new Ball.BallBuilder();
            Ball newBall = ballBuilder.setColor(pColor).setDireccion(pDireccion).setVelocidad(pVelocidad).build();
            balls.add(newBall);
        }
    }

    private void generatePool(int pQuantity){

    }

    private int positionBall(int limit){
        Random random = new Random(System.currentTimeMillis());
        int position = random.nextInt(limit);
        return position;
    }
}