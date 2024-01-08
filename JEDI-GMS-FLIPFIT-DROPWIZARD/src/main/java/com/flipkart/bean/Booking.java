package com.flipkart.bean;

import java.util.Date;

/**
 * The Booking class represents a reservation made by a customer.
 */
public class Booking {

    // Attributes related to a booking
    private String bookingId; // Unique identifier for the booking
    private String customerId; // Unique identifier for the customer making the booking
    private String centerId; // Unique identifier for the booking center
    private String slotId; // Unique identifier for the time slot of the booking
    private String paymentId; // Unique identifier for the payment associated with the booking
    private Double amount; // Amount paid for the booking
    private Date bookingDate; // Date and time when the booking was made

    /**
     * Constructor to initialize a Booking object with relevant details.
     *
     * @param bookingId    Unique identifier for the booking.
     * @param customerId   Unique identifier for the customer making the booking.
     * @param centerId     Unique identifier for the booking center.
     * @param slotId       Unique identifier for the time slot of the booking.
     * @param paymentId    Unique identifier for the payment associated with the booking.
     * @param amount       Amount paid for the booking.
     * @param bookingDate  Date and time when the booking was made.
     */
    public Booking(String bookingId, String customerId, String centerId, String slotId, String paymentId, Double amount, Date bookingDate) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.centerId = centerId;
        this.slotId = slotId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.bookingDate = bookingDate;
    }

    // Getter and setter methods for Booking attributes

    /**
     * Getter method to retrieve the unique identifier for the booking.
     *
     * @return The booking's unique identifier.
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Setter method to set the unique identifier for the booking.
     *
     * @param bookingId The unique identifier to set for the booking.
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Getter method to retrieve the unique identifier for the customer making the booking.
     *
     * @return The customer's unique identifier.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Setter method to set the unique identifier for the customer making the booking.
     *
     * @param customerId The unique identifier to set for the customer.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter method to retrieve the unique identifier for the booking center.
     *
     * @return The booking center's unique identifier.
     */
    public String getCenterId() {
        return centerId;
    }

    /**
     * Setter method to set the unique identifier for the booking center.
     *
     * @param centerId The unique identifier to set for the booking center.
     */
    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    /**
     * Getter method to retrieve the unique identifier for the time slot of the booking.
     *
     * @return The time slot's unique identifier.
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Setter method to set the unique identifier for the time slot of the booking.
     *
     * @param slotId The unique identifier to set for the time slot.
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     * Getter method to retrieve the unique identifier for the payment associated with the booking.
     *
     * @return The payment's unique identifier.
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Setter method to set the unique identifier for the payment associated with the booking.
     *
     * @param paymentId The unique identifier to set for the payment.
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Getter method to retrieve the amount paid for the booking.
     *
     * @return The amount paid for the booking.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Setter method to set the amount paid for the booking.
     *
     * @param amount The amount to set for the booking.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Getter method to retrieve the date and time when the booking was made.
     *
     * @return The booking date and time.
     */
    public Date getBookingDate() {
        return bookingDate;
    }

    /**
     * Setter method to set the date and time when the booking was made.
     *
     * @param bookingDate The date and time to set for the booking.
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}