package org.project.pop_task.tickets.dto;

import lombok.Data;

@Data
public class TicketRequest {
    private String title;
    private String description;
    private String category;
}
