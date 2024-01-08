package com.flipkart.dao;

import com.flipkart.bean.Admin;

import java.sql.ResultSet;

/**
 * Interface for Admin Data Access Object (DAO) operations
 */
public interface AdminDAOInterface {
    /**
     * Registers a new admin in the system.
     *
     * @param admin The Admin object to be registered
     */
    void registerAdmin(Admin admin);

    /**
     * Authenticates an admin based on the provided username and password.
     *
     * @param username The username of the admin
     * @param password The password of the admin
     * @return True if authentication is successful, false otherwise
     */
    boolean authenticateAdmin(String username, String password);

    /**
     * Retrieves all unapproved gym centers.
     *
     * @return ResultSet containing information about unapproved gym centers
     */
    ResultSet getAllUnapprovedCenters();

    /**
     * Retrieves all gym centers in the system.
     *
     * @return ResultSet containing information about all gym centers
     */
    ResultSet getAllGymCenters();

    /**
     * Approves a gym center based on its centerId.
     *
     * @param centerId The ID of the gym center to be approved
     */
    void approveGymCenter(Integer centerId);

    /**
     * Retrieves all unapproved gym slots.
     *
     * @return ResultSet containing information about unapproved gym slots
     */
    ResultSet getAllUnapprovedSlots();

    /**
     * Approves a gym slot based on its slotId.
     *
     * @param slotId The ID of the gym slot to be approved
     */
    void approveGymSlot(Integer slotId);
}
