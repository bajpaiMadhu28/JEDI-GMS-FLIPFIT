package com.flipkart.dao;

import com.flipkart.bean.Center;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Interface for Center Data Access Object (DAO) operations
 */
public interface CenterDAOInterface {

    /**
     * Saves a new center to the database
     *
     * @param center The center to be saved
     * @return True if the center is successfully saved, false otherwise
     */
    boolean saveCenter(Center center);

    /**
     * Adds dummy data for centers
     */
    void addDummyDataCenter();

    /**
     * Retrieves all dummy centers
     *
     * @return List of dummy centers
     */
    ArrayList<Center> getDummyData();

    /**
     * Retrieves all centers from the database
     *
     * @return ResultSet containing all centers
     */
    ResultSet getAllCenters();

    /**
     * Updates center information in the database
     *
     * @param center The updated center information
     */
    void updateCenterInfo(Center center);

    // Other center-related methods
}
