// Name: Aryan Ramnand
// Student Number: u20443626

public class Main {

    public static void main(String[] args) {
	    Queue[] queues = new Queue[2];

        Store store = new Store();

        for(int i = 0; i < 2; i++)
            queues[i] = new Queue(store);

        for(Queue queue : queues)
            queue.start();

    }
}
