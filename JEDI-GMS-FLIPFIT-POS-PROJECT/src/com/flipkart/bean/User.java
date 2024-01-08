package com.flipkart.bean;

/**
 * The User class represents a generic user in the system.
 */
public class User {

    // Attributes related to a user
    private String username; // Username of the user
    private String password; // Password of the user

    /**
     * Constructor to initialize a User object with relevant details.
     *
     * @param username Username of the user.
     * @param password Password of the user.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and setter methods for User attributes

    /**
     * Getter method to retrieve the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method to set the username of the user.
     *
     * @param username The username to set for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method to retrieve the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method to set the password of the user.
     *
     * @param password The password to set for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

