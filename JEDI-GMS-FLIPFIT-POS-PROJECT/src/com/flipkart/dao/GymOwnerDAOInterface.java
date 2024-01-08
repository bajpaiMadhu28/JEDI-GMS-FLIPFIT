package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Interface for GymOwner Data Access Object (DAO) operations
 */
public interface GymOwnerDAOInterface {

    /**
     * Registers a new GymOwner in the database
     *
     * @param gymOwner The GymOwner to be registered
     */
    void registerGymOwner(GymOwner gymOwner);

    /**
     * Authenticates a GymOwner based on provided credentials
     *
     * @param username The GymOwner's username
     * @param password The GymOwner's password
     * @return True if authentication is successful, false otherwise
     */
    boolean authenticateGymOwner(String username, String password);

    /**
     * Retrieves the GymOwner's ID based on provided login credentials
     *
     * @param username The GymOwner's username
     * @param password The GymOwner's password
     * @return The GymOwner's ID if found, else null
     */
    String getGymOwnerIdByLoginCreds(String username, String password);

    /**
     * Retrieves centers associated with a GymOwner
     *
     * @param ownerId The ID of the GymOwner
     * @return ResultSet containing centers associated with the GymOwner
     */
    ResultSet getCentersForOwner(String ownerId);

    /**
     * Updates GymOwner information in the database
     *
     * @param gymOwner The updated GymOwner information
     */
    void updateGymOwnerInfo(GymOwner gymOwner);

    /**
     * Adds a GymCenter to the database
     *
     * @param center The GymCenter to be added
     */
    void addGymCenter(Center center);

    /**
     * Adds a GymSlot to the database
     *
     * @param slot The GymSlot to be added
     */
    void addGymSlot(Slot slot);

    /**
     * Retrieves the GymOwner's ID
     *
     * @return The GymOwner's ID
     */
    String getGymOwnerId();

    /**
     * Adds dummy data for GymOwners
     */
    void addDummyDataGymOwner();

    /**
     * Retrieves dummy data for GymOwners
     *
     * @return List of GymOwners
     */
    ArrayList<GymOwner> getDummyData();

    /**
     * Onboards a gym for a GymOwner
     *
     * @param gymOwnerId The ID of the GymOwner
     * @param centerId   The ID of the GymCenter
     */
    void onboardGym(int gymOwnerId, int centerId);

    /**
     * Retrieves GymOwner details by ID
     *
     * @param ownerId The ID of the GymOwner
     * @return The GymOwner details if found, else null
     */
    GymOwner getGymOwnerById(String ownerId);

    /**
     * Updates GymOwner details
     *
     * @param gymOwner The updated GymOwner information
     */
    void updateGymOwner(GymOwner gymOwner);

    /**
     * Deletes a GymOwner from the database
     *
     * @param ownerId The ID of the GymOwner to be deleted
     */
    void deleteGymOwner(String ownerId);
}
