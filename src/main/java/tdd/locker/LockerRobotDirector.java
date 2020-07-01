package tdd.locker;

import java.util.List;

public class LockerRobotDirector {
    private List<LockerRobotManager> lockerRobotManagers;

    public LockerRobotDirector(List<LockerRobotManager> lockerRobotManagers) {
        this.lockerRobotManagers = lockerRobotManagers;
    }

    public void printStatistics() {
        lockerRobotManagers.forEach(item -> {
            item.printStatistics();
        });
    }
}
