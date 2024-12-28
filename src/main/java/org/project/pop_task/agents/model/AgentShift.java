package org.project.pop_task.agents.model;

import java.time.LocalTime;

public class AgentShift {

    private Long agentId;
    private LocalTime startTime;
    private LocalTime endTime;

    public AgentShift(Long agentId, LocalTime startTime, LocalTime endTime) {
        this.agentId = agentId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getAgentId() {
        return agentId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
