package tdd.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private int availableCapacity;
    private Map<Ticket, Bag> storedBags = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (availableCapacity <= 0) {
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        storedBags.put(ticket, bag);
        availableCapacity--;
        return ticket;
    }

    public Bag fetch(Ticket ticket) {
        Bag bag = storedBags.get(ticket);
        if (bag == null) {
            throw new InvalidTicketException();
        }
        storedBags.remove(ticket);
        return bag;
    }

    public Boolean hasCapacity() {
        return  availableCapacity > 0;
    }

    public Boolean isContainsGivenBag(Ticket ticket) {
        return storedBags.containsKey(ticket);
    }
}
