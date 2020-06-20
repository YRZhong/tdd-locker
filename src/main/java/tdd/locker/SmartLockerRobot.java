package tdd.locker;

import java.util.List;

public class SmartLockerRobot extends AbsLockerRobot {

    public SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket store(Bag bag) {
        int maxCapacity = -1;
        Locker maxCapacityLocker = null;
        for (Locker locker : lockers) {
            if (locker.getAvailableCapacity() > maxCapacity) {
                maxCapacity = locker.getAvailableCapacity();
                maxCapacityLocker = locker;
            }
        }
        return maxCapacityLocker.store(bag);
    }
}
