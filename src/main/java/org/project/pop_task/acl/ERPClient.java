package org.project.pop_task.acl;

import org.project.pop_task.acl.models.ERPResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ERPClient {

    private final RestTemplate restTemplate;
    private final String erpBaseUrl;

    public ERPClient() {
        this.restTemplate = new RestTemplate();
        this.erpBaseUrl = "https://api.erp-system.com"; // Replace with the actual ERP API base URL
    }

    public ERPClient(RestTemplate restTemplate, String erpBaseUrl) {
        this.restTemplate = restTemplate;
        this.erpBaseUrl = erpBaseUrl;
    }

    public ERPResponse fetchResourceData(String resourceId) {
        String url = UriComponentsBuilder.fromHttpUrl(erpBaseUrl)
                .pathSegment("resources", resourceId)
                .toUriString();

        return restTemplate.getForObject(url, ERPResponse.class);
    }
}
