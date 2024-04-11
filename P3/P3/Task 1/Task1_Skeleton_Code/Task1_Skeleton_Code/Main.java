public class Main {
    public static void main(String[] args)
    {
        RMWConsensus c = new RMWConsensus(2);

        ConsensusThread one = new ConsensusThread(c);
        ConsensusThread two = new ConsensusThread(c);

        one.run();
        two.run();
    }
}
