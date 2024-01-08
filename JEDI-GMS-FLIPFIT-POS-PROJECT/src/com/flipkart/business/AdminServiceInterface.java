package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;

import java.util.ArrayList;

/**
 * Interface for Admin Service operations
 */
public interface AdminServiceInterface {

    /**
     * Registers a new admin in the system
     *
     * @param admin The Admin to be registered
     */
    void registerAdmin(Admin admin);

    /**
     * Authenticates an admin based on provided credentials
     *
     * @param username The admin's username
     * @param password The admin's password
     * @return True if authentication is successful, false otherwise
     */
    boolean authenticateAdmin(String username, String password);

    /**
     * Retrieves details of all gym centers in the system
     *
     * @return List of all gym centers
     */
    ArrayList<Center> getAllGymCenters();

    /**
     * Retrieves details of all unapproved gym centers in the system
     *
     * @return List of all unapproved gym centers
     */
    ArrayList<Center> getAllUnapprovedGymCenters();

    /**
     * Approves a gym center in the system
     *
     * @param centerId The ID of the gym center to be approved
     */
    void approveCenter(Integer centerId);

    /**
     * Retrieves details of all unapproved slots in the system
     *
     * @return List of all unapproved slots
     */
    ArrayList<Slot> getUnapprovedSlots();

    /**
     * Approves a slot in the system
     *
     * @param slotId The ID of the slot to be approved
     */
    void approveSlot(Integer slotId);
}
