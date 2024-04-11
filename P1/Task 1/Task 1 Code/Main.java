public class Main {
    public static void main(String[] args) {
        Scrumboard scrumboard1 = new Scrumboard();
        MyThread T1 = new MyThread(scrumboard1);
        MyThread T2 = new MyThread(scrumboard1);
        
        T1.start();
        T2.start();

    }
}
