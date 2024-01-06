package com.flipkart.dao;

import com.flipkart.bean.Center;

import java.util.ArrayList;


public class CenterDAO implements CenterInterfaceDAO {
    ArrayList<Center> flipfitCenters = new ArrayList<>();

    public void addDummyDataCenter() {
        flipfitCenters.add(new Center(1, "Fitness123", "Bellandur", "1"));
        flipfitCenters.add(new Center(2, "NewFitness123", "ETV", "1"));
        flipfitCenters.add(new Center(3, "SuperFitness123", "HSR", "2"));
        flipfitCenters.add(new Center(4, "SuperFitness", "HSR", "2"));
        flipfitCenters.add(new Center(5, "Fitness1", "Bellandur", "3"));
        flipfitCenters.add(new Center(6, "NewFitness1", "ETV", "3"));
        flipfitCenters.add(new Center(7, "SuperFitness1", "HSR", "4"));
        flipfitCenters.add(new Center(8, "SuperFitness", "HSR", "4"));
    }

    public ArrayList<Center> getDummyData() {
        return flipfitCenters;
    }

    public Integer getCenterId() {
        return flipfitCenters.size() + 1;
    }

    public void saveCenter(Center center) {
        flipfitCenters.add(center);
    }

    public void updateCenter(Center center, Center updatedCenter) {
        for(int i = 0 ; i < flipfitCenters.size(); i++) {
            if(center.getCenterId().equals(flipfitCenters.get(i).getCenterId())) {
                flipfitCenters.set(i, updatedCenter);
            }
        }
    }

    // Other center-related methods
}
