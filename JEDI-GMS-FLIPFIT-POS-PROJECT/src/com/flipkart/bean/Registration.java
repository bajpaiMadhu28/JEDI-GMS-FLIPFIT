package com.flipkart.bean;

/**
 * The Registration class represents user registration details in the system.
 */
public class Registration {

    // Attributes related to user registration
    private String username; // Username chosen during registration
    private String password; // Password chosen during registration
    private String userType; // Type of user (e.g., "Customer", "GymOwner", "Admin")
    private String userId; // ID associated with the specific type of user

    /**
     * Constructor to initialize a Registration object with relevant details.
     *
     * @param username Username chosen during registration.
     * @param password Password chosen during registration.
     * @param userType Type of user (e.g., "Customer", "GymOwner", "Admin").
     * @param userId   ID associated with the specific type of user.
     */
    public Registration(String username, String password, String userType, String userId) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.userId = userId;
    }

    // Getter and setter methods for Registration attributes

    /**
     * Getter method to retrieve the username chosen during registration.
     *
     * @return The username chosen during registration.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method to set the username chosen during registration.
     *
     * @param username The username to set for the registration.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method to retrieve the password chosen during registration.
     *
     * @return The password chosen during registration.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method to set the password chosen during registration.
     *
     * @param password The password to set for the registration.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method to retrieve the type of user (e.g., "Customer", "GymOwner", "Admin").
     *
     * @return The type of user.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Setter method to set the type of user (e.g., "Customer", "GymOwner", "Admin").
     *
     * @param userType The type of user to set for the registration.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Getter method to retrieve the ID associated with the specific type of user.
     *
     * @return The ID associated with the specific type of user.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method to set the ID associated with the specific type of user.
     *
     * @param userId The ID to set for the registration.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
