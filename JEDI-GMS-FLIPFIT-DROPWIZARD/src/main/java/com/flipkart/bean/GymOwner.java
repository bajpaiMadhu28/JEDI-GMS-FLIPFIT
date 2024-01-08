package com.flipkart.bean;

/**
 * The GymOwner class extends the User class and represents a gym owner in the system.
 */
public class GymOwner extends User {

    // GymOwner-specific attributes
    private String ownerId; // Unique identifier for the gym owner
    private String ownerName; // Name of the gym owner
    // private String gymName; // (Note: Commented out as it's not currently in use)
    private String email; // Email address of the gym owner

    /**
     * Constructor to initialize a GymOwner object with relevant details.
     *
     * @param ownerName Name of the gym owner.
     * @param username  Username of the gym owner.
     * @param password  Password of the gym owner.
     * @param ownerId   Unique identifier for the gym owner.
     * @param email     Email address of the gym owner.
     */
    public GymOwner(String ownerName, String username, String password, String ownerId, String email) {
        super(username, password);
        this.ownerId = ownerId;
        // this.gymName = gymName; // (Note: Commented out as it's not currently in use)
        this.ownerName = ownerName;
        this.email = email;
    }

    // Getter and setter methods specific to GymOwner

    /**
     * Getter method to retrieve the unique identifier for the gym owner.
     *
     * @return The gym owner's unique identifier.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Setter method to set the unique identifier for the gym owner.
     *
     * @param ownerId The unique identifier to set for the gym owner.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Getter method to retrieve the name of the gym owner.
     *
     * @return The name of the gym owner.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Setter method to set the name of the gym owner.
     *
     * @param ownerName The name to set for the gym owner.
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Getter method to retrieve the email address of the gym owner.
     *
     * @return The email address of the gym owner.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method to set the email address of the gym owner.
     *
     * @param email The email address to set for the gym owner.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
