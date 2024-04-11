public class Main { 

    public static void main(String[] args) {
	    Marshal[] queues = new Marshal[4];

        VotingStation vs = new VotingStation();

        for(int i = 0; i < 4; i++)
            queues[i] = new Marshal(vs);

        for(Marshal queue : queues)
            queue.start();
    }
}
