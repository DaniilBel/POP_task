package org.project.pop_task.agents.service;

import org.project.pop_task.agents.dto.AgentScheduleRequest;
import org.project.pop_task.agents.dto.AgentScheduleResponse;
import org.project.pop_task.agents.model.AgentShift;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AgentService {

    private final Map<Long, AgentShift> agentShifts = new HashMap<>();

    public AgentScheduleResponse addOrUpdateAgentShift(AgentScheduleRequest request) {
        AgentShift shift = new AgentShift(request.getAgentId(), request.getStartTime(), request.getEndTime());
        agentShifts.put(request.getAgentId(), shift);
        return new AgentScheduleResponse(request.getAgentId(), "Shift successfully added/updated");
    }

    public List<Long> getAvailableAgents(LocalTime queryTime) {
        return agentShifts.values().stream()
                .filter(shift -> shift.getStartTime().isBefore(queryTime) && shift.getEndTime().isAfter(queryTime))
                .map(AgentShift::getAgentId)
                .collect(Collectors.toList());
    }

    public String removeAgentShift(Long agentId) {
        if (agentShifts.remove(agentId) != null) {
            return "Agent shift removed successfully.";
        }
        return "Agent shift not found.";
    }
}
