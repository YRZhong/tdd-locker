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
        if (!this.ableToStore()) {
            throw new LockerIsFullException();
        }
        if (lockerRobots != null) {
            for (AbsLockerRobot absLockerRobot : lockerRobots) {
                if (absLockerRobot.ableToStore()) {
                    return absLockerRobot.store(bag);
                }
            }
        }
        for (Locker locker : lockers) {
            if (locker.hasCapacity()) {
                return locker.store(bag);
            }
        }
       return null;
    }

    @Override
    public Bag fetch(Ticket ticket) {
        if (lockerRobots != null) {
            for (AbsLockerRobot absLockerRobot : lockerRobots) {
                try {
                    return absLockerRobot.fetch(ticket);
                } catch (InvalidTicketException e) {
                }
            }
        }
        return super.fetch(ticket);
    }

    @Override
    public boolean ableToStore() {
        boolean lockerIsFull = super.ableToStore();
        boolean robotAbleToStore = false;
        if (lockerRobots != null) {
            robotAbleToStore = lockerRobots.stream().anyMatch(robot -> robot.ableToStore());
        }
        return lockerIsFull || robotAbleToStore;
    }
}
