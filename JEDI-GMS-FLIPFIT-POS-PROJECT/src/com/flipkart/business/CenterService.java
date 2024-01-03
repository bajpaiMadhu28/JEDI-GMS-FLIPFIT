package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Center;
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

    // Other business methods
}
