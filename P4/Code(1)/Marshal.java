public class Marshal extends Thread {

    VotingStation vs;

	Marshal(VotingStation _vs)
	{
		vs = _vs ;
	}

	int [] voters = new int[4];

	@Override
	public void run()
	{
		for(int i = 0; i < voters.length; i++)
		{
			vs.castBallot();
		}
	}
}
