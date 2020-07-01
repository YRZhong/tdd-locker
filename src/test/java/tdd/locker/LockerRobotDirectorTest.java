package tdd.locker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LockerRobotDirectorTest {
    @Test
    public void printTest() {
        Locker firstLocker = new Locker(5);
        Locker secondLocker = new Locker(7);
        firstLocker.store(new Bag());
        firstLocker.store(new Bag());
        secondLocker.store(new Bag());
        PrimaryLockerRobot firstRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker));
        PrimaryLockerRobot secondRobot = new PrimaryLockerRobot(Arrays.asList(secondLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.emptyList(), Arrays.asList(firstRobot, secondRobot));
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(Arrays.asList(lockerRobotManager));
        lockerRobotDirector.printStatistics();
    }
}