package tdd.locker;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartLockerRobotTest {
    @Test
    public void should_stored_in_first_locker_and_return_ticket_given_first_locker_capacity_is_more_than_second_locker() {
        Locker firstLocker = new Locker(3);
        Locker secondLocker = new Locker(2);
        Bag bag = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, firstLocker.fetch(ticket));
    }

    @Test
    public void should_stored_in_second_locker_and_return_ticket_given_first_locker_capacity_is_less_than_second_locker() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(3);
        Bag bag = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, secondLocker.fetch(ticket));
    }

    @Test
    public void should_stored_in_first_locker_and_return_ticket_given_first_locker_capacity_equals_second_locker() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        Bag bag = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, firstLocker.fetch(ticket));
    }
}
