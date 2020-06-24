package tdd.locker;

import java.util.List;

public class LockerRobotManager extends AbsLockerRobot {
    public LockerRobotManager(List<Locker> lockers) {
        super(lockers);
    }

    public Ticket store(Bag bag) {
        for (Locker locker : lockers) {
            if (locker.hasCapacity()) {
                return locker.store(bag);
            }
        }
        return lockers.get(0).store(bag);
    }
}
