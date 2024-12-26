package org.project.pop_task.acl;

import org.project.pop_task.acl.models.ResourceInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ERPResource {

    private final ERPService erpService;

    public ERPResource(ERPService erpService) {
        this.erpService = erpService;
    }

    @GetMapping("/erp/resource-availability")
    public ResponseEntity<ResourceInfo> getResourceAvailability(@RequestParam String resourceId) {
        try {
            ResourceInfo resourceInfo = erpService.checkResourceAvailability(resourceId);
            return ResponseEntity.ok(resourceInfo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
