import java.awt.Color;

public class Ball implements IPrototype<Ball> {
    private Color color;
    private int angulo;
    private int velocidad;

    public Ball(Color pColor,int pAngulo,int pVelocidad){
        this.angulo=pAngulo;
        this.color=pColor;
        this.velocidad=pVelocidad;
    }

    public Ball clone(){
        Ball clone = new Ball(this.color,this.angulo,this.velocidad);
        return clone;
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
