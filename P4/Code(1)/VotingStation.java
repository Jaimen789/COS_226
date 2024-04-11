import java.util.concurrent.locks.Lock;

import spin.Timeout;

public class VotingStation extends Thread {
    Lock l = new Timeout();
	private int value;

	public void castBallot(){
		int rand = (int)Math.floor(Math.random()*(1000-200+1)+200);
		l.lock();
		System.out.println("[" + this.getName()+"]" + "["+ "Person number: " + value + "]"+ " entered the voting station");
		try{
			
			System.out.println("[" + Thread.currentThread().getName() +"]" + "["+ "Person number: "+ value + "]"+ " cast a vote.");
			try{Thread.sleep(rand);}catch(InterruptedException e){}	//Math.round(random_int)
			System.out.println("Queue: " + "{" + Thread.currentThread().getName()  + ":" + value + "}");
			value++;
		}
		finally
		{	
			l.unlock();
		}
	}

}
