package com.flipkart.dao;

import com.flipkart.bean.Payment;

/**
 * Interface for Payment Data Access Object (DAO) operations
 */
public interface PaymentDAOInterface {

    /**
     * Saves payment details to the database
     *
     * @param payment The payment details to be saved
     * @return True if the payment is successfully saved, false otherwise
     */
    boolean savePayment(Payment payment);

    /**
     * Retrieves payment details by payment ID
     *
     * @param paymentId The ID of the payment
     * @return Payment details if found, else null
     */
    Payment getPaymentDetails(Integer paymentId);

    // Other payment-related methods
}
