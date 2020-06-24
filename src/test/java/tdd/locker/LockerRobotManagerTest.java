package tdd.locker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class LockerRobotManagerTest {

    /**
     * given LockerRobotManager 管理的2 locker 都有位置，无管理的 robot，包，
     * when LockerRobotManager 存包，then 存包第一个locker成功，得到 ticket。
     */
    @Test
    public void should_get_ticket_and_store_1st_locker_when_store_bag_given_two_locker_has_available_capacity() {
        Locker firstLocker = new Locker(5);
        Locker secondLocker = new Locker(5);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker));
        Bag bag = new Bag();

        Ticket ticket = lockerRobotManager.store(bag);

        assertNotNull(ticket);
        assertSame(bag, firstLocker.fetch(ticket));
    }

    /**
     * given LockerRobotManager 管理的第一个locker 没有位置，第二个有位置，无管理的 robot，包，
     * when LockerRobotManager 存包，存包第2个locker成功，得到 ticket。
     */
    @Test
    public void should_get_ticket_and_store_2nd_locker_when_store_bag_given_1st_locker_full_and_2nd_locker_not_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(5);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker));
        Bag bag = new Bag();

        lockerRobotManager.store(bag);
        Ticket ticket = lockerRobotManager.store(bag);

        assertNotNull(ticket);
        assertSame(bag, secondLocker.fetch(ticket));
    }

}
