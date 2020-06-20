package tdd.locker;

import java.util.List;

public class LockerRobot {

    private List<Locker> lockers;

    public LockerRobot(List<Locker> lockers) {

        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockers.get(i).hasCapacity()) {
                return lockers.get(i).store(bag);
            }
        }
        throw new LockerIsFullException();
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
