//import java.util.concurrent.locks.Lock;

// Name: Aryan Ramnand
// Student Number: U20443626

public class Store extends Thread
{
	//Lock l = new TTASLock();
	Semaphore s = new Semaphore(3);
	private int value;

	public void enterStore()
	{
		int random_int = (int)Math.floor(Math.random()*(1000-200+1)+200);
		s.acquire();
		System.out.println(this.getName()+" Person: "+value+" is trying to enter the store");	
		try{
			if((s.capacity-value) < 0)
			{
				System.out.println(Thread.currentThread().getName()+" Person: "+value+" has entered the store."+" Spaces remaining: 0");
			}
			else
			{
				System.out.println(Thread.currentThread().getName()+" Person: "+value+" has entered the store."+" Spaces remaining: "+((s.capacity-value)));
			}
			try{Thread.sleep(random_int);}catch(InterruptedException e){}	//Math.round(random_int)
			System.out.println(Thread.currentThread().getName()+" Person: "+value+" has left the store.");
			value++;
		}
		finally
		{	
			s.release();
		}
	}	
}
