package com.flipkart.bean;

import java.util.Date;

public class Slot {
    private Integer slotId;
    private Date date;
    private String time;
    private Integer centerId;
    private boolean isAvailable;

    private boolean isApproved;

    // Constructor
    public Slot(Integer slotId, Date date, String time, Integer centerId) {
        this.slotId = slotId;
        this.date = date;
        this.time = time;
        this.centerId = centerId;
        this.isAvailable = true;
        this.isApproved = false;
    }

    // Getter and setter methods
    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }
}
