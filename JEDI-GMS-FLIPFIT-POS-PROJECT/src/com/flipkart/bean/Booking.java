package com.flipkart.bean;

import java.util.Date;

public class Booking {
    private String bookingId;
    private String customerId;
    private String centerId;
    private String slotId;
    private String paymentId;
    private Double amount;
    private Date bookingDate;

    // Constructor
    public Booking(String bookingId, String customerId, String centerId, String slotId, String paymentId, Double amount, Date bookingDate) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.centerId = centerId;
        this.slotId = slotId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.bookingDate = bookingDate;
    }

    // Getter and setter methods
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
