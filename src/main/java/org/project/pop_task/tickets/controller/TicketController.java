package org.project.pop_task.tickets.controller;

import org.project.pop_task.tickets.dto.TicketRequest;
import org.project.pop_task.tickets.model.Ticket;
import org.project.pop_task.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequest request) {
        Ticket ticket = ticketService.createTicket(request);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/open")
    public ResponseEntity<List<Ticket>> getOpenTickets() {
        List<Ticket> openTickets = ticketService.getOpenTickets();
        return ResponseEntity.ok(openTickets);
    }

    @PostMapping("/close-inactive")
    public ResponseEntity<Void> closeInactiveTickets() {
        ticketService.closeInactiveTickets();
        return ResponseEntity.ok().build();
    }
}
