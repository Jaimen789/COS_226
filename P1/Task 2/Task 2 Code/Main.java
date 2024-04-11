public class Main {

    public static void main(String[] args){
        Scrumboard s = new Scrumboard();
    
        PetersonLock lock = new PetersonLock();
        Thread t1 = new Threads(s, lock);
        Thread t2 = new Threads(s, lock);

        t1.start();
        t2.start();

    }
}