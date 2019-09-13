public interface IObjectPool {
    IPoolableObject getObject();
    IPoolableObject releaceObject();
}
