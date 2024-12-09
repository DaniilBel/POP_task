package org.project.pop_task.viewmodel;

import org.project.pop_task.model.Ticket;
import org.project.pop_task.model.User;
import org.project.pop_task.service.TicketService;

import java.util.ArrayList;
import java.util.List;

public class TicketViewModel {
    private List<Ticket> tickets;

    public TicketViewModel() {
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void closeTicket(int ticketId) {
        tickets.stream()
                .filter(ticket -> ticket.getTicketId() == ticketId)
                .findFirst()
                .ifPresent(ticket -> ticket.setStatus("Closed"));
    }
}
