package com.flipkart.dao;

import com.flipkart.bean.Customer;

/**
 * Interface for Customer Data Access Object (DAO) operations
 */
public interface CustomerDAOInterface {

    /**
     * Registers a new customer in the system
     *
     * @param customer The customer to be registered
     */
    void registerCustomer(Customer customer);

    /**
     * Retrieves the customer ID based on login credentials
     *
     * @param username The username of the customer
     * @param password The password of the customer
     * @return The customer ID if found, else null
     */
    String getCustomerIdByLoginCreds(String username, String password);

    /**
     * Authenticates a customer based on login credentials
     *
     * @param username The username of the customer
     * @param password The password of the customer
     * @return True if authentication is successful, else false
     */
    boolean authenticateCustomer(String username, String password);

    /**
     * Updates customer information in the database
     *
     * @param name       The updated name of the customer
     * @param email      The updated email of the customer
     * @param username   The updated username of the customer
     * @param password   The updated password of the customer
     * @param customerId The ID of the customer whose information needs to be updated
     */
    void updateCustomerInfo(String name, String email, String username, String password, String customerId);
}
