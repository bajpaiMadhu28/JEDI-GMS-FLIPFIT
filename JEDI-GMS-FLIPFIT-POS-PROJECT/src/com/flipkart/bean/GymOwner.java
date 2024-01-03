package com.flipkart.bean;

public class GymOwner extends User {
    private String ownerId;
    private String gymName;

    // Constructor
    public GymOwner(String username, String password, String ownerId, String gymName) {
        super(username, password);
        this.ownerId = ownerId;
        this.gymName = gymName;
    }

    // Getter and setter methods specific to GymOwner
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }
}
