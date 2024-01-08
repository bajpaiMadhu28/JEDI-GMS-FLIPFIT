package com.flipkart.business;

/**
 * Interface defining the contract for SlotService classes.
 */
public interface SlotServiceInterface {

    /**
     * Retrieves all available slots for a given center.
     *
     * @param centerId The ID of the center.
     * @return True if slots are available, false otherwise.
     */
    boolean getAllSlots(Integer centerId);

    /**
     * Books a slot for a customer.
     *
     * @param slotId     The ID of the slot to be booked.
     * @param customerId The ID of the customer booking the slot.
     */
    void bookSlot(Integer slotId, String customerId);

    /**
     * Shows all the booked slots for a customer.
     *
     * @param customerId The ID of the customer.
     */
    void showBookedSlots(String customerId);

    /**
     * Cancels a booking for a slot.
     *
     * @param slotId The ID of the slot for which booking needs to be canceled.
     */
    void cancelBooking(Integer slotId);
}
