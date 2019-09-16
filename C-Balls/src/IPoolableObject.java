import java.awt.geom.Rectangle2D;

public interface IPoolableObject {
    void move(Rectangle2D bounds, int angulo);
    void stopBall();
}
