package org.project.pop_task.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.pop_task.controller.QueryController;
import org.project.pop_task.model.TicketView;
import org.project.pop_task.repository.TicketViewRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QueryControllerTest {
    private TicketViewRepository repository;
    private QueryController controller;

    @BeforeEach
    void setUp() {
        repository = mock(TicketViewRepository.class);
        controller = new QueryController(repository);
    }

    @Test
    void shouldReturnAllActiveTickets() {
        List<TicketView> mockTickets = List.of(
                new TicketView(1, "IT", "Issue 1", "Open", "Agent1", 1001)
        );
        when(repository.findByStatus("Open")).thenReturn(mockTickets);

        List<TicketView> tickets = controller.getAllActiveTickets();
        assertEquals(1, tickets.size());
        assertEquals("IT", tickets.get(0).getCategory());
    }

    @Test
    void shouldReturnTicketsByAgent() {
        List<TicketView> mockTickets = List.of(
                new TicketView(1, "IT", "Issue 1", "Open", "Agent1", 1001)
        );
        when(repository.findByAssignedAgent("Agent1")).thenReturn(mockTickets);

        List<TicketView> tickets = controller.getTicketsByAgent("Agent1");
        assertEquals(1, tickets.size());
        assertEquals("Agent1", tickets.get(0).getAssignedAgent());
    }
}
