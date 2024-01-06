package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

public interface BookingInterfaceDAO {
    void saveBooking(Booking booking);

    Booking getBookingById(String bookingId);

    void updateBooking(Booking booking);

    void deleteBooking(String bookingId);

    List<Booking> getBookingsByCustomerId(String customerId);
}
