package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Center;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.CenterDAO;

public class CenterService {
    private CenterDAO centerDAO;

    // Constructor
    public CenterService(CenterDAO centerDAO) {
        this.centerDAO = centerDAO;
    }

    // Business logic methods for centers
    public void getAllCenters() {
        // Implementation to get all centers
        ArrayList<Center> centerList= centerDAO.getDummyData();
        for(Center center:centerList){
            String centerString=String.format("Center ID : %d Center Name : %s Center Location : %s",center.getCenterId(),center.getName(),center.getLocation());
            System.out.println(centerString);
        }
    }

    public Center getCenterById(int centerId) {
        // Implementation to get a center by ID
        return null;
    }

    public Center getCenterByOwnerId(String ownerId) {
        for(Center center : centerDAO.getDummyData()) {
            System.out.println(center.getOwnerId()+ " - " + ownerId);
            if(center.getOwnerId().equals(ownerId)) {
                return center;
            }
        }
        System.out.println("Center Not found by owner Id !");
        return null;
    }

    public void updateCenterProfile(Center center) {
        Center centerUpdated = getCenterByOwnerId(center.getOwnerId());

        centerUpdated.setCenterId(center.getCenterId());
        centerUpdated.setOwnerId(center.getOwnerId());
        centerUpdated.setName(center.getName());
        centerUpdated.setLocation(center.getLocation());

        System.out.println("\nProfile updated successfully! \n\nUpdated profile is");

        System.out.println("Updated Gym name : " + center.getName());
        System.out.println("Updated location : " + center.getLocation());
        System.out.println("Owner Id : " + center.getOwnerId());
        System.out.println("Center Id : " + center.getCenterId());

    }

    // Other business methods
}
