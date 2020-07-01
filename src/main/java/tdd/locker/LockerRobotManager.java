package tdd.locker;

import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LockerRobotManager extends AbsLockerRobot {

    private List<AbsLockerRobot> lockerRobots;


    public LockerRobotManager(List<Locker> lockers) {
        super(lockers);
        lockerRobots = Collections.emptyList();
    }

    public LockerRobotManager(List<Locker> lockers, List<AbsLockerRobot> lockerRobots) {
        super(lockers);
        this.lockerRobots = lockerRobots;
    }

    public Ticket store(Bag bag) {
        if (!this.ableToStore()) {
            throw new LockerIsFullException();
        }
        for (AbsLockerRobot absLockerRobot : lockerRobots) {
            if (absLockerRobot.ableToStore()) {
                return absLockerRobot.store(bag);
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
        for (AbsLockerRobot absLockerRobot : lockerRobots) {
            return absLockerRobot.fetch(ticket);
        }
        return super.fetch(ticket);
    }

    @Override
    public boolean ableToStore() {
        boolean lockerIsFull = super.ableToStore();
        boolean robotAbleToStore = lockerRobots.stream().anyMatch(robot -> robot.ableToStore());
        return lockerIsFull || robotAbleToStore;
    }

    @Override
    public boolean hasValidTicket(Ticket ticket) {
        boolean lockerHasValidTicket = super.hasValidTicket(ticket);
        boolean robotHasValidTicket = lockerRobots
                .stream()
                .anyMatch(robot -> robot.hasValidTicket(ticket));
        return lockerHasValidTicket || robotHasValidTicket;
    }

    public Map<String, Integer> getStatistics() {
        int availableCapacity = lockers.stream().mapToInt(item -> item.getAvailableCapacity()).sum()
                + lockerRobots.stream().mapToInt(item -> item.getStatistics().get("availableCapacity")).sum();
        int totalCapacity = lockers.stream().mapToInt(item -> item.getCapacity()).sum()
                + lockerRobots.stream().mapToInt(item -> item.getStatistics().get("totalCapacity")).sum();
        return ImmutableMap.of("availableCapacity", availableCapacity, "totalCapacity", totalCapacity);
    }

    public void printStatistics() {
        int availableCapacity = getStatistics().get("availableCapacity");
        int totalCapacity = getStatistics().get("totalCapacity");
        System.out.println("M " + availableCapacity + " " + totalCapacity);
        lockers.forEach(item -> {
            item.printStatistics(" ");
        });
        lockerRobots.forEach(item -> {
            item.printStatistics();
        });
    }
}