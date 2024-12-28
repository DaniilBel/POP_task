package org.project.pop_task.tickets.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.project.pop_task.tickets.dto.TicketRequest;
import org.project.pop_task.tickets.model.Ticket;
import org.project.pop_task.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicketController.class)
class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createTicketShouldReturnTicket() throws Exception {
        TicketRequest request = new TicketRequest();
        request.setTitle("Test Ticket");
        request.setDescription("This is a test ticket.");
        request.setCategory("General");

        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setCategory(request.getCategory());
        ticket.setStatus("OPEN");

        when(ticketService.createTicket(any(TicketRequest.class))).thenReturn(ticket);

        mockMvc.perform(post("/tickets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ticket.getId()))
                .andExpect(jsonPath("$.title").value(ticket.getTitle()))
                .andExpect(jsonPath("$.status").value(ticket.getStatus()));

        verify(ticketService, times(1)).createTicket(any(TicketRequest.class));
    }

    @Test
    void getOpenTicketsListOfTickets() throws Exception {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        ticket1.setStatus("OPEN");

        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);
        ticket2.setStatus("OPEN");

        when(ticketService.getOpenTickets()).thenReturn(List.of(ticket1, ticket2));

        mockMvc.perform(get("/tickets/open"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(ticketService, times(1)).getOpenTickets();
    }
}
