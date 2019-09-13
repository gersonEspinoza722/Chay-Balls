import java.awt.Color;

public class Ball implements IPrototype<Ball>, IFactory, IPoolableObject {
    private Color color;
    private int angulo;
    private int velocidad;
    private int positionX;
    private int getPositionY;

    public Ball(Color pColor, int pAngulo, int pVelocidad) {
        this.angulo = pAngulo;
        this.color = pColor;
        this.velocidad = pVelocidad;
    }

    public Ball clone() {
        Ball clone = new Ball(this.color, this.angulo, this.velocidad);
        return clone;
    }

    @Override
    public void moveBall(int pixels, int limitX, int limitY) {
        int angulo = this.angulo;
        switch (angulo) {
            case 0:
                if (isNegativeLimit(limitX, positionX + pixels) == false) {
                    this.positionX = positionX + pixels;
                } else {
                    this.angulo = 180;
                    this.positionX = positionX - pixels;
                }
            case 180:
                if (isPositiveLimit(limitX, positionX + pixels)) {

                }
        }
    }

    @Override
    public void stopBall() {

    }

    private Boolean isPositiveLimit(int limit, int position){
        if(position >= limit)
            return true;
        return false;
    }

    private Boolean isNegativeLimit(int limit, int position){
        if(position <= limit)
            return true;
        return false;
    }

    public static class BallBuilder implements IBuilder<Ball> {
        private Color colorB;
        private int anguloB;
        private int velocidadB;
        public Ball build() {
            return new Ball(colorB,anguloB,velocidadB);
        }

        public BallBuilder setVelocidad(int v) {
            this.velocidadB=v;
            return this;
        }
        public BallBuilder setColor(Color c) {
            this.colorB=c;
            return this;
        }
        public BallBuilder setAngulo(int a) {
            this.anguloB=a;
            return this;
        }


    }

}
