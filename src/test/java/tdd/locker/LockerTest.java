package tdd.locker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {

    @Test
    void should_return_ticket_when_store_bag_given_locker_has_10_space() throws ErrorMessageException {
        Bag bag = new Bag();
        Locker locker = new Locker(10);
        Ticket ticket = locker.store(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_throw_error_when_store_bag_given_locker_has_no_space() throws ErrorMessageException {
        Locker locker = new Locker(1);
        locker.store(new Bag());

        Bag bag = new Bag();
        Exception exception = assertThrows(ErrorMessageException.class, () -> locker.store(bag));
        String errorMsg = exception.getMessage();
        assertEquals("no space", errorMsg);
    }

    @Test
    void should_get_correct_bag_when_fetch_bag_given_ticket_is_valid() throws ErrorMessageException {
        Bag storedBag = new Bag();
        Locker locker = new Locker(2);
        Ticket ticket = locker.store(storedBag);
        Bag fetchedBag = locker.fetch(ticket);
        assertEquals(System.identityHashCode(storedBag), System.identityHashCode(fetchedBag));
    }

    @Test
    void should_throw_err_when_fetch_bag_given_ticket_is_invalid() throws ErrorMessageException {
        Locker locker = new Locker(2);
        Ticket ticket = new Ticket();
        Exception exception = assertThrows(ErrorMessageException.class, () -> locker.fetch(ticket));
        String errorMsg = exception.getMessage();
        assertEquals("invalid ticket", errorMsg);
    }

    @Test
    void should_throw_err_when_fetch_bag_given_ticket_is_used() throws ErrorMessageException {
        Bag bag = new Bag();
        Locker locker = new Locker(11);
        Ticket ticket = locker.store(bag);
        locker.fetch(ticket);
        Exception exception = assertThrows(ErrorMessageException.class, () -> locker.fetch(ticket));
        String errorMsg = exception.getMessage();
        assertEquals("invalid ticket", errorMsg);
    }
}
