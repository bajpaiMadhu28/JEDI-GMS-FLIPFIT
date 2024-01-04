package com.flipkart.dao;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;

import java.util.ArrayList;


public class CenterDAO {
    ArrayList<Center> flipfitCenters = new ArrayList<Center>();
    public boolean saveCenter(Center center) {
        // Implementation to save a center to the database
        // Validate input, insert into the database, etc.
        return false;
    }

    public void addDummyDataCenter(){
        flipfitCenters.add(new Center(1,"Fitness123","Bellandur", "1"));
        flipfitCenters.add(new Center(2,"NewFitness123","ETV", "2"));
        flipfitCenters.add(new Center(3,"SuperFitness123","HSR", "3"));
    }

    public ArrayList<Center> getDummyData(){
        return flipfitCenters;
    }

    // Other center-related methods
}
