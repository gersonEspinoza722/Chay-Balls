import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball implements IPrototype<Ball>,  IFactory, IPoolableObject{
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private int angulo;
    private int velocidad;

    public Ball(Color pColor,int pAngulo,int pVelocidad){
        this.angulo=pAngulo;
        this.color=pColor;
        this.velocidad=pVelocidad;
    }

    public int getAngulo() {
        return angulo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Ball() {

    }
    public void move(Rectangle2D bounds,int angle) {

        x += Math.cos(angle*Math.PI/-180) * dx;
        y +=  Math.sin(angle*Math.PI/-180) * dy;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    /**
     * Gets the shape of the ball at its current position.
     */
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }

    private static final int XSIZE = 15;

    private static final int YSIZE = 15;

    private double x = 0;

    private double y = 0;

    private double dx = 1;

    private double dy = 1;

    public Ball clone(){
        Ball clone = new Ball(this.color,this.angulo,this.velocidad);
        return clone;
    }


    public void moveBall(Rectangle2D bounds) {
        x += Math.cos(60*Math.PI/-180) * dx;
        y += Math.cos(60*Math.PI/-180) * dy;;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }




    @Override
    public void stopBall() {

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
        public BallBuilder setDireccion(int a) {
            this.anguloB=a;
            return this;
        }


    }

}
