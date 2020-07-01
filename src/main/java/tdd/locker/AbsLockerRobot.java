package tdd.locker;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

public abstract class AbsLockerRobot {
    protected List<Locker> lockers;

    public AbsLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public abstract Ticket store(Bag bag);

    public Bag fetch(Ticket ticket) {
        if (!hasValidTicket(ticket)) {
            throw new InvalidTicketException();
        }
        for (int i = 0; i < lockers.size(); i++) {
            if (lockers.get(i).isContainsGivenBag(ticket)) {
                return lockers.get(i).fetch(ticket);
            }
        }
        return null;
    }

    public boolean ableToStore() {
        return lockers.stream().anyMatch(locker -> locker.hasCapacity());
    }

    public boolean hasValidTicket(Ticket ticket) {
        return lockers.stream().anyMatch(locker -> locker.isContainsGivenBag(ticket));
    }

    public Map<String, Integer> getStatistics() {
        int availableCapacity = lockers.stream().mapToInt(item -> item.getAvailableCapacity()).sum();
        int totalCapacity = lockers.stream().mapToInt(item -> item.getCapacity()).sum();
        return ImmutableMap.of("availableCapacity", availableCapacity, "totalCapacity", totalCapacity);
    }

}
