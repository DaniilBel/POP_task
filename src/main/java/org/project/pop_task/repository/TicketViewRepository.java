package org.project.pop_task.repository;

import org.project.pop_task.model.TicketView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TicketViewRepository extends JpaRepository<TicketView, String> {
    List<TicketView> findByAssignedAgent(String agentId);
    List<TicketView> findByStatusAndTenantId(String status, String tenantId);

    @Query(value = "SELECT t FROM TicketView t WHERE t.status = 'CLOSED' AND t.tenantId = :tenantId AND t.createdAt >= :startDate")
    List<TicketView> findClosedTicketsLast7Days(@Param("tenantId") String tenantId, @Param("startDate") LocalDate startDate);
}
