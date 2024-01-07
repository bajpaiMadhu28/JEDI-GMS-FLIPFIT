package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SlotDAO implements SlotInterfaceDAO {

    ArrayList<Slot> slots = new ArrayList<Slot>();
    // Add methods for CRUD operations on Slot entities

    Integer slotId;

    public void addDummyDataSlot() {
        slots.add(new Slot(1, "05/01/2023", "9 AM - 10 AM", 1));
        slots.add(new Slot(2, "05/01/2023", "10 AM - 11 AM", 2));
        slots.add(new Slot(3, "05/01/2023", "11 AM - 12 PM", 3));
        slots.add(new Slot(4, "05/01/2023", "12 PM - 1 PM", 4));
        slots.get(0).setAvailable(false);
        slots.get(0).setCustomerId("45");
        slots.get(0).addWaitlistedCustomerIds("test ID 123");
    }

    public ArrayList<Slot> getAllDummySlots() {
        return slots;
    }

    public ArrayList<Slot> getDummyData(Integer centerId) {
        ArrayList<Slot> filteredSlots = new ArrayList<Slot>();
        for (Slot currentSlot : slots) {
//            System.out.println(filteredSlots.size()+" "+centerId+" "+currentSlot.getCenterId());
            if (currentSlot.getCenterId() == centerId) {
                filteredSlots.add(currentSlot);
            }
        }
        System.out.println(filteredSlots.size());
        return filteredSlots;
    }

    // Save a new Slot
    public boolean saveSlot(Slot slot) {
        // Implementation to save a slot to the database
        // Validate input, insert into the database, etc.
        return false;
    }

    public Integer getSlotId() {
        int newSlotId = slots.size();
        return (newSlotId + 1);
    }

    // Retrieve Slot details by slotId
    public Slot getSlotById(Integer slotId) {
        // Implementation to retrieve slot details from the database based on the slotId
        // You may use JDBC or any other data access mechanism
        for (Slot currentSlot : slots) {
            if (Objects.equals(currentSlot.getSlotId(), slotId)) {
                return currentSlot;
            }
        }
        return null; // Replace with actual logic
    }

    public ArrayList<Slot> getBookedSlotsByCustomerId(String customerId) {
        ArrayList<Slot> currentSlots = new ArrayList<Slot>();
        for (Slot currentSlot : slots) {
            if (Objects.equals(currentSlot.getCustomerId(), customerId) && !currentSlot.isAvailable()) {
                currentSlots.add(currentSlot);
            }
        }
        return currentSlots;
    }

    // Update Slot details
    public void updateSlot(Slot slot) {
        // Implementation to update slot details in the database
        // You may use JDBC or any other data access mechanism
    }

    // Delete Slot by slotId
    public void deleteSlot(String slotId) {
        for (Slot slot : slots) {
            if (slot.getSlotId().toString().equals(slotId)) {
                slots.remove(slot);
                break;
            }
        }
    }

    // Get available slots for a center
    public List<Slot> getAvailableSlots(Integer centerId) {
        // Implementation to retrieve available slots for a center from the database
        // You may use JDBC or any other data access mechanism
        return null; // Placeholder, replace with actual implementation
    }

    // Book a slot for a customer
    public boolean bookSlot(Booking booking) {
        // Implementation to book a slot
        // Validate input, check availability, update database, etc.
        return false; // Placeholder, replace with actual implementation
    }

    // Update the waitlist for a slot
    public void updateWaitlist(String slotId, List<String> waitlist) {
        // Implementation to update the waitlist for a slot
        // Validate input, update database, etc.
        // Placeholder, replace with actual implementation
    }

    // Add a new slot to the database
    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    // Check if a slot already exists in the database
    public boolean isSlotAlreadyExists(Slot slot) {
        // Implementation to check if a slot already exists in the database
        // Placeholder, replace with actual implementation
        return false;
    }
}
