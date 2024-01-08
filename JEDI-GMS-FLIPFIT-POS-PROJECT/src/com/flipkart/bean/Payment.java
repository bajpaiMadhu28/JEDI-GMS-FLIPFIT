package com.flipkart.bean;

public class Payment {
    private Integer paymentId;
    private String customerId;
    private Double amount;
    private Boolean isSuccessful;

    private String upiId;

    private int password;

    // Constructor
    public Payment(Integer paymentId, String customerId, Double amount, Boolean isSuccessful, String upiId) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.isSuccessful = isSuccessful;
        this.upiId = upiId;
//        this.password = password;
    }

    // Getter and setter methods
    public Integer getPaymentId() {
        return paymentId;
    }

     int paymentID=0;
    public void setPaymentId() {
        this.paymentId = ++paymentID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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

    public int getPassword( ){
        return password;

    }

    public void setPassword(int password){
        this.password = password;

    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
}
