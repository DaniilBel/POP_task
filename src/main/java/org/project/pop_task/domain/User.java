package org.project.pop_task.domain;

public class User {
    private String userId;
    private String userName;
    private String role;

    public User(String userId, String userName, String role) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }
}
