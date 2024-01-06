package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.util.ArrayList;

public interface CustomerInterfaceDAO {
    void registerCustomer(Customer customer);

    String getCustomerId();

    void addDummyDataCustomer();

    ArrayList<Customer> getDummyData();

    Customer getCustomerById(String customerId);

    // Other customer-related methods
}
