package org.project.pop_task.acl;

import org.project.pop_task.acl.models.CRMResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CRMClient {

    private final RestTemplate restTemplate;
    private final String crmBaseUrl;

    public CRMClient() {
        this.restTemplate = new RestTemplate();
        this.crmBaseUrl = "https://api.crm-system.com"; // Replace with the actual CRM API base URL
    }

    public CRMClient(RestTemplate restTemplate, String crmBaseUrl) {
        this.restTemplate = restTemplate;
        this.crmBaseUrl = crmBaseUrl;
    }

    public CRMResponse fetchClientData(String clientId) {
        String url = UriComponentsBuilder.fromHttpUrl(crmBaseUrl)
                .pathSegment("clients", clientId)
                .toUriString();

        return restTemplate.getForObject(url, CRMResponse.class);
    }
}
