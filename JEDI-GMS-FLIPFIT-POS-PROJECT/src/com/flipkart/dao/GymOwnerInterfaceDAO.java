package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

import java.util.ArrayList;

public interface GymOwnerInterfaceDAO {
    void registerGymOwner(GymOwner gymOwner);

    String getGymOwnerId();

    void addDummyDataGymOwner();

    ArrayList<GymOwner> getDummyData();

    void onboardGym(int gymOwnerId, int centerId);

    GymOwner getGymOwnerById(String ownerId);

    void updateGymOwner(GymOwner gymOwner);

    void deleteGymOwner(String ownerId);
}
