package tdd.locker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LockerRobotTest {
    @Test
    void should_return_ticket_when_store_bag_given_first_locker_has_space() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        LockerRobot lockerRobot = new LockerRobot(Arrays.asList(locker1, locker2));
        Bag bag = new Bag();
        Ticket ticket = lockerRobot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, locker1.fetch(ticket));
    }

    @Test
    void should_return_ticket_and_save_to_2th_locker_when_store_bag_given_second_locker_has_space() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        locker1.store(new Bag());
        LockerRobot lockerRobot = new LockerRobot(Arrays.asList(locker1, locker2));
        Bag bag = new Bag();
        Ticket ticket = lockerRobot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, locker2.fetch(ticket));
    }

    @Test
    void should_throw_error_when_store_bag_given_first_and_second_locker_is_full() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        locker1.store(new Bag());
        locker2.store(new Bag());
        LockerRobot lockerRobot = new LockerRobot(Arrays.asList(locker1, locker2));
        Bag bag = new Bag();
        assertThrows(LockerIsFullException.class, ()-> lockerRobot.store(bag));
    }

    @Test
    void should_get_bag_when_fetch_bag_given_valid_ticket() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        LockerRobot lockerRobot = new LockerRobot(Arrays.asList(locker1, locker2));
        Bag bag = new Bag();
        Ticket ticket = lockerRobot.store(bag);
        assertSame(bag, lockerRobot.fetch(ticket));
    }

    @Test
    void should_throw_error_when_fetch_bag_given_invalid_ticket() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        LockerRobot lockerRobot = new LockerRobot(Arrays.asList(locker1, locker2));
        Ticket ticket = new Ticket();
        assertThrows(InvalidTicketException.class, () -> lockerRobot.fetch(ticket));
    }
}
