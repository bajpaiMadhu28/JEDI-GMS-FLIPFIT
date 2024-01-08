package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.RegistrationFailedException;

import java.util.ArrayList;

public interface GymOwnerInterfaceDAO {
    void registerGymOwner(GymOwner gymOwner) throws RegistrationFailedException;

    String getGymOwnerId();

    void addDummyDataGymOwner();

    ArrayList<GymOwner> getDummyData();

    void onboardGym(int gymOwnerId, int centerId);

    GymOwner getGymOwnerById(String ownerId) throws GymOwnerNotFoundException;

    void updateGymOwner(GymOwner gymOwner);

    void deleteGymOwner(String ownerId);
}
