package tdd.locker;

import java.util.List;

public class Robot {

    private List<Locker> lockers;

    public Robot(List<Locker> lockers) {

        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        for (int i=0; i<lockers.size(); i++) {
            if (lockers.get(i).hasCapacity()) {
                return lockers.get(i).store(bag);
            }
        }
        return null;
    }
}
