package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Booking;

/**
 * Interface for Booking Data Access Object (DAO) operations
 */
public interface BookingDAOInterface {

    /**
     * Saves a booking to the database
     *
     * @param booking The booking to be saved
     */
    void saveBooking(Booking booking);

    /**
     * Retrieves booking details by booking ID
     *
     * @param bookingId The ID of the booking to be retrieved
     * @return Booking details if found, else null
     */
    Booking getBookingById(String bookingId);

    /**
     * Updates the details of an existing booking in the database
     *
     * @param booking The updated booking information
     */
    void updateBooking(Booking booking);

    /**
     * Deletes a booking from the database based on the booking ID
     *
     * @param bookingId The ID of the booking to be deleted
     */
    void deleteBooking(String bookingId);

    /**
     * Retrieves a list of bookings for a specific customer
     *
     * @param customerId The ID of the customer
     * @return List of bookings made by the customer
     */
    List<Booking> getBookingsByCustomerId(String customerId);
}
