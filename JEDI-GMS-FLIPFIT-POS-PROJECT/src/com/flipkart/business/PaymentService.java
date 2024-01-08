package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDAOInterface;

public class PaymentService implements PaymentServiceInterface {
    private PaymentDAOInterface paymentDAO;

    public PaymentService(PaymentDAOInterface paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public void processPayment(Payment payment) {
        paymentDAO.savePayment(payment);
    }
}
