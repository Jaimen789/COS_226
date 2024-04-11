import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Semaphore {
    final int capacity;
    int state;
    Lock lock;
    Condition condition;

    public Semaphore(int c) 
    {
    capacity = c;
     state = 0;
    lock = new ReentrantLock();
    condition = lock.newCondition();
    }

    public void acquire() 
    {
     lock.lock();
    try {
    while (state == capacity) 
    {
     condition.await();
    }
     state++;
    } catch (InterruptedException e) {
        e.printStackTrace();
    } 
    finally 
    {
     lock.unlock();
     }
    }

    public void release() {
     lock.lock();
    try {
     state--;
     condition.signalAll();
     } finally 
    {
    lock.unlock();
    }
 }
}
