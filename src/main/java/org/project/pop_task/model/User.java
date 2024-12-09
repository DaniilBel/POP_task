package org.project.pop_task.model;

public class User {
    private int userId;
    private String userName;
    private String role;

    public User(int userId, String userName, String role) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }
}
