package com.flipkart.dao;

import com.flipkart.bean.Payment;

public interface PaymentInterfaceDAO {
    boolean savePayment(Payment payment);

    Payment getPaymentDetails(Integer paymentId);

    // Other payment-related methods
}
