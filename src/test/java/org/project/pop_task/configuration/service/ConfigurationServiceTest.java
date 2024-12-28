package org.project.pop_task.configuration.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.pop_task.configuration.model.ConfigurationRequest;
import org.project.pop_task.configuration.model.ConfigurationResponse;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfigurationServiceTest {

    private ConfigurationService configurationService;

    @BeforeEach
    void setup() {
        configurationService = new ConfigurationService();
    }

    @Test
    void testAddOrUpdateConfiguration() {
        ConfigurationRequest request = new ConfigurationRequest("Software", Set.of("ProductA", "ProductB"));

        ConfigurationResponse response = configurationService.addOrUpdateConfiguration(request);

        assertEquals("Software", response.getCategory());
        assertEquals("Configuration added/updated successfully", response.getMessage());
    }

    @Test
    void testGetProductsByCategory() {
        configurationService.addOrUpdateConfiguration(new ConfigurationRequest("Hardware", Set.of("ProductX", "ProductY")));

        Set<String> products = configurationService.getProductsByCategory("Hardware");

        assertTrue(products.contains("ProductX"));
        assertTrue(products.contains("ProductY"));
    }

    @Test
    void testGetProductsByNonexistentCategory() {
        Set<String> products = configurationService.getProductsByCategory("Nonexistent");

        assertTrue(products.isEmpty());
    }

    @Test
    void testRemoveCategory() {
        configurationService.addOrUpdateConfiguration(new ConfigurationRequest("Software", Set.of("ProductA", "ProductB")));

        String response = configurationService.removeCategory("Software");

        assertEquals("Category removed successfully.", response);
    }

    @Test
    void testRemoveNonexistentCategory() {
        String response = configurationService.removeCategory("Nonexistent");

        assertEquals("Category not found.", response);
    }
}
