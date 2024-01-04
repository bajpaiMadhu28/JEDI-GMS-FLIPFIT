package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;

public class GymOwnerDAO {
    ArrayList<GymOwner> flipfitGymOwners = new ArrayList<GymOwner>();

    static Integer gymOwnerId = 0;

    // Register a new GymOwner
    public void registerGymOwner(GymOwner gymOwner) {
        // Implementation to register a new gym owner in the database
        // You may use JDBC or any other data access mechanism
        flipfitGymOwners.add(gymOwner);
    }

    public String getGymOwnerId() {
        return (++gymOwnerId).toString();
    }

    public void addDummyDataGymOwner() {
        flipfitGymOwners.add(new GymOwner("Arjav", "arjavjn", "12345", "1", "Spartan", "arjav@gmail.com" ));
        flipfitGymOwners.add(new GymOwner("Madhu", "Madhubp", "12345", "2", "Cult fit", "madhu@gmail.com" ));
        flipfitGymOwners.add(new GymOwner("Prachir", "prachirag", "12345", "3", "Gold Gym", "prachir@gmail.com" ));
    }

    public ArrayList<GymOwner> getDummyData() {
        return flipfitGymOwners;
    }

    // Onboard a gym for a GymOwner
    public void onboardGym(int gymOwnerId, int centerId) {
        // Implementation to onboard a gym for a gym owner
        // Validate input, check availability, update database, etc.
        // Example: Save gym registration information
        // Implementation depends on your specific requirements
    }

    // Retrieve GymOwner details by ownerId
    public GymOwner getGymOwnerById(String ownerId) {
        for( GymOwner gymOwner : flipfitGymOwners) {
            if( gymOwner.getOwnerId().equals(ownerId)) {
                return gymOwner;
            }
        }
        System.out.println("No Gym Owner with this id found");
        return null;
    }

    // Delete GymOwner by ownerId
    public void deleteGymOwner(String ownerId) {
        // Implementation to delete gym owner details from the database based on the ownerId
        // You may use JDBC or any other data access mechanism
    }
}
