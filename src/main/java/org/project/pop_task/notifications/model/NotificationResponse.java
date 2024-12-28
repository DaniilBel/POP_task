package org.project.pop_task.notifications.model;

public class NotificationResponse {

    private boolean success;
    private String message;

    public NotificationResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
