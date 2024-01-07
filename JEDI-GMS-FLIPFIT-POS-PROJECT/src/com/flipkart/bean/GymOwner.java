package com.flipkart.bean;

public class GymOwner extends User {
    private String ownerId;
    private String ownerName;
    //    private String gymName;
    private String email;

    // Constructor
    public GymOwner(String ownerName, String username, String password, String ownerId, String email
    ) {
        super(username, password);
        this.ownerId = ownerId;
//        this.gymName = gymName;
        this.ownerName = ownerName;
        this.email = email;
    }

    // Getter and setter methods specific to GymOwner
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
