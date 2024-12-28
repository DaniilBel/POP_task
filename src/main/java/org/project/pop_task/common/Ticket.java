package org.project.pop_task.common;

import lombok.Data;

@Data
public class Ticket {
    private Long id;
    private String category;
    private String status;
    private Agent assignedAgent;
}
