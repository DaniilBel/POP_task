package org.project.pop_task.agents.dto;

public class AgentScheduleResponse {

    private Long agentId;
    private String message;

    public AgentScheduleResponse(Long agentId, String message) {
        this.agentId = agentId;
        this.message = message;
    }

    public Long getAgentId() {
        return agentId;
    }

    public String getMessage() {
        return message;
    }
}
