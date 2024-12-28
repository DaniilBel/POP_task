package org.project.pop_task.agents.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.pop_task.agents.dto.AgentScheduleRequest;
import org.project.pop_task.agents.dto.AgentScheduleResponse;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgentServiceTest {

    private AgentService agentService;

    @BeforeEach
    void setup() {
        agentService = new AgentService();
    }

    @Test
    void testAddOrUpdateAgentShift() {
        AgentScheduleRequest request = new AgentScheduleRequest(1L, LocalTime.of(9, 0), LocalTime.of(17, 0));

        AgentScheduleResponse response = agentService.addOrUpdateAgentShift(request);

        assertEquals(1L, response.getAgentId());
        assertEquals("Shift successfully added/updated", response.getMessage());
    }

    @Test
    void testGetAvailableAgents() {
        agentService.addOrUpdateAgentShift(new AgentScheduleRequest(1L, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        agentService.addOrUpdateAgentShift(new AgentScheduleRequest(2L, LocalTime.of(8, 0), LocalTime.of(16, 0)));

        List<Long> availableAgents = agentService.getAvailableAgents(LocalTime.of(10, 0));

        assertTrue(availableAgents.contains(1L));
        assertTrue(availableAgents.contains(2L));
    }

    @Test
    void testGetNoAvailableAgents() {
        agentService.addOrUpdateAgentShift(new AgentScheduleRequest(1L, LocalTime.of(9, 0), LocalTime.of(17, 0)));

        List<Long> availableAgents = agentService.getAvailableAgents(LocalTime.of(18, 0));

        assertTrue(availableAgents.isEmpty());
    }

    @Test
    void testRemoveAgentShift() {
        agentService.addOrUpdateAgentShift(new AgentScheduleRequest(1L, LocalTime.of(9, 0), LocalTime.of(17, 0)));

        String response = agentService.removeAgentShift(1L);

        assertEquals("Agent shift removed successfully.", response);
    }

    @Test
    void testRemoveNonexistentAgentShift() {
        String response = agentService.removeAgentShift(99L);

        assertEquals("Agent shift not found.", response);
    }
}
