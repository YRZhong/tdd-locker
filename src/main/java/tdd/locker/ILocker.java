package tdd.locker;

public interface ILocker {
    Ticket store(Bag bag);

    Bag fetch(Ticket ticket);
}
