package org.project.pop_task.event;

public class AgentAssignedEvent {
    private String ticketId;
    private String agentId;

    public AgentAssignedEvent(String ticketId, String agentId) {
        this.ticketId = ticketId;
        this.agentId = agentId;
    }

    public String getTicketId() { return ticketId; }
    public String getAgentId() { return agentId; }
}
