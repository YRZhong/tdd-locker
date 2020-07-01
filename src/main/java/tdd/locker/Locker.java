package tdd.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int availableCapacity;
    private int capacity;
    private Map<Ticket, Bag> storedBags = new HashMap<>();

    public Locker(int capacity) {
        this.availableCapacity = capacity;
        this.capacity = capacity;
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
        availableCapacity++;
        return bag;
    }

    public Boolean hasCapacity() {
        return availableCapacity > 0;
    }

    public Boolean isContainsGivenBag(Ticket ticket) {
        return storedBags.containsKey(ticket);
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
