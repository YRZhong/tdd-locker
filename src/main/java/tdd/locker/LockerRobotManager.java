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
        if (!this.hasValidTicket(ticket)) {
            throw new InvalidTicketException();
        }
        if (lockerRobots != null) {
            for (AbsLockerRobot absLockerRobot : lockerRobots) {
                return absLockerRobot.fetch(ticket);
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

    @Override
    public boolean hasValidTicket(Ticket ticket) {
        boolean lockerHasValidTicket = super.hasValidTicket(ticket);
        boolean robotHasValidTicket = false;
        if (lockerRobots != null) {
            robotHasValidTicket = lockerRobots.stream().allMatch(robot -> robot.hasValidTicket(ticket));
        }
        return lockerHasValidTicket || robotHasValidTicket;
    }
}
