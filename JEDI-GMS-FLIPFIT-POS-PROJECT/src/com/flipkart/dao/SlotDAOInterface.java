package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Slot;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Interface for Slot Data Access Object (DAO) operations
 */
public interface SlotDAOInterface {

    /**
     * Adds dummy data for slots
     */
    void addDummyDataSlot();

    /**
     * Retrieves all dummy slots
     *
     * @return List of dummy slots
     */
    ArrayList<Slot> getAllDummySlots();

    /**
     * Retrieves dummy data for slots based on the center ID
     *
     * @param centerId The ID of the center
     * @return List of dummy slots for the specified center
     */
    ArrayList<Slot> getDummyData(Integer centerId);

    /**
     * Retrieves all slots for a specific center
     *
     * @param centerId The ID of the center
     * @return ResultSet containing all slots for the specified center
     */
    ResultSet getAllSlots(Integer centerId);

    /**
     * Saves a new slot to the database
     *
     * @param slot The slot to be saved
     * @return True if the slot is successfully saved, false otherwise
     */
    boolean saveSlot(Slot slot);

    /**
     * Retrieves slot details by slot ID
     *
     * @param slotId The ID of the slot
     * @return ResultSet containing slot details if found, else null
     */
    ResultSet getSlotById(Integer slotId);

    /**
     * Retrieves a list of booked slots for a specific customer
     *
     * @param customerId The ID of the customer
     * @return ResultSet containing booked slots made by the customer
     */
    ResultSet getBookedSlotsByCustomerId(String customerId);

    /**
     * Updates the details of an existing slot in the database
     *
     * @param slot The updated slot information
     */
    void updateSlot(Slot slot);

    /**
     * Deletes a slot from the database based on the slot ID
     *
     * @param slotId The ID of the slot to be deleted
     */
    void deleteSlot(String slotId);

    /**
     * Retrieves a list of available slots for a specific center
     *
     * @param centerId The ID of the center
     * @return List of available slots for the center
     */
    List<Slot> getAvailableSlots(Integer centerId);

    /**
     * Books a slot for a customer
     *
     * @param slot The slot to be booked
     * @return True if the slot is successfully booked, false otherwise
     */
    Boolean bookSlot(Slot slot);

    /**
     * Updates the waitlist for a slot
     *
     * @param slot The slot for which the waitlist is updated
     */
    void updateWaitlist(Slot slot);

    /**
     * Cancels a booking for a slot
     *
     * @param slot The slot for which the booking is canceled
     */
    void cancelSlotBooking(Slot slot);

    /**
     * Adds a new slot to the database
     *
     * @param slot The slot to be added
     * @return True if the slot is successfully added, false otherwise
     */
    boolean addSlot(Slot slot);

    /**
     * Checks if a slot already exists in the database
     *
     * @param slot The slot to be checked
     * @return True if the slot already exists, false otherwise
     */
    boolean isSlotAlreadyExists(Slot slot);
}
