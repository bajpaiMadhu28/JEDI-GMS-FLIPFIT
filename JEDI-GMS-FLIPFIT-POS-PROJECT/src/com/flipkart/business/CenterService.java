package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Center;
import com.flipkart.dao.CenterDAO;
import com.flipkart.dao.CenterInterfaceDAO;

public class CenterService {
    private CenterInterfaceDAO centerDAO = new CenterDAO();

    // Business logic methods for centers
    public void getAllCenters() {
        // Implementation to get all centers
        ArrayList<Center> centerList = centerDAO.getDummyData();
        for (Center center : centerList) {
            String centerString = String.format("Center ID : %d Center Name : %s Center Location : %s", center.getCenterId(), center.getName(), center.getLocation());
            System.out.println(centerString);
        }
    }

    public Center getCenterById(int centerId) {
        // Implementation to get a center by ID
        return null;
    }

    public Center getCenterByOwnerId(String ownerId) {
        centerDAO.addDummyDataCenter();;
        for (Center center : centerDAO.getDummyData()) {
            if (center.getOwnerId().equals(ownerId)) {
                return center;
            }
        }
        System.out.println("Center Not found by owner Id !");
        return null;
    }

    public String getOwnerIdByCenterId(String centerId) {
        for (Center center : centerDAO.getDummyData()) {
            if (center.getCenterId().toString().equals(centerId)) {
                return center.getOwnerId();
            }
        }
        System.out.println("OwnerId Not found by Center Id !");
        return null;
    }

    public void updateCenterProfile(Center center) {
        Center centerUpdated = getCenterByOwnerId(center.getOwnerId());

        centerUpdated.setCenterId(center.getCenterId());
        centerUpdated.setOwnerId(center.getOwnerId());
        centerUpdated.setName(center.getName());
        centerUpdated.setLocation(center.getLocation());

        centerDAO.updateCenter(center, centerUpdated);

        System.out.println("\nProfile updated successfully! \n\nUpdated profile is");

        System.out.println("Updated Gym name : " + center.getName());
        System.out.println("Updated location : " + center.getLocation());
        System.out.println("Owner Id : " + center.getOwnerId());
        System.out.println("Center Id : " + center.getCenterId());
    }

    public Integer getCenterId() {
        return centerDAO.getCenterId();
    }

    // Other business methods
}
