package com.flipkart.bean;

import java.util.ArrayList;
import java.util.Date;

import java.util.ArrayList;

/**
 * The Slot class represents a time slot for activities in the system.
 */
public class Slot {

    // Attributes related to a time slot
    private Integer slotId; // Unique identifier for the time slot
    private java.sql.Date date; // Date of the time slot
    private String time; // Time of the time slot
    private Integer centerId; // Unique identifier for the center associated with the time slot
    private boolean isAvailable; // Flag indicating whether the time slot is available or not
    private ArrayList<String> waitlistedCustomerIds; // List of customer IDs waitlisted for the time slot
    private String customerId; // Customer ID associated with the booked time slot
    private boolean isApproved; // Flag indicating whether the time slot is approved or not

    /**
     * Constructor to initialize a Slot object with relevant details.
     *
     * @param slotId   Unique identifier for the time slot.
     * @param date     Date of the time slot.
     * @param time     Time of the time slot.
     * @param centerId Unique identifier for the center associated with the time slot.
     */
    public Slot(Integer slotId, java.sql.Date date, String time, Integer centerId) {
        this.slotId = slotId;
        this.date = date;
        this.time = time;
        this.centerId = centerId;
        this.isAvailable = true;
        this.waitlistedCustomerIds = new ArrayList<String>();
        this.customerId = null;
        this.isApproved = false;
    }

    // Getter and setter methods for Slot attributes

    /**
     * Getter method to retrieve the unique identifier for the time slot.
     *
     * @return The time slot's unique identifier.
     */
    public Integer getSlotId() {
        return slotId;
    }

    /**
     * Setter method to set the unique identifier for the time slot.
     *
     * @param slotId The unique identifier to set for the time slot.
     */
    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    /**
     * Getter method to retrieve the date of the time slot.
     *
     * @return The date of the time slot.
     */
    public java.sql.Date getDate() {
        return date;
    }

    /**
     * Setter method to set the date of the time slot.
     *
     * @param date The date to set for the time slot.
     */
    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    /**
     * Getter method to retrieve the time of the time slot.
     *
     * @return The time of the time slot.
     */
    public String getTime() {
        return time;
    }

    /**
     * Setter method to set the time of the time slot.
     *
     * @param time The time to set for the time slot.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Getter method to retrieve the unique identifier for the center associated with the time slot.
     *
     * @return The center's unique identifier.
     */
    public Integer getCenterId() {
        return centerId;
    }

    /**
     * Setter method to set the unique identifier for the center associated with the time slot.
     *
     * @param centerId The unique identifier to set for the center.
     */
    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    /**
     * Getter method to check if the time slot is available.
     *
     * @return True if the time slot is available, false otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Setter method to set the availability status of the time slot.
     *
     * @param available True if the time slot is available, false otherwise.
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Getter method to retrieve the list of customer IDs waitlisted for the time slot.
     *
     * @return The list of customer IDs waitlisted for the time slot.
     */
    public ArrayList<String> getWaitlistedCustomerIds() {
        return waitlistedCustomerIds;
    }

    /**
     * Method to add a customer ID to the list of waitlisted customers for the time slot.
     *
     * @param customerId The customer ID to add to the waitlist.
     */
    public void addWaitlistedCustomerIds(String customerId) {
        waitlistedCustomerIds.add(customerId);
    }

    /**
     * Getter method to retrieve the customer ID associated with the booked time slot.
     *
     * @return The customer ID associated with the booked time slot.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Setter method to set the customer ID associated with the booked time slot.
     *
     * @param customerId The customer ID to set for the booked time slot.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter method to check if the time slot is approved.
     *
     * @return True if the time slot is approved, false otherwise.
     */
    public boolean getApproved() {
        return isApproved;
    }

    /**
     * Setter method to set the approval status of the time slot.
     *
     * @param approved True if the time slot is approved, false otherwise.
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    /**
     * Setter method to set the list of customer IDs waitlisted for the time slot.
     *
     * @param waitlistedCustomerIds The list of customer IDs to set for the waitlist.
     */
    public void setWaitlistedCustomerIds(ArrayList<String> waitlistedCustomerIds) {
        this.waitlistedCustomerIds = waitlistedCustomerIds;
    }
}

