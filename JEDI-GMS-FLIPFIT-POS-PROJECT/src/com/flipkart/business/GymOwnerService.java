package com.flipkart.business;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.dao.*;
import com.flipkart.utils.InputUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GymOwnerService {
    private GymOwnerInterfaceDAO gymOwnerDAO = new GymOwnerDAO();
    private SlotInterfaceDAO slotDAO = new SlotDAO();
    private CenterInterfaceDAO centerDAO = new CenterDAO();

    public void registerGymOwner(GymOwner gymOwner) {
        gymOwnerDAO.registerGymOwner(gymOwner);
    }

    public boolean authenticateGymOwner(String username, String password) {
        gymOwnerDAO.addDummyDataGymOwner();
        ArrayList<GymOwner> currentGymOwners = gymOwnerDAO.getDummyData();
        for (GymOwner gymOwner : currentGymOwners) {
            if (gymOwner.getUsername().equals(username) && gymOwner.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void updateGymOwnerProfile(GymOwner gymOwner) {
        GymOwner gymOwnerUpdated = getGymOwnerById(gymOwner.getOwnerId());
        gymOwnerUpdated.setOwnerName(gymOwner.getOwnerName());
        gymOwnerUpdated.setUsername(gymOwner.getUsername());
        gymOwnerUpdated.setPassword(gymOwner.getPassword());
        gymOwnerUpdated.setEmail(gymOwner.getEmail());
        gymOwnerDAO.updateGymOwner(gymOwnerUpdated);
    }

    public String getGymOwnerIdByLoginCreds(String username, String password) {
        ArrayList<GymOwner> currentGymOwners = gymOwnerDAO.getDummyData();
        for (GymOwner gymOwner : currentGymOwners) {
            if (gymOwner.getUsername().equals(username) && gymOwner.getPassword().equals(password)) {
                return gymOwner.getOwnerId();
            }
        }
        return null;
    }

    public GymOwner getGymOwnerById(String gymOwnerId) {
        for (GymOwner gymOwner : gymOwnerDAO.getDummyData()) {
            if (gymOwner.getOwnerId().equals(gymOwnerId)) {
                return gymOwner;
            }
        }
        return null;
    }

    public GymOwner getGymOwnerByLoginCreds(String username, String password) {
        return getGymOwnerById(getGymOwnerIdByLoginCreds(username, password));
    }

    public void onboardGym(Center center) {
        centerDAO.saveCenter(center);
    }

    public void displayAllGyms(String username, String password) {
//        centerDAO.addDummyDataCenter();
        String ownerId = getGymOwnerIdByLoginCreds(username, password);
        System.out.println("\n\nGym name    -     Gym location    -     Gym Id");
//        System.out.println("Center size = "+ centerDAO.getDummyData().size());

        for (Center center : centerDAO.getDummyData()) {
            if (center.getOwnerId().equals(ownerId)) {
                System.out.println(center.getName() + "   -   " + center.getLocation() + "   -   " + center.getCenterId());
            }
        }
    }

    public void addGymSlot(Slot slot) {
        slotDAO.addDummyDataSlot();

        if (isValidSlot(slot)) {
            if (!slotDAO.isSlotAlreadyExists(slot)) {
                slotDAO.addSlot(slot);
            } else {
                System.out.println("Error: Slot already exists.");
            }
        } else {
            System.out.println("Error: Invalid slot parameters.");
        }
    }

    private boolean isValidSlot(Slot slot) {
        if (slot.getDate() == null || !isValidDateFormat(slot.getDate())) {
            System.out.println("Error: Invalid date format. Please enter date in DD/MM/YYYY format.");
            return false;
        }
        return true;
    }

    private boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public void removeGymSlot(String slotId) {
        slotDAO.addDummyDataSlot();
        slotDAO.deleteSlot(slotId);
    }

    public String getGymOwnerId() {
        return gymOwnerDAO.getGymOwnerId();
    }

    public void addGymsToDummyData() {
        centerDAO.addDummyDataCenter();
    }
}
