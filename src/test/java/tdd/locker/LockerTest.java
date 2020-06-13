package tdd.locker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerTest {

    @Test
    void should_return_ticket_when_store_bag_given_locker_has_10_space() {
        Bag bag = new Bag();
        Locker locker = new Locker();
        Ticket ticket = locker.store(10);
        assertNotNull(ticket);
    }
}
