import java.awt.*;
import java.util.Stack;

public abstract class AbstractObjectPool implements IObjectPool{

    protected int max;
    protected int min;
    protected Stack<IPoolableObject> lockedPool;
    protected Stack<IPoolableObject> unlockedPool;


    @Override
    public abstract IPoolableObject getObject();

    @Override
    public abstract void releaseObject(IPoolableObject object);

    protected abstract IPoolableObject createObject(Color pColor, int pDireccion, int pVelocidad);
}
