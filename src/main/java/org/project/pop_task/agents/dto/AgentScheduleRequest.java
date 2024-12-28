package org.project.pop_task.agents.dto;

import java.time.LocalTime;

public class AgentScheduleRequest {

    private Long agentId;
    private LocalTime startTime;
    private LocalTime endTime;

    public AgentScheduleRequest() {}

    public AgentScheduleRequest(Long agentId, LocalTime startTime, LocalTime endTime) {
        this.agentId = agentId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
