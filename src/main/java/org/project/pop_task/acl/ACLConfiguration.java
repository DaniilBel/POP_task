package org.project.pop_task.acl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ACLConfiguration {

    @Bean
    public CRMClient crmClient() {
        return new CRMClient(); // Initialize your CRM client
    }

    @Bean
    public ERPClient erpClient() {
        return new ERPClient(); // Initialize your ERP client
    }

    @Bean
    public CRMAdapter crmAdapter(CRMClient crmClient) {
        return new CRMAdapter(crmClient);
    }

    @Bean
    public ERPAdapter erpAdapter(ERPClient erpClient) {
        return new ERPAdapter(erpClient);
    }
}
