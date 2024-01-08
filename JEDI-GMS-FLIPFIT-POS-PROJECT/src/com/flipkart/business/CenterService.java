package com.flipkart.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Center;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.CenterDAO;
import com.flipkart.exception.CentreNotFoundException;

public class CenterService {
    private CenterDAO centerDAO;

    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_GREEN = "\u001B[32m";


    // Constructor
    public CenterService(CenterDAO centerDAO) {
        this.centerDAO = centerDAO;
    }

    // Business logic methods for centers
    public void getAllCenters() {
        // Implementation to get all centers
        ResultSet centerInfo = centerDAO.getAllCenters();
        ArrayList<Center> centerList = new ArrayList<Center>();

        try {
            while (centerInfo.next()) {
                Center centerToShow = new Center(centerInfo.getInt(1), centerInfo.getString(2), centerInfo.getString(3), centerInfo.getString(4));
                Integer isApproved = centerInfo.getInt(5);
                if (isApproved == 1) {
                    centerToShow.setApproved(true);
                } else {
                    centerToShow.setApproved(false);
                }
                centerList.add(centerToShow);
            }
        } catch (SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }



// Assuming centerList is the list of Center objects to be displayed in tabular format

// Print table header
        System.out.println(ANSI_YELLOW + "------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-20s |%n", "Center ID", "Center Name", "Center Location");
        System.out.println("------------------------------------------------------------" + ANSI_RESET);

// Loop through the list and display each center in tabular format
        for (Center center : centerList) {
            System.out.printf("| %-10s | %-20s | %-20s |%n", center.getCenterId(), center.getName(), center.getLocation());
        }

// Print table footer
        System.out.println(ANSI_YELLOW + "------------------------------------------------------------" + ANSI_RESET);
    }

        public Center getCenterById(int centerId) {
        // Implementation to get a center by ID
        return null;
    }

    public Center getCenterByOwnerId(String ownerId) {
        for (Center center : centerDAO.getDummyData()) {
            System.out.println(center.getOwnerId() + " - " + ownerId);
            if (center.getOwnerId().equals(ownerId)) {
                return center;
            }
        }

        throw new CentreNotFoundException("Center not found with owner ID: " + ownerId);
    }

    public void updateCenterProfile(Center center) {
        Center centerUpdated = getCenterByOwnerId(center.getOwnerId());

        centerUpdated.setCenterId(center.getCenterId());
        centerUpdated.setOwnerId(center.getOwnerId());
        centerUpdated.setName(center.getName());
        centerUpdated.setLocation(center.getLocation());

        System.out.println(ANSI_GREEN + "\nProfile updated successfully! \n\nUpdated profile is" + ANSI_RESET);

        System.out.println("Updated Gym name : " + center.getName());
        System.out.println("Updated location : " + center.getLocation());
        System.out.println("Owner Id : " + center.getOwnerId());
        System.out.println("Center Id : " + center.getCenterId());

    }

    // Other business methods
}
