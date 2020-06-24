package tdd.locker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        lockerRobotManager.store(new Bag());
        Ticket ticket = lockerRobotManager.store(bag);

        assertNotNull(ticket);
        assertSame(bag, secondLocker.fetch(ticket));
    }

    /**
     * given LockerRobotManager 管理的两个 locker 有位置，管理的两个 robot 的 locker 位置，包，
     * when 存包，then 存入第一个robot的locker，返回 ticket。
     */
    @Test
    public void should_get_ticket_and_use_1st_robot_to_store_when_store_bag_given_two_lockers_and_two_robots_have_capacity() {
        Locker firstLocker = new Locker(5);
        Locker secondLocker = new Locker(5);
        Locker robotLocker1 = new Locker(5);
        Locker robotLocker2 = new Locker(5);
        AbsLockerRobot absLockerRobot1 = new PrimaryLockerRobot(Arrays.asList(robotLocker1));
        AbsLockerRobot absLockerRobot2 = new SmartLockerRobot(Arrays.asList(robotLocker2));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker),
                Arrays.asList(absLockerRobot1, absLockerRobot2));
        Bag bag = new Bag();

        Ticket ticket = lockerRobotManager.store(bag);

        assertNotNull(ticket);
        assertSame(bag, robotLocker1.fetch(ticket));
    }

    /**
     * given LockerRobotManager 管理的两个 locker 有位置，管理的第一个 robot 没有有位置，第二个 robot 有位置，包，
     * when 存包，then 存入第二个robot的locker，返回 ticket。
     */
    @Test
    public void should_get_ticket_and_use_2nd_robot_to_store_when_store_bag_given_two_lockers_and_1st_robot_has_capacity_and_2nd_robot_has_not_full() {
        Locker firstLocker = new Locker(5);
        Locker secondLocker = new Locker(5);
        Locker robotLocker1 = new Locker(1);
        Locker robotLocker2 = new Locker(5);
        AbsLockerRobot absLockerRobot1 = new PrimaryLockerRobot(Arrays.asList(robotLocker1));
        AbsLockerRobot absLockerRobot2 = new SmartLockerRobot(Arrays.asList(robotLocker2));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker),
                Arrays.asList(absLockerRobot1, absLockerRobot2));
        Bag bag = new Bag();

        lockerRobotManager.store(new Bag());
        Ticket ticket = lockerRobotManager.store(bag);

        assertNotNull(ticket);
        assertSame(bag, robotLocker2.fetch(ticket));
    }

    /**
     * given LockerRobotManager 和 管理的的 robot 的 locker 都没有位置，包，
     * when 存包，then 存包失败，提示柜子已经满了。
     */
    @Test
    public void should_throw_locker_is_full_exception_when_store_bag_give_lockers_and_robots_have_full() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        Locker robotLocker1 = new Locker(1);
        Locker robotLocker2 = new Locker(1);
        AbsLockerRobot absLockerRobot1 = new PrimaryLockerRobot(Arrays.asList(robotLocker1));
        AbsLockerRobot absLockerRobot2 = new SmartLockerRobot(Arrays.asList(robotLocker2));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker),
                Arrays.asList(absLockerRobot1, absLockerRobot2));
        Bag bag = new Bag();

        lockerRobotManager.store(new Bag());
        lockerRobotManager.store(new Bag());
        lockerRobotManager.store(new Bag());
        lockerRobotManager.store(new Bag());

        assertThrows(LockerIsFullException.class, () -> lockerRobotManager.store(bag));
    }

    /**
     * given LockerRobotManager ，有效的 ticket ， when 取包，then 取包成功。
     */
    @Test
    public void should_get_bag_when_fetch_bag_given_locker_robot_manager_and_ticket_is_valid(){
        Locker firstLocker = new Locker(5);
        Locker secondLocker = new Locker(5);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(firstLocker, secondLocker));
        Bag bag = new Bag();

        Ticket ticket = lockerRobotManager.store(bag);

        assertNotNull(ticket);
        assertSame(bag,lockerRobotManager.fetch(ticket));
    }
}
