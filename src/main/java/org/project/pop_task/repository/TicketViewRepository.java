package org.project.pop_task.repository;

import org.project.pop_task.model.TicketView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketViewRepository extends JpaRepository<TicketView, Integer> {
    List<TicketView> findByAssignedAgent(String agentName);
    List<TicketView> findByStatus(String status);
}