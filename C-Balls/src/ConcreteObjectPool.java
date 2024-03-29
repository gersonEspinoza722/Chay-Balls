import java.awt.*;
import java.util.Stack;

public class ConcreteObjectPool extends AbstractObjectPool{

    private static ConcreteObjectPool singleton;

    private ConcreteObjectPool() {
        this.lockedPool = new Stack<>();
        this.unlockedPool = new Stack<>();
    }

    public static ConcreteObjectPool getInstance(int pQuantity, Color pColor, int pDireccion, int pVelocidad){
        if(singleton == null){
            singleton = new ConcreteObjectPool();
            singleton.min = pQuantity;
            singleton.max = pQuantity+100;
            singleton.initialize(pQuantity, pColor, pDireccion, pVelocidad);
        }
        return singleton;
    }

    @Override
    public IPoolableObject getObject() {
        IPoolableObject object = null;
        if(unlockedPool.empty() == false){
            object = unlockedPool.pop();
            lockedPool.add(object);
        }
        return object;
    }

    @Override
    public void releaseObject(IPoolableObject object) {
        lockedPool.remove(object);
        unlockedPool.add(object);
    }

    protected IPoolableObject createObject(Color pColor, int pDireccion, int pVelocidad){
        IPoolableObject newObject = new Ball(pColor, pDireccion, pVelocidad);
        return newObject;
    }

    private void initialize(int pQuantity, Color pColor, int pDireccion, int pVelocidad){
        int needed = pQuantity - this.unlockedPool.size();
        for(int i = 0; i< needed; i ++){
            unlockedPool.add(createObject(pColor, pDireccion, pVelocidad));
        }
    }
}
