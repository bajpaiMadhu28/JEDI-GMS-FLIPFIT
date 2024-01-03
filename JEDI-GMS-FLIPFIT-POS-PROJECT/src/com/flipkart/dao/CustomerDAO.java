package com.flipkart.dao;

import com.flipkart.bean.Customer;
import java.util.ArrayList;

public class CustomerDAO {
    ArrayList<Customer> flipfitCustomers = new ArrayList<Customer>();
    static Integer customerId=0;
    public void registerCustomer(Customer customer) {
        // Implementation to save a customer to the database
        // Validate input, insert into the database, etc.
        flipfitCustomers.add(customer);
    }

    public String getCustomerId(){
        return (++customerId).toString();
    }

    public void addDummyDataCustomer(){
        flipfitCustomers.add(new Customer("prachir123","12345","45","prachir","prachir@prachir.com"));
        flipfitCustomers.add(new Customer("arjav123","12345","45","arjav","arjav@prachir.com"));
        flipfitCustomers.add(new Customer("madhu123","12345","45","madhu","madhu@prachir.com"));
    }

    public ArrayList<Customer> getDummyData(){
        return flipfitCustomers;
    }

    // Other customer-related methods
}
