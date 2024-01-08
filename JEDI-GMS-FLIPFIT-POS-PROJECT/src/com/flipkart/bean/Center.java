package com.flipkart.bean;

public class Center {
    private Integer centerId;
    private String name;
    private String location;
    private String ownerId;
    private boolean isApproved;

    // Constructor
    public Center(Integer centerId, String name, String location, String ownerId) {
        this.centerId = centerId;
        this.name = name;
        this.location = location;
        this.ownerId = ownerId;
        this.isApproved = false;
    }

    // Getter and setter methods
    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
