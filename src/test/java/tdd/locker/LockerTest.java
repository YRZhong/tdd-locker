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
        Bag bag = new Bag();
        Locker locker = new Locker(0);
        Exception exception = assertThrows(ErrorMessageException.class, () -> locker.store(bag));
        String errorMsg = exception.getMessage();
        assertEquals("no space", errorMsg);
    }
}
