package org.project.pop_task.configuration.model;

public class ConfigurationResponse {

    private String category;
    private String message;

    public ConfigurationResponse(String category, String message) {
        this.category = category;
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public String getMessage() {
        return message;
    }
}
