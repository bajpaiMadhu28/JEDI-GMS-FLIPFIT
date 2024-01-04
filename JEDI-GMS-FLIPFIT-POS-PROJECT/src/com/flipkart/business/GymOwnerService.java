package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.dao.GymOwnerDAO;
import com.flipkart.dao.SlotDAO;
import com.flipkart.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerService {
    private GymOwnerDAO gymOwnerDAO;
    private SlotDAO slotDAO;
    private InputUtils inputUtils = new InputUtils();
    // Constructor
    public GymOwnerService(GymOwnerDAO gymOwnerDAO, SlotDAO slotDAO) {
        this.gymOwnerDAO = gymOwnerDAO;
        this.slotDAO = slotDAO;
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
        gymOwnerUpdated.setGymName(gymOwner.getGymName());

        System.out.println("Profile updated successfully! \n Updated profile is");

        System.out.println("Updated owner name : " + gymOwnerUpdated.getOwnerName());
        System.out.println("Updated username : " + gymOwnerUpdated.getUsername());
        System.out.println("Updated password : " + gymOwnerUpdated.getPassword());
        System.out.println("Updated email : " + gymOwnerUpdated.getEmail());
        System.out.println("Updated gym name : " + gymOwnerUpdated.getGymName());

    }

    public String getGymOwnerIdByLoginCreds(String username, String password){
        ArrayList<GymOwner> currentGymOwners = gymOwnerDAO.getDummyData();
        for(GymOwner gymOwner:currentGymOwners){
            if(gymOwner.getUsername().equals(username) && gymOwner.getPassword().equals(password)){
                return gymOwner.getOwnerId();
            }
        }
        return null;
    }

    public GymOwner getGymOwnerById ( String gymOwnerId) {
        for(GymOwner gymOwner : gymOwnerDAO.getDummyData()) {
            if(gymOwner.getOwnerId().equals(gymOwnerId)) {
                return gymOwner;
            }
        }
        System.out.println("getGymOwnerById failed");
        return null;
    }

    public void onboardGym(int gymOwnerId, int centerId) {
        // Implementation to onboard a gym for a gym owner
        // Validate input, check availability, update database, etc.
        // Example: Save gym registration information
        // Implementation depends on your specific requirements
        gymOwnerDAO.onboardGym(gymOwnerId, centerId);
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
        // Your validation logic here
        // Check if the time, duration, and other parameters are valid
        return true; // Placeholder, replace with actual validation logic
    }

    // Other business methods for gym owners
}
