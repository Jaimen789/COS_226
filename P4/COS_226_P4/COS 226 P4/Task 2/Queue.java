// Name: Aryan Ramnand
// Student Number: u20443626

public class Queue extends Thread
{
	Store store;

	public Queue(Store s){
		store = s;
	}

	int [] people = new int[5];  
	
	@Override
	public void run()
	{
		for(int i=0; i<people.length; i++)
		{
			store.enterStore();
		}
	}
}

