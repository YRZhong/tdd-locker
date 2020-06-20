package tdd.locker;

import java.util.List;

public abstract class AbsLockerRobot implements ILocker {
    protected List<Locker> lockers;

    public AbsLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
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
