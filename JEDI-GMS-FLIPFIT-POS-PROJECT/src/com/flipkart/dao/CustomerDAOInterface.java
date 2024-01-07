package com.flipkart.dao;

import com.flipkart.bean.Customer;

public interface CustomerDAOInterface {
    public void registerCustomer(Customer customer);
    public String getCustomerIdByLoginCreds(String username,String password);
    public boolean authenticateCustomer(String username,String password);
    public void updateCustomerInfo(String name,String email,String username,String password,String customerId);
}
