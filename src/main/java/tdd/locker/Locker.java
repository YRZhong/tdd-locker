package tdd.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final int space;
    private Map<Integer, Bag> record = new HashMap<>();

    public Locker(int space) {
        this.space = space;
    }

    public Ticket store(Bag bag) throws ErrorMessageException {
        if (space <= 0) {
            throw new ErrorMessageException("no space");
        }
        Ticket ticket = new Ticket();
        record.put(System.identityHashCode(ticket), bag);
        return ticket;
    }

    public Bag fetch(Ticket ticket) throws ErrorMessageException {
        Bag bag = record.get(System.identityHashCode(ticket));
        if (bag == null) {
            throw new ErrorMessageException("invalid ticket");
        }
        record.remove(System.identityHashCode(ticket));
        return bag;
    }
}
