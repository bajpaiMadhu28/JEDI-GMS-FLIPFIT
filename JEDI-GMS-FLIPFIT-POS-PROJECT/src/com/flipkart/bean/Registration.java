package com.flipkart.bean;

public class Registration {
    private String username;
    private String password;
    private String userType;  // Indicates the type of user (e.g., "Customer", "GymOwner", "Admin")
    private String userId;    // ID associated with the specific type of user

    // Constructor
    public Registration(String username, String password, String userType, String userId) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.userId = userId;
    }

    // Getter and setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
