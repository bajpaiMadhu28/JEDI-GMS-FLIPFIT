package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDAOInterface;

/**
 * Interface defining the contract for PaymentService classes.
 */
public interface PaymentServiceInterface {

    /**
     * Processes a payment by saving it.
     *
     * @param payment The Payment object containing payment details.
     */
    void processPayment(Payment payment);
}
