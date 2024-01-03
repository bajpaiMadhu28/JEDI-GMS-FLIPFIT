package com.flipkart.bean;

public class Customer extends User {
    private String customerId;
    private String name;
    private String email;

    // Constructor
    public Customer(String username, String password, String customerId, String name, String email) {
        super(username, password);
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    // Getter and setter methods specific to Customer
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
