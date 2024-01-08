package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.BookingDAOInterface;
import com.flipkart.dao.CustomerDAOInterface;

public class CustomerService implements CustomerServiceInterface {
    private CustomerDAOInterface customerDAO;
    private BookingDAOInterface bookingDAO;

    // Constructor
    public CustomerService(CustomerDAOInterface customerDAO, BookingDAO bookingDAO) {
        this.customerDAO = customerDAO;
        this.bookingDAO = bookingDAO;
    }

    // Business logic methods for customers
    public void registerCustomer(Customer customer) {
        // Implementation to register a customer
        // Validate input, check uniqueness, update database, etc.
        customerDAO.registerCustomer(customer);
    }

    public boolean authenticateCustomer(String username,String password){
        return customerDAO.authenticateCustomer(username,password);
    }

    public String getCustomerIdByLoginCreds(String username,String password){
        return customerDAO.getCustomerIdByLoginCreds(username,password);
    }

    public void updateCustomerInfo(String name,String email,String username,String password,String customerId){
        customerDAO.updateCustomerInfo(name,email,username,password,customerId);
        System.out.println("Customer Info Updated Successfully");
    }

}
