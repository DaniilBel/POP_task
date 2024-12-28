package org.project.pop_task.configuration.service;

import org.project.pop_task.configuration.model.ConfigurationRequest;
import org.project.pop_task.configuration.model.ConfigurationResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ConfigurationService {

    private final Map<String, Set<String>> configurations = new HashMap<>();

    public ConfigurationResponse addOrUpdateConfiguration(ConfigurationRequest request) {
        configurations.put(request.getCategory(), request.getProducts());
        return new ConfigurationResponse(request.getCategory(), "Configuration added/updated successfully");
    }

    public Set<String> getProductsByCategory(String category) {
        return configurations.getOrDefault(category, new HashSet<>());
    }

    public String removeCategory(String category) {
        if (configurations.remove(category) != null) {
            return "Category removed successfully.";
        }
        return "Category not found.";
    }
}
