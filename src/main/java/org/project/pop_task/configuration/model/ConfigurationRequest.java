package org.project.pop_task.configuration.model;

import java.util.Set;

public class ConfigurationRequest {

    private String category;
    private Set<String> products;

    public ConfigurationRequest() {}

    public ConfigurationRequest(String category, Set<String> products) {
        this.category = category;
        this.products = products;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<String> getProducts() {
        return products;
    }

    public void setProducts(Set<String> products) {
        this.products = products;
    }
}
