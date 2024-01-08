package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;
import com.flipkart.dao.SlotDAO;
import com.flipkart.exception.BookingFailedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlotService {
    private SlotDAO slotDAO;

    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_YELLOW = "\u001B[33m";

    final String ANSI_GREEN = "\u001B[32m";

    final String ANSI_RED = "\u001B[31m";



    // Constructor
    public SlotService(SlotDAO slotDAO) {
        this.slotDAO = slotDAO;
    }

    // Business logic methods for slots

    // Get available slots for a given center
    public boolean getAllSlots(Integer centerId) {
        boolean flag= true;
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
        if(currentSlots.isEmpty()){
            flag=false;
            System.out.println("\u001B[31mNo available slots\u001B[0m");
            return flag;
        }

        System.out.println(ANSI_YELLOW + "------------------------------------------------------------");
        System.out.println("| Slot ID |  Slot Date  |  Slot Time    |  Availability    |");
        System.out.println("------------------------------------------------------------");

        for (Slot currentSlot : currentSlots) {
            String slotString = String.format("| %-8d| %-12s| %-12s | %-14b   |",
                    currentSlot.getSlotId(),
                    currentSlot.getDate().toString(),
                    currentSlot.getTime(),
                    currentSlot.isAvailable());
            System.out.println(slotString);
        }

        System.out.println("------------------------------------------------------------" + ANSI_RESET);
        return flag;
    }

    // Book a slot for a customer
    public void bookSlot(Integer slotId,String customerId) {
        // Implementation to book a slot
        // Validate input, check availability, update database, etc.
        ResultSet slotResult=slotDAO.getSlotById(slotId);
        Slot currentSlot=new Slot(null,null,null,null);

        try{
            while (slotResult.next()){
                currentSlot.setSlotId(slotResult.getInt(1));
                currentSlot.setDate(slotResult.getDate(2));
                currentSlot.setTime(slotResult.getString(3));
                currentSlot.setCenterId(slotResult.getInt(4));

                Integer isAvailable=slotResult.getInt(5);
                if(isAvailable==1){
                    currentSlot.setAvailable(true);
                }
                else{
                    currentSlot.setAvailable(false);
                }

                ArrayList<String> waitlistedCustomers=new ArrayList<String>();
                String waitlistedCustomersString=slotResult.getString(6);
                if(waitlistedCustomersString!=null){
                    String[] convertedCustomerList = waitlistedCustomersString.split(",");
                    waitlistedCustomers.addAll(Arrays.asList(convertedCustomerList));
                }
                currentSlot.setWaitlistedCustomerIds(waitlistedCustomers);

                currentSlot.setCustomerId(slotResult.getString(7));

                Integer isApproved=slotResult.getInt(8);
                if(isApproved==1){
                    currentSlot.setApproved(true);
                }
                else{
                    currentSlot.setApproved(false);
                }
            }
        }catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }


        if(currentSlot.isAvailable()){
            currentSlot.setAvailable(false);
            currentSlot.setCustomerId(customerId);
            try{
                if(slotDAO.bookSlot(currentSlot)){
                    System.out.println("Slot Booked Successfully");
                }
                else{
                    throw new BookingFailedException("ERROR in booking slot");
                }
            }catch (Exception ex){

            }
        }
        else{
            currentSlot.addWaitlistedCustomerIds(customerId);
            Integer currentWaitlist=currentSlot.getWaitlistedCustomerIds().size();
//            String waitlistString = String.format("Slot Booked With Waitlist Number : %d", currentWaitlist);
            System.out.println(ANSI_GREEN + "Slot Booked With " + ANSI_RED + "Waitlist Number : " + currentWaitlist + ANSI_GREEN + ANSI_RESET);            slotDAO.updateWaitlist(currentSlot);
//            System.out.println(waitlistString);
        }
    }

    public void showBookedSlots(String customerId){
        ResultSet bookedSlotsInfo=slotDAO.getBookedSlotsByCustomerId(customerId);

        ArrayList<Slot> bookedSlots=new ArrayList<Slot>();

        try{
            while (bookedSlotsInfo.next()){
                Slot slotToShow=new Slot(null,null,null,null);
                slotToShow.setSlotId(bookedSlotsInfo.getInt(1));
                slotToShow.setDate(bookedSlotsInfo.getDate(2));
                slotToShow.setTime(bookedSlotsInfo.getString(3));
                slotToShow.setCenterId(bookedSlotsInfo.getInt(4));

                Integer isAvailable=bookedSlotsInfo.getInt(5);
                if(isAvailable==1){
                    slotToShow.setAvailable(true);
                }
                else{
                    slotToShow.setAvailable(false);
                }

                ArrayList<String> waitlistedCustomers=new ArrayList<String>();
                String waitlistedCustomersString=bookedSlotsInfo.getString(6);
                if(waitlistedCustomersString!=null){
                    String[] convertedCustomerList = waitlistedCustomersString.split(",");
                    waitlistedCustomers.addAll(Arrays.asList(convertedCustomerList));
                }
                slotToShow.setWaitlistedCustomerIds(waitlistedCustomers);

                slotToShow.setCustomerId(bookedSlotsInfo.getString(7));

                Integer isApproved=bookedSlotsInfo.getInt(8);
                if(isApproved==1){
                    slotToShow.setApproved(true);
                }
                else{
                    slotToShow.setApproved(false);
                }

                bookedSlots.add(slotToShow);
            }
        }catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }

        System.out.println(ANSI_YELLOW + "Slot ID      | Slot Date    | Slot Time    | Availability" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "-------------|--------------|--------------|--------------" + ANSI_RESET);

        for (Slot currentSlot : bookedSlots) {
            String slotString = String.format("%-13d| %-13s| %-13s| %-13b", currentSlot.getSlotId(), currentSlot.getDate().toString(), currentSlot.getTime(), currentSlot.isAvailable());
            System.out.println(ANSI_YELLOW + slotString + ANSI_RESET);
        }
    }


    // Cancel a booking for a slot
    public void cancelBooking(Integer slotId) {
//         Implementation to cancel a booking
//         Validate input, update database, etc.
        ResultSet slotResult=slotDAO.getSlotById(slotId);
        Slot currentSlot=new Slot(null,null,null,null);

        try{
            while (slotResult.next()){
                currentSlot.setSlotId(slotResult.getInt(1));
                currentSlot.setDate(slotResult.getDate(2));
                currentSlot.setTime(slotResult.getString(3));
                currentSlot.setCenterId(slotResult.getInt(4));

                Integer isAvailable=slotResult.getInt(5);
                if(isAvailable==1){
                    currentSlot.setAvailable(true);
                }
                else{
                    currentSlot.setAvailable(false);
                }

                ArrayList<String> waitlistedCustomers=new ArrayList<String>();
                String waitlistedCustomersString=slotResult.getString(6);
                if(waitlistedCustomersString!=null){
                    String[] convertedCustomerList = waitlistedCustomersString.split(",");
                    waitlistedCustomers.addAll(Arrays.asList(convertedCustomerList));
                }
                currentSlot.setWaitlistedCustomerIds(waitlistedCustomers);

                currentSlot.setCustomerId(slotResult.getString(7));

                Integer isApproved=slotResult.getInt(8);
                if(isApproved==1){
                    currentSlot.setApproved(true);
                }
                else{
                    currentSlot.setApproved(false);
                }
            }
        }catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }

        currentSlot.setAvailable(true);
        currentSlot.setCustomerId(null);
        if(!currentSlot.getWaitlistedCustomerIds().isEmpty()){
            currentSlot.setAvailable(false);
            String removedCustomerId=currentSlot.getWaitlistedCustomerIds().remove(0);
            currentSlot.setCustomerId(removedCustomerId);
        }

        slotDAO.cancelSlotBooking(currentSlot);
//        System.out.println(currentSlot.getCustomerId());
        System.out.println(ANSI_GREEN + "Booking Cancelled" + ANSI_RESET);    }

    // Other business methods
}
