package org.project.pop_task.handler;

import org.project.pop_task.event.AgentAssignedEvent;
import org.project.pop_task.event.DiscountAppliedEvent;
import org.project.pop_task.event.TicketClosedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.project.pop_task.model.TicketView;
import org.project.pop_task.repository.TenantViewRepository;
import org.project.pop_task.repository.TicketViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@EnableAsync
public class EventHandlerService {
    @Autowired
    private TicketViewRepository ticketViewRepository;

    @Autowired
    private TenantViewRepository tenantViewRepository;

    @Async
    public void handleTicketCreatedEvent(TicketCreatedEvent event) {
        TicketView ticketView = new TicketView();
        ticketView.setTicketId(event.getTicketId());
        ticketView.setCategory(event.getCategory());
        ticketView.setDescription(event.getDescription());
        ticketView.setStatus("OPEN");
        ticketView.setTenantId(event.getTenantId());
        ticketView.setCreatedAt(new Date());
        ticketViewRepository.save(ticketView);

        tenantViewRepository.findByTenantId(event.getTenantId()).ifPresent(tenant -> {
            tenant.setOpenTicketCount(tenant.getOpenTicketCount() + 1);
            tenantViewRepository.save(tenant);
        });
    }

    @Async
    public void handleAgentAssignedEvent(AgentAssignedEvent event) {
        ticketViewRepository.findById(event.getTicketId()).ifPresent(ticket -> {
            ticket.setAssignedAgent(event.getAgentId());
            ticketViewRepository.save(ticket);
        });
    }

    @Async
    public void handleTicketClosedEvent(TicketClosedEvent event) {
        ticketViewRepository.findById(event.getTicketId()).ifPresent(ticket -> {
            ticket.setStatus("CLOSED");
            ticketViewRepository.save(ticket);
        });

        tenantViewRepository.findByTenantId(event.getTenantId()).ifPresent(tenant -> {
            tenant.setOpenTicketCount(tenant.getOpenTicketCount() - 1);
            tenantViewRepository.save(tenant);
        });
    }

    @Async
    public void handleDiscountAppliedEvent(DiscountAppliedEvent event) {
        tenantViewRepository.findByTenantId(event.getTenantId()).ifPresent(tenant -> {
            tenant.setDiscountRate(event.getDiscountRate());
            tenantViewRepository.save(tenant);
        });
    }
}
