package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDAO;
import com.flipkart.dao.PaymentInterfaceDAO;

public class PaymentService {
    private PaymentInterfaceDAO paymentDAO;

    public PaymentService(PaymentInterfaceDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public void processPayment(Payment payment) {
        paymentDAO.savePayment(payment);
    }
}
