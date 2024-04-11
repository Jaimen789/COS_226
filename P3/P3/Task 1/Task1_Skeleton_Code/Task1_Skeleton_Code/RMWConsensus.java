public class RMWConsensus extends ConsensusProtocol
{
    private RMWRegister r = new RMWRegister(-1);

    RMWConsensus(int tc)
    {
        super(tc);
    }

    @Override
    public void decide()
    {
        propose(proposed[ID]);
        if (r.getAndMumble() == -1)
        {
            if (ID == 0)
            {
                proposed[1] = proposed[0];
            }
            else if(ID == 1)
            {
                proposed[0] = proposed[1];
            }
        }
        else
        {
            if (ID == 0)
            {
                proposed[0] = proposed[1];
            }
            else if(ID == 1)
            {
                proposed[1] = proposed[0];
            }
        }
    }
}
