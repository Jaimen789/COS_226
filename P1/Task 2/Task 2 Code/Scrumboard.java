import java.util.ArrayList;

public class Scrumboard extends Thread {

	ArrayList<String> Todo = new ArrayList<String>(10);
	ArrayList<String> Completed = new ArrayList<String>(10);

	Scrumboard() {
		Todo.add("A");
		Todo.add("B");
		Todo.add("C");
		Todo.add("D");
		Todo.add("E");
		Todo.add("F");
		Todo.add("G");
		Todo.add("H");
		Todo.add("I");
		Todo.add("J");
		
		// for(int i = 0; i < 10; i++){
        //     Todo.add("" + (char)(i + 65));
        // }
	}
	
	public String returnNextTodo() {
		String answer = this.Todo.get(0);
		this.Todo.remove(answer);
		return answer;
		//return this.Todo.get(i);
	}

	public void storeInCompleted(String text) {
		this.Completed.add(text);
	}

}