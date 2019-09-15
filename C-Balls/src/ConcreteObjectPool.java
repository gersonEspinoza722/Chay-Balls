import java.awt.*;
import java.util.Stack;

public class ConcreteObjectPool extends AbstractObjectPool{

    public ConcreteObjectPool(int pQuantity, Color pColor, int pDireccion, int pVelocidad) {
        this.min = pQuantity;
        this.max = pQuantity+100;
        this.lockedPool = new Stack<>();
        this.unlockedPool = new Stack<>();

        initialize(pQuantity, pColor, pDireccion, pVelocidad);
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
        for(int i = 0; i< pQuantity - this.unlockedPool.size(); i ++){
            unlockedPool.add(createObject(pColor, pDireccion, pVelocidad));
        }
    }
}
