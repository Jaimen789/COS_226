public class Threads extends Thread {
    Scrumboard scrumObj;

    private PetersonLock lock;

    Threads(Scrumboard obj, PetersonLock l) {
        scrumObj = obj;
        lock = l;
    }

    public void run() {

        String name = this.getName();
        lock.lock(name);
        try {
            for (int i = 0; i < 5; i++) {
                String currTask = scrumObj.returnNextTodo();
                System.out.println((String.format("%s", this.getName())) + " Task: " + currTask);
                scrumObj.Completed.add(currTask);
            }
        } finally {
            lock.unlock(name);
        }
    }

}
    

