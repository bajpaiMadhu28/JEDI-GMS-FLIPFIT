package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.dao.CustomerDAOInterface;
import com.flipkart.exception.BookingException;
import com.flipkart.exception.CustomerAlreadyBookedException;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private CustomerDAOInterface customerDAO;
    private BookingDAO bookingDAO;

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
