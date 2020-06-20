package tdd.locker;

import java.util.List;

public class LockerRobot extends AbsLockerRobot {

    public LockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket store(Bag bag) {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockers.get(i).hasCapacity()) {
                return lockers.get(i).store(bag);
            }
        }
        throw new LockerIsFullException();
    }

    @Override
    public Bag fetch(Ticket ticket) {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockers.get(i).isContainsGivenBag(ticket)) {
                return lockers.get(i).fetch(ticket);
            }
        }
        throw new InvalidTicketException();
    }

}
