import java.util.concurrent.locks.Lock;

public class Venue {
    Lock l = new Filter(5);

	public void dropOff(int i){
        l.lock();
        int random = (int) ((Math.random()) * (1000 - 200) + 200);

        try {
            System.out.println("BUS (" + Thread.currentThread().getName() + ") is dropping off: Load " + i);
            Thread.sleep(random);
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        finally {
            System.out.println("BUS (" + Thread.currentThread().getName() + ") has left: Load " + i);
            l.unlock();
        }
    }
}
