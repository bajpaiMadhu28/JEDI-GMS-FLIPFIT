package com.flipkart.bean;

import java.util.ArrayList;
import java.util.Date;

public class Slot {
    private Integer slotId;
    private String date;
    private String time;
    private Integer centerId;
    private boolean isAvailable;
    private ArrayList<String> waitlistedCustomerIds;
    private String customerId;

    private boolean isApproved;



    // Constructor
    public Slot(Integer slotId, String date, String time, Integer centerId) {
        this.slotId = slotId;
        this.date = date;
        this.time = time;
        this.centerId = centerId;
        this.isAvailable=true;
        this.waitlistedCustomerIds=new ArrayList<String>();
        this.customerId=null;
        this.isApproved = false;
    }

    // Getter and setter methods
    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public ArrayList<String> getWaitlistedCustomerIds() {
        return waitlistedCustomerIds;
    }

    public void addWaitlistedCustomerIds(String customerId) {
        waitlistedCustomerIds.add(customerId);
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public void setWaitlistedCustomerIds(ArrayList<String> waitlistedCustomerIds) {
        this.waitlistedCustomerIds = waitlistedCustomerIds;
    }
}
