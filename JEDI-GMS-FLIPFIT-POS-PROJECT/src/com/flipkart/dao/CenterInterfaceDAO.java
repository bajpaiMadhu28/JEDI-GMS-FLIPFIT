package com.flipkart.dao;

import com.flipkart.bean.Center;

import java.util.ArrayList;

public interface CenterInterfaceDAO {
    void addDummyDataCenter();

    ArrayList<Center> getDummyData();

    Integer getCenterId();

    void saveCenter(Center center);

    void updateCenter(Center center, Center updatedCenter);

    // Other center-related methods
}
