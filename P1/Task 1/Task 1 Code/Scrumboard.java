import java.util.ArrayList;

public class Scrumboard {
    private ArrayList<String> Todo = new ArrayList<String>();
    private ArrayList<String> Completed = new ArrayList<String>();

    public Scrumboard(){
        //populate Todo array with letters A-J
        for(int i = 0; i < 10; i++){
            Todo.add("" + (char)(i + 65));
        }
        // Todo.add("A");
        // Todo.add("B");
        // Todo.add("C");
        // Todo.add("D");
        // Todo.add("E");
        // Todo.add("F");
        // Todo.add("G");
        // Todo.add("H");
        // Todo.add("I");
        // Todo.add("J");


    }

    //method that returns next item in todo list
    public String getNextTodo(){
        return Todo.remove(0);
    }
    

    //A method to store a single task into Completed list via passed parameters
    public void addCompleted(String task){
        //System.out.println("cOMPLETED list in fuction: " + Todo);
        //System.out.println("Completed task: " + task);
        Completed.add(task);
    }

    //You can add helper variables to access the two lists
    public ArrayList<String> getTodo(){
        return Todo;
    }

    public String getCompleted() {
        return Completed.toString();
    }
}