import java.awt.Color;

public class Ball implements IPrototype<Ball>, IFactory, IPoolableObject {
    private Color color;
    private int direccion;
    private int velocidad;
    private int positionX;
    private int getPositionY;

    public Ball(Color pColor, int pDireccion, int pVelocidad) {
        this.direccion = pDireccion;
        this.color = pColor;
        this.velocidad = pVelocidad;
    }

    public Ball clone() {
        Ball clone = new Ball(this.color, this.direccion, this.velocidad);
        return clone;
    }

    @Override
    public void moveBall(int limitX, int limitY) {
        switch (this.direccion) {
            case 0:
                if (isNegativeLimit(limitX, positionX +this.velocidad) == false) {
                    this.positionX = positionX + this.velocidad;
                } else {
                    this.direccion = 180;
                    this.positionX = positionX - this.velocidad;
                }
            case 180:
                if (isPositiveLimit(limitX, positionX + this.velocidad)) {

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
        private int direccionB;
        private int velocidadB;
        public Ball build() {
            return new Ball(colorB,direccionB,velocidadB);
        }

        public BallBuilder setVelocidad(int v) {
            this.velocidadB=v;
            return this;
        }
        public BallBuilder setColor(Color c) {
            this.colorB=c;
            return this;
        }
        public BallBuilder setDireccion(int d) {
            this.direccionB=d;
            return this;
        }


    }

}
