package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAO;

import java.util.ArrayList;
import java.util.List;

public class SlotService {
    private SlotDAO slotDAO;

    // Constructor
    public SlotService(SlotDAO slotDAO) {
        this.slotDAO = slotDAO;
    }

    // Business logic methods for slots

    // Get available slots for a given center
    public void getAllSlots(Integer centerId) {
        // Implementation to get available slots for a center
        // Query database, apply business rules, etc.
        ArrayList<Slot> currentSlots=slotDAO.getDummyData(centerId);
        for(Slot currentSlot:currentSlots){
            String slotString=String.format("Slot ID : %d Slot Date : %s Slot Time : %s Availability : %b ",currentSlot.getSlotId(),currentSlot.getDate().toString(),currentSlot.getTime(),currentSlot.isAvailable());
            System.out.println(slotString);
        }
    }

    // Book a slot for a customer
    public boolean bookSlot(Booking booking) {
        // Implementation to book a slot
        // Validate input, check availability, update database, etc.
        return slotDAO.bookSlot(booking);
    }

    // Update the waitlist for a slot
    public void updateWaitlist(String slotId, List<String> waitlist) {
        // Implementation to update the waitlist for a slot
        // Validate input, update database, etc.
        slotDAO.updateWaitlist(slotId, waitlist);
    }

    // Cancel a booking for a slot
    public void cancelBooking(String bookingId) {
        // Implementation to cancel a booking
        // Validate input, update database, etc.
        slotDAO.deleteSlot(bookingId);
    }

    // Other business methods
}
