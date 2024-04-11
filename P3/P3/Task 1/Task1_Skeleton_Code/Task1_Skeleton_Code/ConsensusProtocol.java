public abstract class ConsensusProtocol<T> implements Consensus<T>
{
	public volatile Object[] proposed;
	public int ID;

	public ConsensusProtocol(int threadCount)
	{
		proposed = new Object[threadCount];
	}

	public void propose(T value)
	{
		proposed[ID] = value;
	}

	abstract public void decide();

	public Object getP()
	{
		return proposed[ID];
	}

	public void reset(int tc)
	{
		proposed = new Object[tc];
	}

	public void setID(int i)
	{
		this.ID = i;
	}
}
