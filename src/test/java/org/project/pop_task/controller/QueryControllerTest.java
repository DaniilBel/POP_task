package org.project.pop_task.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.project.pop_task.event.TicketClosedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.project.pop_task.handler.EventHandlerService;
import org.project.pop_task.model.TicketView;
import org.project.pop_task.repository.TenantViewRepository;
import org.project.pop_task.repository.TicketViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryControllerTest {
    @MockBean
    private TicketViewRepository ticketViewRepository;

    @MockBean
    private TenantViewRepository tenantViewRepository;

    @Autowired
    private EventHandlerService eventHandlerService;

    @Test
    public void testHandleTicketCreatedEvent() {
        TicketCreatedEvent event = new TicketCreatedEvent();
        event.setTicketId("T1");
        event.setCategory("Bug");
        event.setDescription("Sample Description");
        event.setTenantId("Tenant1");

        eventHandlerService.handleTicketCreatedEvent(event);
        Mockito.verify(ticketViewRepository).save(Mockito.any(TicketView.class));
        Mockito.verify(tenantViewRepository).findByTenantId("Tenant1");
    }

    @Test
    public void testHandleTicketClosedEvent() {
        TicketClosedEvent event = new TicketClosedEvent();
        event.setTicketId("T2");
        event.setTenantId("Tenant1");

        eventHandlerService.handleTicketClosedEvent(event);
        Mockito.verify(ticketViewRepository).findById("T2");
        Mockito.verify(tenantViewRepository).findByTenantId("Tenant1");
    }
}
