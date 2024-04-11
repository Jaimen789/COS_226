import java.util.concurrent.TimeUnit; //this import was not used but erros recieved when removed :(
import java.util.concurrent.locks.Condition; //this import was not used but erros recieved when removed :(
import java.util.concurrent.locks.Lock;

public class PetersonLock implements Lock {

    private volatile boolean[] flag = new boolean[2];
    private volatile int victim;

    public void lock(String sid) {
        int id = 0;
        if (sid == "Thread-1") {
            id = 0;
        }
        else {
            id = 1;
        }

        int i = id;
        int j = 1-id;
        flag[i] = true;
        victim = i;
        while (flag[j] && victim == i) {

        };
    }

    public void unlock(String sid) {
        // TODO Auto-generated method stub
        int id = 0;
        if (sid == "Thread-1") {
            id = 0;
        }
        else {
            id = 1;
        }

        flag[id] = false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public void unlock() {
        
    }

    @Override
    public void lock() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }



    
}