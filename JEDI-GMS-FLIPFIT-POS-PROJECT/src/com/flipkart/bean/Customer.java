package com.flipkart.bean;

/**
 * The Customer class extends the User class and represents a customer in the system.
 */
public class Customer extends User {

    // Customer-specific attributes
    private String customerId; // Unique identifier for the customer
    private String name; // Name of the customer
    private String email; // Email address of the customer

    /**
     * Constructor to initialize a Customer object with relevant details.
     *
     * @param username   Username of the customer.
     * @param password   Password of the customer.
     * @param customerId Unique identifier for the customer.
     * @param name       Name of the customer.
     * @param email      Email address of the customer.
     */
    public Customer(String username, String password, String customerId, String name, String email) {
        super(username, password);
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    // Getter and setter methods specific to Customer

    /**
     * Getter method to retrieve the unique identifier for the customer.
     *
     * @return The customer's unique identifier.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Setter method to set the unique identifier for the customer.
     *
     * @param customerId The unique identifier to set for the customer.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter method to retrieve the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method to set the name of the customer.
     *
     * @param name The name to set for the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method to retrieve the email address of the customer.
     *
     * @return The email address of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method to set the email address of the customer.
     *
     * @param email The email address to set for the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
