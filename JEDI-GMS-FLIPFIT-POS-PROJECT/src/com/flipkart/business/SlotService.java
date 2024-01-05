package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
        ResultSet slotResult= slotDAO.getAllSlots(centerId);
        ArrayList<Slot> currentSlots=new ArrayList<Slot>();

        try{
            while (slotResult.next()){
                Slot slotToShow=new Slot(null,null,null,null);
                slotToShow.setSlotId(slotResult.getInt(1));
                slotToShow.setDate(slotResult.getDate(2));
                slotToShow.setTime(slotResult.getString(3));
                slotToShow.setCenterId(slotResult.getInt(4));

                Integer isAvailable=slotResult.getInt(5);
                if(isAvailable==1){
                    slotToShow.setAvailable(true);
                }
                else{
                    slotToShow.setAvailable(false);
                }

                ArrayList<String> waitlistedCustomers=new ArrayList<String>();
                String waitlistedCustomersString=slotResult.getString(6);
                if(waitlistedCustomersString!=null){
                    String[] convertedCustomerList = waitlistedCustomersString.split(",");
                    waitlistedCustomers.addAll(Arrays.asList(convertedCustomerList));
                }
                slotToShow.setWaitlistedCustomerIds(waitlistedCustomers);

                slotToShow.setCustomerId(slotResult.getString(7));

                Integer isApproved=slotResult.getInt(8);
                if(isApproved==1){
                    slotToShow.setApproved(true);
                }
                else{
                    slotToShow.setApproved(false);
                }

                currentSlots.add(slotToShow);
            }
        }catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }

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

    public void showBookedSlots(String customerId){
        ArrayList<Slot> bookedSlots=slotDAO.getBookedSlotsByCustomerId(customerId);
        for(Slot currentSlot:bookedSlots){
            String slotString=String.format("Slot ID : %d Slot Date : %s Slot Time : %s Availability : %b ",currentSlot.getSlotId(),currentSlot.getDate().toString(),currentSlot.getTime(),currentSlot.isAvailable());
            System.out.println(slotString);
        }
    }

    // Update the waitlist for a slot
    public void updateWaitlist(String slotId, List<String> waitlist) {
        // Implementation to update the waitlist for a slot
        // Validate input, update database, etc.
        slotDAO.updateWaitlist(slotId, waitlist);
    }

    // Cancel a booking for a slot
    public void cancelBooking(Integer slotId) {
        // Implementation to cancel a booking
        // Validate input, update database, etc.
        Slot currentSlot=slotDAO.getSlotById(slotId);
        currentSlot.setAvailable(true);
        currentSlot.setCustomerId(null);
        if(!currentSlot.getWaitlistedCustomerIds().isEmpty()){
            currentSlot.setAvailable(false);
            String removedCustomerId=currentSlot.getWaitlistedCustomerIds().remove(0);
            currentSlot.setCustomerId(removedCustomerId);
        }
//        System.out.println(currentSlot.getCustomerId());
        System.out.println("Booking Cancelled");
    }

    // Other business methods
}
