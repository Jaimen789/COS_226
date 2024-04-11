import java.util.concurrent.locks.Lock;

// Name: Aryan Ramnand
// Student Number: U20443626

public class Store extends Thread
{
	Lock l = new MCS();
	private int value;
	
	public void enterStore()
	{
		int random_int = (int)Math.floor(Math.random()*(1000-200+1)+200);
		l.lock();
		System.out.println(this.getName()+" Person: "+value+" is trying to enter the store");	
		try{
			
			System.out.println(Thread.currentThread().getName()+" Person: "+value+" has entered the store");
			try{Thread.sleep(random_int);}catch(InterruptedException e){}	//Math.round(random_int)
			System.out.println(Thread.currentThread().getName()+" Person: "+value+" has left the store");
			value++;
		}
		finally
		{	
			l.unlock();
		}
	}	
}
