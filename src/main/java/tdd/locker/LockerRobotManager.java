package tdd.locker;

import java.util.List;

public class LockerRobotManager extends AbsLockerRobot {

    private List<AbsLockerRobot> lockerRobots;

    public LockerRobotManager(List<Locker> lockers) {
        super(lockers);
    }

    public LockerRobotManager(List<Locker> lockers, List<AbsLockerRobot> lockerRobots) {
        super(lockers);
        this.lockerRobots = lockerRobots;
    }

    public Ticket store(Bag bag) {
        if (lockerRobots != null) {
            for (AbsLockerRobot absLockerRobot : lockerRobots) {
                try {
                    Ticket ticket = absLockerRobot.store(bag);
                    return ticket;
                } catch (LockerIsFullException e) {
                }
            }
        }
        for (Locker locker : lockers) {
            if (locker.hasCapacity()) {
                return locker.store(bag);
            }
        }
        return lockers.get(0).store(bag);
    }
}
