package com.flipkart.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Center;
import com.flipkart.dao.CenterDAO;
import com.flipkart.dao.CenterDAOInterface;

/**
 * Interface for the CenterService class providing business logic related to gym centers.
 */
public interface CenterServiceInterface {

    /**
     * Retrieves details of all centers in the system and displays them in tabular format.
     */
    void getAllCenters();

    /**
     * Retrieves a center by its ID.
     *
     * @param centerId The ID of the center to be retrieved.
     * @return The Center object corresponding to the provided ID.
     */
    Center getCenterById(int centerId);

    /**
     * Retrieves a center by its owner's ID.
     *
     * @param ownerId The ID of the owner whose center is to be retrieved.
     * @return The Center object corresponding to the provided owner's ID.
     */
    Center getCenterByOwnerId(String ownerId);

    /**
     * Updates the profile of a center in the system.
     *
     * @param center The Center object containing the updated profile information.
     */
    void updateCenterProfile(Center center);

    // Other business methods (if any)
}
