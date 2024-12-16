package org.project.pop_task.repository;

import org.project.pop_task.model.TenantView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantViewRepository extends JpaRepository<TenantView, String> {
    Optional<TenantView> findByTenantId(String tenantId);
}
