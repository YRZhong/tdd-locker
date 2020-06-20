package tdd.locker;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SmartLockerRobotTest {
    @Test
    public void should_stored_in_first_locker_and_return_ticket_when_store_bag_given_first_locker_capacity_is_more_than_second_locker() {
        Locker firstLocker = new Locker(3);
        Locker secondLocker = new Locker(2);
        Bag bag = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, firstLocker.fetch(ticket));
    }

    @Test
    public void should_stored_in_second_locker_and_return_ticket_when_store_bag_given_first_locker_capacity_is_less_than_second_locker() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(3);
        Bag bag = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, secondLocker.fetch(ticket));
    }

    @Test
    public void should_stored_in_first_locker_and_return_ticket_when_store_bag_given_first_locker_capacity_equals_second_locker() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        Bag bag = new Bag();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket ticket = smartLockerRobot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, firstLocker.fetch(ticket));
    }

    @Test
    public void should_throw_locker_is_full_exception_when_store_bag_given_first_and_second_locker_are_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        Bag bag3 = new Bag();
        firstLocker.store(bag1);
        secondLocker.store(bag2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        assertThrows(LockerIsFullException.class, ()->smartLockerRobot.store(bag3));
    }

    @Test
    public void should_throw_invalid_ticket_exception_when_fetch_bag_given_invalid_ticket() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        assertThrows(InvalidTicketException.class, ()-> smartLockerRobot.fetch(new Ticket()));
    }

    @Test
    public void should_return_bag_when_fetch_bag_by_locker_robot_given_ticket_by_smart_locker_robot() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        LockerRobot lockerRobot = new LockerRobot(Arrays.asList(firstLocker, secondLocker));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.store(bag);
        assertSame(bag, lockerRobot.fetch(ticket));
    }
}
