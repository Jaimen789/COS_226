public interface Consensus<T>
{
	void decide();
	void propose(T value);
	Object getP();
	void reset(int i);
	void setID(int i);
}
