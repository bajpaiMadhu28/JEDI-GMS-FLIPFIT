package com.flipkart.business;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.dao.CenterDAO;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.dao.SlotDAO;
import com.flipkart.utils.InputUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GymOwnerService {
    private GymOwnerDAO gymOwnerDAO;
    private SlotDAO slotDAO;

    private CenterDAO centerDAO;

    // Constructor
    public GymOwnerService(GymOwnerDAO gymOwnerDAO, SlotDAO slotDAO, CenterDAO centerDAO) {
        this.gymOwnerDAO = gymOwnerDAO;
        this.slotDAO = slotDAO;
        this.centerDAO = centerDAO;
    }

    // Business logic methods for gym owners
    public void registerGymOwner(GymOwner gymOwner) {
        // Implementation to register a gym owner
        // Validate input, check uniqueness, update database, etc.
        gymOwnerDAO.registerGymOwner(gymOwner);
    }

    public boolean authenticateGymOwner(String username, String password) {
        ArrayList<GymOwner> currentGymOwners = gymOwnerDAO.getDummyData();
        for (GymOwner gymOwner : currentGymOwners) {
            if (gymOwner.getUsername().equals(username) && gymOwner.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void updateGymOwnerProfile(GymOwner gymOwner) {

        GymOwner gymOwnerUpdated = getGymOwnerById(gymOwner.getOwnerId());

        gymOwnerUpdated.setOwnerName(gymOwner.getOwnerName());
        gymOwnerUpdated.setUsername(gymOwner.getUsername());
        gymOwnerUpdated.setPassword(gymOwner.getPassword());
        gymOwnerUpdated.setEmail(gymOwner.getEmail());

        System.out.println("Profile updated successfully! \n Updated profile is");

        System.out.println("Updated owner name : " + gymOwnerUpdated.getOwnerName());
        System.out.println("Updated username : " + gymOwnerUpdated.getUsername());
        System.out.println("Updated password : " + gymOwnerUpdated.getPassword());
        System.out.println("Updated email : " + gymOwnerUpdated.getEmail());

    }

    public String getGymOwnerIdByLoginCreds(String username, String password) {
        ArrayList<GymOwner> currentGymOwners = gymOwnerDAO.getDummyData();
        for (GymOwner gymOwner : currentGymOwners) {
            if (gymOwner.getUsername().equals(username) && gymOwner.getPassword().equals(password)) {
                return gymOwner.getOwnerId();
            }
        }
        return null;
    }

    public GymOwner getGymOwnerById(String gymOwnerId) {
        for (GymOwner gymOwner : gymOwnerDAO.getDummyData()) {
            if (gymOwner.getOwnerId().equals(gymOwnerId)) {
                return gymOwner;
            }
        }
        System.out.println("getGymOwnerById failed");
        return null;
    }

    public GymOwner getGymOwnerByLoginCreds(String username, String password) {
        return getGymOwnerById(getGymOwnerIdByLoginCreds(username, password));
    }

    public void onboardGym(Center center) {
        centerDAO.saveCenter(center);
    }

    public void displayAllGyms(String username, String password) {
        String ownerId = getGymOwnerIdByLoginCreds(username, password);

        System.out.println("\n\nGym name    -     Gym location    -     Gym Id");
        for (Center center : centerDAO.getDummyData()) {
            if (center.getOwnerId().equals(ownerId)) {
                System.out.println(center.getName() + "   -   " + center.getLocation() + "   -   " + center.getCenterId());
            }
        }
    }

    // Gym Owner-specific method to add a new gym slot
    public void addGymSlot(Slot slot) {
        // Example: Validate input parameters
        if (isValidSlot(slot)) {
            // Example: Check uniqueness
            if (!slotDAO.isSlotAlreadyExists(slot)) {
                // Example: Save the new slot to the database
                slotDAO.addSlot(slot);
            } else {
                // Handle case where the slot already exists
                System.out.println("Error: Slot already exists.");
            }
        } else {
            // Handle case where input parameters are not valid
            System.out.println("Error: Invalid slot parameters.");
        }
    }

    // Example: Validation method (customize based on your requirements)
    private boolean isValidSlot(Slot slot) {
        // Check if the date is not null and in the correct format
        if (slot.getDate() == null || !isValidDateFormat(slot.getDate())) {
            System.out.println("Error: Invalid date format. Please enter date in DD/MM/YYYY format.");
            return false;
        }

        // Check if the time is not empty and in the correct format
//        if (slot.getTime().isEmpty() || !isValidTimeFormat(slot.getTime())) {
//            System.out.println("Error: Invalid time format. Please enter time in HH:MM AM/PM - HH:MM AM/PM format.");
//            return false;
//        }

        // Add more validation checks as needed...

        // If all validation checks pass, return true
        return true;
    }

    private boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // To enforce strict date parsing

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

//    private boolean isValidTimeFormat(String time) {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a - hh:mm a");
//        timeFormat.setLenient(false); // To enforce strict time parsing
//
//        try {
//            timeFormat.parse(time);
//            return true;
//        } catch (ParseException e) {
//            return false;
//        }
//    }

    public void removeGymSlot(String slotId) {
        slotDAO.deleteSlot(slotId);
    }

    // Other business methods for gym owners
}
