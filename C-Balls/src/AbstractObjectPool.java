public abstract class AbstractObjectPool implements IObjectPool{

    protected int max;
    protected int min;
    protected int timeout;


    @Override
    public abstract IPoolableObject getObject();

    @Override
    public abstract IPoolableObject releaceObject();
}
