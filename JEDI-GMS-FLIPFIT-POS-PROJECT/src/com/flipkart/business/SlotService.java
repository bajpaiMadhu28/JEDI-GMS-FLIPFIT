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
    public void bookSlot(Integer slotId,String customerId) {
        // Implementation to book a slot
        // Validate input, check availability, update database, etc.
        Slot currentSlot=slotDAO.getSlotById(slotId);
        if(currentSlot.isAvailable()){
            currentSlot.setAvailable(false);
            currentSlot.setCustomerId(customerId);
            System.out.println("Slot Booked Successfully");
        }
        else{
            currentSlot.addWaitlistedCustomerIds(customerId);
            Integer currentWaitlist=currentSlot.getWaitlistedCustomerIds().size();
            String waitlistString=String.format("Slot Booked With Waitlist Number : %d",currentWaitlist);
            System.out.println(waitlistString);
        }
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
