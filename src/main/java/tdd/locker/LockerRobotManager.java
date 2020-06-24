package tdd.locker;

import java.util.List;

public class LockerRobotManager extends AbsLockerRobot {
    public LockerRobotManager(List<Locker> lockers) {
        super(lockers);
    }

    public Ticket store(Bag bag) {
        return lockers.get(0).store(bag);
    }
}
