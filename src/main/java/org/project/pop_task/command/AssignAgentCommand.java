package org.project.pop_task.command;

public class AssignAgentCommand {
    private String ticketId;
    private String agentId;

    public AssignAgentCommand(String ticketId, String agentId) {
        this.ticketId = ticketId;
        this.agentId = agentId;
    }

    public String getTicketId() { return ticketId; }
    public String getAgentId() { return agentId; }
}
