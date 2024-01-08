package com.flipkart.bean;

/**
 * The Center class represents a center in the system, such as a facility or venue.
 */
public class Center {

    // Attributes related to a center
    private Integer centerId; // Unique identifier for the center
    private String name; // Name of the center
    private String location; // Location of the center
    private String ownerId; // Unique identifier for the owner of the center
    private boolean isApproved; // Flag indicating whether the center is approved or not

    /**
     * Constructor to initialize a Center object with relevant details.
     *
     * @param centerId  Unique identifier for the center.
     * @param name      Name of the center.
     * @param location  Location of the center.
     * @param ownerId   Unique identifier for the owner of the center.
     */
    public Center(Integer centerId, String name, String location, String ownerId) {
        this.centerId = centerId;
        this.name = name;
        this.location = location;
        this.ownerId = ownerId;
        this.isApproved = false; // Center is initially not approved
    }

    // Getter and setter methods for Center attributes

    /**
     * Getter method to retrieve the unique identifier for the center.
     *
     * @return The center's unique identifier.
     */
    public Integer getCenterId() {
        return centerId;
    }

    /**
     * Setter method to set the unique identifier for the center.
     *
     * @param centerId The unique identifier to set for the center.
     */
    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    /**
     * Getter method to retrieve the name of the center.
     *
     * @return The name of the center.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method to set the name of the center.
     *
     * @param name The name to set for the center.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method to retrieve the location of the center.
     *
     * @return The location of the center.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter method to set the location of the center.
     *
     * @param location The location to set for the center.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter method to retrieve the unique identifier for the owner of the center.
     *
     * @return The owner's unique identifier.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Setter method to set the unique identifier for the owner of the center.
     *
     * @param ownerId The unique identifier to set for the owner.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Getter method to check if the center is approved.
     *
     * @return True if the center is approved, false otherwise.
     */
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Setter method to set the approval status of the center.
     *
     * @param approved True if the center is approved, false otherwise.
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
