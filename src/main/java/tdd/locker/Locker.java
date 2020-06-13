package tdd.locker;

public class Locker {
    private final int space;
    public Locker(int space) {
        this.space = space;
    }
    public Ticket store(Bag bag) {
        return new Ticket();
    }
}
