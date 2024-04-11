import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MCSQueue implements Lock {

    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myNode;

    public MCSQueue(){
        tail = new AtomicReference<QNode>(null);
        myNode = new ThreadLocal<QNode>() {
        protected QNode initialValue() { return new QNode();}
        };
     }
    
    @Override
    public void lock() {
        QNode qnode = myNode.get();
        QNode pred = tail.getAndSet(qnode);
        if (pred != null) {
        qnode.locked = true;
        pred.next = qnode;
        while (qnode.locked) {}
    }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unlock() {
    QNode qnode = myNode.get();
    if (qnode.next == null) {
    if (tail.compareAndSet(qnode, null))
    return;
    while (qnode.next == null) {}
    }
    qnode.next.locked = false;
    qnode.next = null;
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }
    
}
