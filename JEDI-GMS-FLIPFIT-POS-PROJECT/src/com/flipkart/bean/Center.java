package com.flipkart.bean;

public class Center {
    private Integer centerId;
    private String name;
    private String location;



    private Boolean isApproved;

    // Constructor
    public Center(Integer centerId, String name, String location) {
        this.centerId = centerId;
        this.name = name;
        this.location = location;
        this.isApproved=false;
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
    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }
}
