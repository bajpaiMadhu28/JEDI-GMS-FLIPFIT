package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.dao.BookingDAOInterface;
import com.flipkart.dao.CustomerDAOInterface;

/**
 * Interface for the CustomerService class providing business logic related to customers.
 */
public interface CustomerServiceInterface {

    /**
     * Registers a new customer in the system.
     *
     * @param customer The Customer object containing registration information.
     */
    void registerCustomer(Customer customer);

    /**
     * Authenticates a customer based on provided login credentials.
     *
     * @param username The username of the customer.
     * @param password The password of the customer.
     * @return True if the authentication is successful, false otherwise.
     */
    boolean authenticateCustomer(String username, String password);

    /**
     * Retrieves the customer ID based on provided login credentials.
     *
     * @param username The username of the customer.
     * @param password The password of the customer.
     * @return The customer ID if credentials are valid, otherwise null.
     */
    String getCustomerIdByLoginCreds(String username, String password);

    /**
     * Updates the information of an existing customer.
     *
     * @param name       The updated name of the customer.
     * @param email      The updated email of the customer.
     * @param username   The updated username of the customer.
     * @param password   The updated password of the customer.
     * @param customerId The ID of the customer whose information needs to be updated.
     */
    void updateCustomerInfo(String name, String email, String username, String password, String customerId);

    // Other business methods (if any)
}
