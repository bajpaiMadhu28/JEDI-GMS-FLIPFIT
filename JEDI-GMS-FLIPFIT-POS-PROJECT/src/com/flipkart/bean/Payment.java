package com.flipkart.bean;

public class Payment {
    private Integer paymentId;
    private Integer customerId;
    private Double amount;
    private Boolean isSuccessful;

    // Constructor
    public Payment(Integer paymentId, Integer customerId, Double amount, Boolean isSuccessful) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.isSuccessful = isSuccessful;
    }

    // Getter and setter methods
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
}
