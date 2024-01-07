package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.dao.BookingInterfaceDAO;
import com.flipkart.dao.CustomerInterfaceDAO;

import java.util.ArrayList;

public class CustomerService {
    private CustomerInterfaceDAO customerDAO;
    private BookingInterfaceDAO bookingDAO;

    // Constructor
    public CustomerService(CustomerInterfaceDAO customerDAO, BookingInterfaceDAO bookingDAO) {
        this.customerDAO = customerDAO;
        this.bookingDAO = bookingDAO;
    }

    // Business logic methods for customers
    public void registerCustomer(Customer customer) {
        // Implementation to register a customer
        // Validate input, check uniqueness, update database, etc.
        customerDAO.registerCustomer(customer);
    }

    public boolean authenticateCustomer(String username, String password) {
        ArrayList<Customer> currentCustomers = customerDAO.getDummyData();
        for (Customer customer : currentCustomers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String getCustomerIdByLoginCreds(String username, String password) {
        ArrayList<Customer> currentCustomers = customerDAO.getDummyData();
        for (Customer customer : currentCustomers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return customer.getCustomerId();
            }
        }
        return null;
    }

    public void updateCustomerInfo(String name, String email, String username, String password, String customerId) {
        Customer currentCustomer = customerDAO.getCustomerById(customerId);
        currentCustomer.setName(name);
        currentCustomer.setEmail(email);
        currentCustomer.setUsername(username);
        currentCustomer.setPassword(password);
        System.out.println("Customer Info Updated Successfully");
    }

//    // Booking-related operations
//    public boolean makeBooking(Booking booking) throws BookingException {
//        // Implementation to make a booking
//        // Validate input, check availability, update database, etc.
//        return bookingDAO.saveBooking(booking);
//    }
//
//    public List<Booking> getBookingsForCustomer(int customerId) {
//        // Implementation to get bookings for a customer
//        return bookingDAO.getBookingsByCustomerId(customerId);
//    }
//
//    public void cancelBooking(int bookingId) throws BookingException {
//        // Implementation to cancel a booking
//        // Validate input, check validity, update database, etc.
//        bookingDAO.cancelBooking(bookingId);
//    }

    // Other business methods
}
