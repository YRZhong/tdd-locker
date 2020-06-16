package tdd.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private int availableCapacity;
    private Map<Integer, Bag> record = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (availableCapacity <= 0) {
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        record.put(System.identityHashCode(ticket), bag);
        availableCapacity--;
        return ticket;
    }

    public Bag fetch(Ticket ticket) throws ErrorMessageException {
        Bag bag = record.get(System.identityHashCode(ticket));
        if (bag == null) {
            throw new InvalidTicketException();
        }
        record.remove(System.identityHashCode(ticket));
        return bag;
    }
}
