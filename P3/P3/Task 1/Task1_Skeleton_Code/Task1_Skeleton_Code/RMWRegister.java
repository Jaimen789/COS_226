public class RMWRegister<T> {
    private int value;

    RMWRegister(int v){
        this.value = v;
    }

    public int mumble(int v){ //get //can't be the same value of v
        return v * v;
    }

    public synchronized int getAndMumble(){ //GetandSet()
        int prior = this.value;
        this.value = mumble(value);
        return prior;
    }
}
