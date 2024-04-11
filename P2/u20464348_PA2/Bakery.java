import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
// Name: Jaimen Govender
// Student Number: u20464348

public class Bakery implements Lock 
{
	boolean[] flag;
	int[] label;

	int t1 =0;
	int t2 =0;

	public Bakery (int n){
		t1 =n;
    	flag = new boolean[n];
    	label = new int[n];
    	for (int i = 0; i<n; i++){
        	flag[i] = false;
        	label[i] = 0;
    	}
	}
	
public void lock()
{
    int i = Character.getNumericValue(Thread.currentThread().getName().charAt(7));
	t2 = i;
    flag[i] = true;
	int max = label[0];

	for( int loop = 0; loop < t1;loop++){
		if(max<label[i]) {
			max = label[i];
		}
	}
	label[i] = max;
	for(int k= 0; k< t1; k++){
    	while((flag[k] && (label[k]<label[i]))){
		
		}
	}
}
public void unlock(){
    flag[t2]=false;
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
