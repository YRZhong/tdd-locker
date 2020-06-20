package tdd.locker;

import java.util.List;

public class SmartLockerRobot {

    private List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        int maxCapacity = -1;
        Locker maxCapacityLocker = null;
        for (Locker locker: lockers) {
            if (locker.getAvailableCapacity() > maxCapacity) {
                maxCapacity = locker.getAvailableCapacity();
                maxCapacityLocker = locker;
            }
        }
        return maxCapacityLocker.store(bag);
    }

    public Bag fetch(Ticket ticket) {
        for (int i=0; i < lockers.size(); i++) {
            if (lockers.get(i).isContainsGivenBag(ticket)) {
                return lockers.get(i).fetch(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
