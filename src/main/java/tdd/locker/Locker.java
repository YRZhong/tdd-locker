package tdd.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker implements ILocker {
    private int availableCapacity;
    private Map<Ticket, Bag> storedBags = new HashMap<>();

    public Locker(int capacity) {
        this.availableCapacity = capacity;
    }

    @Override
    public Ticket store(Bag bag) {
        if (availableCapacity <= 0) {
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        storedBags.put(ticket, bag);
        availableCapacity--;
        return ticket;
    }

    @Override
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
}
