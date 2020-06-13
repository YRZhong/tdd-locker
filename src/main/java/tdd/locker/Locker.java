package tdd.locker;

public class Locker {
    private final int space;

    public Locker(int space) {
        this.space = space;
    }

    public Ticket store(Bag bag) throws ErrorMessageException {
        if (space <= 0) {
            throw new ErrorMessageException("no space");
        }
        return new Ticket();
    }

    public Bag fetch(Ticket ticket) {
        return new Bag();
    }
}
