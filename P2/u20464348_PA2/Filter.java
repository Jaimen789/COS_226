import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Jaimen Govender
// Student Number: u20464348

class Filter implements Lock
 {
	 AtomicInteger[] level;
	 AtomicInteger[] victim;
	 int n;
	 public Filter(int n) 
	 {
		 this.n = n;
	     level = new AtomicInteger[n];
	     victim = new AtomicInteger[n]; // use 1..n-1
	     for (int i = 0; i < n; i++) {
			level[i] = new AtomicInteger();
			victim[i] = new AtomicInteger();
		}
 	}
	 public void lock() 
	 {
	     int me = Character.getNumericValue(Thread.currentThread().getName().charAt(7));
	     for (int i = 1; i < n; i++) {
	     	level[me].set(i);
	     	victim[i].set(me);
			for (int k = 0; k < n; k++) {
				while ((k != me) && (level[k].get() >= i && victim[i].get() == me)) {}
			}
	     }
	}

	 public void unlock() 
	 {
	     int me = Character.getNumericValue(Thread.currentThread().getName().charAt(7));
	     level[me].set(0);
	 }
	public void lockInterruptibly() throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock()
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	public Condition newCondition()
	{
		throw new UnsupportedOperationException();
	}

}
