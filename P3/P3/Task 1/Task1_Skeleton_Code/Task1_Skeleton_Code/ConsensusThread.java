public class ConsensusThread extends Thread
{
	private Consensus<Integer> consensus;

	ConsensusThread(Consensus<Integer> consensusObject)
	{
		consensus = consensusObject;
		this.consensus.setID(Character.getNumericValue(this.getName().charAt(this.getName().length()-1)));
	}

	public synchronized void run()
	{
		int p = (int)(Math.random()*(101)+100);
		System.out.println(this.getName()+" proposes: "+ p);
		this.consensus.propose(p);
		long w = (long)(Math.random()*(510)+500);
		try
		{
			this.notifyAll();
			this.wait(w);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(this.getName()+" current value is "+this.consensus.getP());
		this.consensus.decide();
		System.out.println(this.getName()+" decided "+this.consensus.getP());

	}

}
