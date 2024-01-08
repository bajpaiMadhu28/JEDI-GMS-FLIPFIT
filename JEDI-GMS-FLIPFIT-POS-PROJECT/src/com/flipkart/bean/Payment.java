package com.flipkart.bean;

/**
 * The Payment class represents a payment made in the system.
 */
public class Payment {

    // Attributes related to a payment
    private Integer paymentId; // Unique identifier for the payment
    private Integer customerId; // Unique identifier for the customer making the payment
    private Double amount; // Amount of the payment
    private Boolean isSuccessful; // Flag indicating whether the payment was successful or not

    /**
     * Constructor to initialize a Payment object with relevant details.
     *
     * @param paymentId    Unique identifier for the payment.
     * @param customerId   Unique identifier for the customer making the payment.
     * @param amount       Amount of the payment.
     * @param isSuccessful Flag indicating whether the payment was successful or not.
     */
    public Payment(Integer paymentId, Integer customerId, Double amount, Boolean isSuccessful) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.isSuccessful = isSuccessful;
    }

    // Getter and setter methods for Payment attributes

    /**
     * Getter method to retrieve the unique identifier for the payment.
     *
     * @return The payment's unique identifier.
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     * Setter method to set the unique identifier for the payment.
     *
     * @param paymentId The unique identifier to set for the payment.
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Getter method to retrieve the unique identifier for the customer making the payment.
     *
     * @return The customer's unique identifier.
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Setter method to set the unique identifier for the customer making the payment.
     *
     * @param customerId The unique identifier to set for the customer.
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter method to retrieve the amount of the payment.
     *
     * @return The amount of the payment.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Setter method to set the amount of the payment.
     *
     * @param amount The amount to set for the payment.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Getter method to check if the payment was successful.
     *
     * @return True if the payment was successful, false otherwise.
     */
    public Boolean getIsSuccessful() {
        return isSuccessful;
    }

    /**
     * Setter method to set the success status of the payment.
     *
     * @param isSuccessful True if the payment was successful, false otherwise.
     */
    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
}
