package com.flipkart.business;

import com.flipkart.bean.Center;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

/**
 * Interface for the GymOwnerService class providing business logic related to gym owners.
 */
public interface GymOwnerServiceInterface {

    /**
     * Registers a new gym owner in the system.
     *
     * @param gymOwner The GymOwner object containing registration information.
     */
    void registerGymOwner(GymOwner gymOwner);

    /**
     * Authenticates a gym owner based on provided login credentials.
     *
     * @param username The username of the gym owner.
     * @param password The password of the gym owner.
     * @return True if the authentication is successful, false otherwise.
     */
    boolean authenticateGymOwner(String username, String password);

    /**
     * Updates the profile information of an existing gym owner.
     *
     * @param gymOwner The updated GymOwner object.
     */
    void updateGymOwnerProfile(GymOwner gymOwner);

    /**
     * Retrieves the gym owner ID based on provided login credentials.
     *
     * @param username The username of the gym owner.
     * @param password The password of the gym owner.
     * @return The gym owner ID if credentials are valid, otherwise null.
     */
    String getGymOwnerIdByLoginCreds(String username, String password);

    /**
     * Retrieves a GymOwner object by the gym owner ID.
     *
     * @param gymOwnerId The ID of the gym owner.
     * @return The GymOwner object if found, otherwise null.
     */
    GymOwner getGymOwnerById(String gymOwnerId);

    /**
     * Retrieves a GymOwner object by the login credentials.
     *
     * @param username The username of the gym owner.
     * @param password The password of the gym owner.
     * @return The GymOwner object if found, otherwise null.
     */
    GymOwner getGymOwnerByLoginCreds(String username, String password);

    /**
     * Onboards a gym for a gym owner.
     *
     * @param center The Center object representing the gym to be onboarded.
     */
    void onboardGym(Center center);

    /**
     * Displays all gyms associated with a gym owner.
     *
     * @param username The username of the gym owner.
     * @param password The password of the gym owner.
     */
    void displayAllGyms(String username, String password);

    /**
     * Adds a new gym slot to the system.
     *
     * @param slot The Slot object representing the new gym slot.
     */
    void addGymSlot(Slot slot);

    /**
     * Removes a gym slot from the system.
     *
     * @param slotId The ID of the gym slot to be removed.
     */
    void removeGymSlot(String slotId);

    /**
     * Retrieves a unique gym owner ID.
     *
     * @return A unique gym owner ID.
     */
    String getGymOwnerId();

    /**
     * Checks if the provided date is in a valid format.
     *
     * @param date The date to be validated.
     * @return True if the date is in a valid format, false otherwise.
     */
    boolean isValidDateFormat(String date);
}
