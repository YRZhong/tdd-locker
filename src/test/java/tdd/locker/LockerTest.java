package tdd.locker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {

    @Test
    void should_return_ticket_when_store_bag_given_locker_has_10_space() {
        Bag bag = new Bag();
        Locker locker = new Locker(10);
        Ticket ticket = locker.store(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_throw_error_when_store_bag_given_locker_has_no_space() {
        Locker locker = new Locker(1);
        locker.store(new Bag());

        Bag bag = new Bag();
        assertThrows(LockerIsFullException.class, () -> locker.store(bag));
    }

    @Test
    void should_get_correct_bag_when_fetch_bag_given_ticket_is_valid() throws ErrorMessageException {
        Bag storedBag = new Bag();
        Locker locker = new Locker(2);
        Ticket ticket = locker.store(storedBag);
        Bag fetchedBag = locker.fetch(ticket);

        assertSame(storedBag, fetchedBag);
    }

    @Test
    void should_throw_err_when_fetch_bag_given_ticket_is_invalid() {
        Locker locker = new Locker(2);
        Ticket ticket = new Ticket();
        assertThrows(InvalidTicketException.class, () -> locker.fetch(ticket));
    }

    @Test
    void should_throw_err_when_fetch_bag_given_ticket_is_used() throws ErrorMessageException {
        Bag bag = new Bag();
        Locker locker = new Locker(11);
        Ticket ticket = locker.store(bag);
        locker.fetch(ticket);

        assertThrows(InvalidTicketException.class, () -> locker.fetch(ticket));
    }
}
