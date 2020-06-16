package tdd.robot.locker;

import org.junit.jupiter.api.Test;
import tdd.locker.Bag;
import tdd.locker.Locker;
import tdd.locker.Robot;
import tdd.locker.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RobotLocker {
    @Test
    void should_return_ticket_when_store_bag_given_first_locker_has_space() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        Robot robot = new Robot(Arrays.asList(locker1, locker2));
        Bag bag = new Bag();
        Ticket ticket = robot.store(bag);
        assertNotNull(ticket);
        assertSame(bag, locker1.fetch(ticket));
    }
}
