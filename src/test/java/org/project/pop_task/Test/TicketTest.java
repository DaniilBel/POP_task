package org.project.pop_task.Test;
import org.junit.jupiter.api.Test;
import org.project.pop_task.model.Ticket;
import org.project.pop_task.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    @Test
    void testCloseTicket() {
        Ticket ticket = new Ticket("Bug", "Critical issue");
        ticket.close();
        assertEquals("Closed", ticket.getStatus());
    }

    @Test
    void testOpenTicket() {
        Ticket ticket = new Ticket("Bug", "Critical issue");
        ticket.close();
        ticket.open();
        assertEquals("Open", ticket.getStatus());
    }

    @Test
    void testAssignAgent() {
        Ticket ticket = new Ticket("Bug", "Critical issue");
        User agent = new User(1, "Alice", "Agent");
        ticket.assignAgent(agent);
        assertEquals("Agent", agent.getRole());
    }
}
