package com.flipkart.business;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.dao.*;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.utils.InputUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GymOwnerService {
    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private SlotDAO slotDAO = new SlotDAO();
    private CenterDAO centerDAO = new CenterDAO();
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_GREEN = "\u001B[32m";

    public void registerGymOwner(GymOwner gymOwner) throws RegistrationFailedException {
        gymOwnerDAO.registerGymOwner(gymOwner);
    }

    public boolean authenticateGymOwner(String username, String password) {
        return gymOwnerDAO.authenticateGymOwner(username, password);
    }

    public void updateGymOwnerProfile(GymOwner gymOwner) {
        gymOwnerDAO.updateGymOwnerInfo(gymOwner);
    }

    public String getGymOwnerIdByLoginCreds(String username, String password) {
        return gymOwnerDAO.getGymOwnerIdByLoginCreds(username, password);
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
        gymOwnerDAO.addGymCenter(center);
    }

    public void displayAllGyms(String username, String password) {
        String ownerId = getGymOwnerIdByLoginCreds(username, password);
        ResultSet centerInfo = gymOwnerDAO.getCentersForOwner(ownerId);
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

    public void addGymSlot(Slot slot) {
        gymOwnerDAO.addGymSlot(slot);
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

    public void removeGymSlot(Integer slotId) {
        slotDAO.deleteSlot(slotId);
    }

    public String getGymOwnerId() {
        return gymOwnerDAO.getGymOwnerId();
    }
}
