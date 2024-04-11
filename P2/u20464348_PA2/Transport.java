public class Transport extends Thread {
    Venue destination;
	String threadName;
	Thread t;
	public Transport(Venue dest,String temp){
		destination = dest;	
		threadName = temp;
	}

	@Override
	public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("BUS (" + threadName + ") is waiting to drop-off: Load " + i);
            destination.dropOff(i);
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
