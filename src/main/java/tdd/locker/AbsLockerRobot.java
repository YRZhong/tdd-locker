package tdd.locker;

import java.util.List;

public abstract class AbsLockerRobot implements ILocker {
    protected List<Locker> lockers;

    public AbsLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }
}
