public interface IObjectPool {
    IPoolableObject getObject();
    void releaseObject(IPoolableObject object);
}
