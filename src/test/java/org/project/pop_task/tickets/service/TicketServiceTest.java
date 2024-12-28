package org.project.pop_task.tickets.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.project.pop_task.tickets.client.AgentServiceClient;
import org.project.pop_task.tickets.client.FraudDetectionClient;
import org.project.pop_task.tickets.client.NotificationClient;
import org.project.pop_task.tickets.dto.TicketRequest;
import org.project.pop_task.tickets.model.Ticket;
import org.project.pop_task.tickets.repository.TicketRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private FraudDetectionClient fraudDetectionClient;

    @Mock
    private AgentServiceClient agentServiceClient;

    @Mock
    private NotificationClient notificationClient;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTicketShouldSaveAndAssignAgent() {
        TicketRequest request = new TicketRequest();
        request.setTitle("Test Ticket");
        request.setDescription("This is a test ticket.");
        request.setCategory("General");

        Ticket savedTicket = new Ticket();
        savedTicket.setId(1L);
        savedTicket.setTitle(request.getTitle());
        savedTicket.setDescription(request.getDescription());
        savedTicket.setCategory(request.getCategory());
        savedTicket.setStatus("OPEN");

        when(fraudDetectionClient.isFraudulent(anyString())).thenReturn(false);
        when(ticketRepository.save(any(Ticket.class))).thenReturn(savedTicket);
        when(agentServiceClient.assignAgent(anyString())).thenReturn("Agent123");

        Ticket result = ticketService.createTicket(request);

        assertNotNull(result);
        assertEquals("Agent123", result.getAssignedAgentId());
        verify(fraudDetectionClient, times(1)).isFraudulent(request.getDescription());
        verify(ticketRepository, times(2)).save(any(Ticket.class));
        verify(agentServiceClient, times(1)).assignAgent(request.getCategory());
        verify(notificationClient, times(1)).notifyAgent(eq("Agent123"), any(Ticket.class));
    }

    @Test
    void createTicketShouldThrowExceptionWhenFraudDetected() {
        TicketRequest request = new TicketRequest();
        request.setTitle("Spam Ticket");
        request.setDescription("This is a spam ticket.");

        when(fraudDetectionClient.isFraudulent(anyString())).thenReturn(true);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ticketService.createTicket(request)
        );
        assertEquals("Fraudulent content detected", exception.getMessage());
        verify(fraudDetectionClient, times(1)).isFraudulent(request.getDescription());
        verify(ticketRepository, never()).save(any(Ticket.class));
    }

    @Test
    void closeInactiveTickets() {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        ticket1.setStatus("PENDING");

        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);
        ticket2.setStatus("PENDING");

        when(ticketRepository.findByStatus("PENDING")).thenReturn(List.of(ticket1, ticket2));

        ticketService.closeInactiveTickets();

        assertEquals("CLOSED", ticket1.getStatus());
        assertEquals("CLOSED", ticket2.getStatus());
        verify(ticketRepository, times(2)).save(any(Ticket.class));
    }
}
