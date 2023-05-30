package Services;

public class Counter implements AutoCloseable {

    private int id = 3;

    public void add() {
        id++;
    }

    public int getId() {
        return id;
    }

    @Override
    public void close() {
        System.out.println("Counter closed this value: "+ this.id);
    }
}