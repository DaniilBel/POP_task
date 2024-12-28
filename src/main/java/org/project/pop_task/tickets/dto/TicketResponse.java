package org.project.pop_task.tickets.dto;

import lombok.Data;

@Data
public class TicketResponse {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String assignedAgentId;
}
