package tdd.locker;

import java.util.List;

public class PrimaryLockerRobot extends AbsLockerRobot {

    public PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket store(Bag bag) {
        if (!ableToStore()) {
            throw new LockerIsFullException();
        }
        for (int i = 0; i < lockers.size(); i++) {
            if (lockers.get(i).hasCapacity()) {
                return lockers.get(i).store(bag);
            }
        }
        return null;
    }
}
