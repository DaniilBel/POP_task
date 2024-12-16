package org.project.pop_task.controller;

import org.project.pop_task.model.TenantView;
import org.project.pop_task.model.TicketView;
import org.project.pop_task.repository.TenantViewRepository;
import org.project.pop_task.repository.TicketViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/query")
public class QueryController {
    @Autowired
    private TicketViewRepository ticketViewRepository;

    @Autowired
    private TenantViewRepository tenantViewRepository;

    @GetMapping("/tickets/agent/{agentId}")
    public List<TicketView> getActiveTicketsForAgent(@PathVariable String agentId) {
        return ticketViewRepository.findByAssignedAgent(agentId);
    }

    @GetMapping("/tickets/tenant/{tenantId}")
    public List<TicketView> getActiveTicketsForTenant(@PathVariable String tenantId) {
        return ticketViewRepository.findByStatusAndTenantId("OPEN", tenantId);
    }

    @GetMapping("/tickets/closed/last7days/{tenantId}")
    public List<TicketView> getClosedTicketsLast7Days(@PathVariable String tenantId) {
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        return ticketViewRepository.findClosedTicketsLast7Days(tenantId, sevenDaysAgo);
    }

    @GetMapping("/tenant/{tenantId}")
    public TenantView getTenantInfo(@PathVariable String tenantId) {
        return tenantViewRepository.findByTenantId(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));
    }

    @PostMapping("/tickets")
    public TicketView createTicket(@RequestBody TicketView ticketView) {
        return ticketViewRepository.save(ticketView);
    }

    @PostMapping("/tenants")
    public TenantView createTenant(@RequestBody TenantView tenantView) {
        return tenantViewRepository.save(tenantView);
    }
}
