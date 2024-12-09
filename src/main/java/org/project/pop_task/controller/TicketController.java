package org.project.pop_task.controller;

import org.project.pop_task.model.Ticket;
import org.project.pop_task.viewmodel.TicketViewModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class TicketController {
    private final TicketViewModel ticketViewModel = new TicketViewModel();

    @GetMapping("/tickets")
    public String showTickets(Model model) {
        model.addAttribute("tickets", ticketViewModel.getTickets());
        return "ticket";
    }

    @PostMapping("/tickets/create")
    public String createTicket(@RequestParam String category, @RequestParam String description) {
        Ticket ticket = new Ticket(category, description);
        ticketViewModel.addTicket(ticket);
        return "redirect:/tickets";
    }

    @PostMapping("/tickets/close")
    public String closeTicket(@RequestParam int ticketId) {
        ticketViewModel.closeTicket(ticketId);
        return "redirect:/tickets";
    }
}
