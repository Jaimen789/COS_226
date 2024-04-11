//A class that implements a thread, which must consist of: A variable to hold a reference to a Scrumboard object
public class MyThread extends Thread{
    Scrumboard scrumboardObject;
    
    //A constructor that takes a reference to a Scrumboard object and a string representing the name of the thread
    MyThread(Scrumboard scrumboard){
        scrumboardObject = scrumboard;
    }
    
    //A method that runs the thread
    public void run(){
        for(int i = 0; i < 5; i++){
            //System.out.println("Thread: " + threadName + ", " + i);   
            String nextTodo = scrumboardObject.getNextTodo();
            System.out.println("Thread-" + this.getName() + " Task: " + nextTodo);
            //System.out.println("Thread: " + threadName + " is adding to completed.");
            scrumboardObject.addCompleted(nextTodo);
        }
    }
}


    