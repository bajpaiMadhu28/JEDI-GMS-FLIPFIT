package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.Objects;

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
        flipfitCustomers.add(new Customer("arjav123","12345","46","arjav","arjav@prachir.com"));
        flipfitCustomers.add(new Customer("madhu123","12345","47","madhu","madhu@prachir.com"));
    }

    public ArrayList<Customer> getDummyData(){
        return flipfitCustomers;
    }

    public Customer getCustomerById(String customerId) {
        // Implementation to retrieve slot details from the database based on the slotId
        // You may use JDBC or any other data access mechanism
        for(Customer currentCustomer:flipfitCustomers){
            if(Objects.equals(customerId, currentCustomer.getCustomerId())){
                return currentCustomer;
            }
        }
        return null; // Replace with actual logic
    }

    // Other customer-related methods
}
