import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board implements IFactoryBalls{

    private List<Ball> balls = new ArrayList<>();
    private int width;
    private int lenght;

    public Board(int width, int lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    public void generateBalls(int pQuantity, int pPattern){
        switch (pPattern) {
            case Patterns.PROTOTYPE:
                generatePrototype(pQuantity);
                break;
            case Patterns.FACTORY:
                generateFactory(pQuantity);
                break;
            case Patterns.BUILDER:
                generateBuilder(pQuantity);
                break;
            case Patterns.POOL:
                generatePool(pQuantity);
                break;
        }
    }

    private void generatePrototype(int pQuantity){
        for (int i=0; i<pQuantity; i++){

        }
    }

    private void generateFactory(int pQuantity){

    }

    private void generateBuilder(int pQuantity){

    }

    private void generatePool(int pQuantity){

    }

    private int positionBall(int limit){
        Random random = new Random(System.currentTimeMillis());
        int position = random.nextInt(limit);
        return position;
    }
}
