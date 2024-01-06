package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Customer;
import com.flipkart.dao.AdminDAO;

import java.util.ArrayList;

public class AdminService {
    private AdminDAO adminDAO;

    // Constructor
    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    // Business logic methods for admins
    public void registerAdmin(Admin admin) {
        adminDAO.registerAdmin(admin);
    }

    public boolean authenticateAdmin(String username, String password) {
        ArrayList<Admin> currentAdmins = adminDAO.getDummyAdminData();
        for (Admin admin : currentAdmins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Other business methods
}

///**
// *
// */
//package com.flipkart.business;
//
//import com.flipkart.bean.*;
//import com.flipkart.dao.*;
//import java.util.List;
//
///**
// * This class implements the AdminGMSInterface and provides the functionality for admin operations in the Gym Management System.
// */
//public class AdminGMSService implements AdminGMSInterface {
//
//    AdminGMSDaoImpl adminGMSDao = new AdminGMSDaoImpl();
//
//    /**
//     * Retrieves a list of all gym owners in the system.
//     * @return List of GymOwner objects
//     */
//    public List<GymOwner> seeAllGymOwner() {
//        return adminGMSDao.seeAllGymOwner();
//    }
//
//    /**
//     * Retrieves a list of all gyms in the system.
//     * @return List of Gymnasium objects
//     */
//    public List<Gymnasium> seeAllGyms() {
//        return adminGMSDao.seeAllGyms();
//    }
//
//    /**
//     * Retrieves a list of pending gym owner requests.
//     * @return List of GymOwner objects
//     */
//    public List<GymOwner> seePendingGymOwnerRequest() {
//        return adminGMSDao.seePendingGymOwnerRequest();
//    }
//
//    /**
//     * Retrieves a list of pending gym requests.
//     * @return List of Gymnasium objects
//     */
//    public List<Gymnasium> seePendingGymRequest() {
//        return adminGMSDao.seePendingGymRequest();
//    }
//
//    /**
//     * Approves a single gym owner request.
//     * @param requestId The ID of the request to be approved
//     */
//    public void approveSingleOwnerRequest(String email) {
//        adminGMSDao.approveSingleOwnerRequest(email);
//    }
//
//    /**
//     * Approves all pending gym owner requests.
//     */
//    public void approveAllOwnerRequest() {
//        adminGMSDao.approveAllOwnerRequest();
//    }
//
//    /**
//     * Approves a single gym request.
//     * @param gymId The ID of the gym request to be approved
//     */
//    public void approveSingleGymRequest(int gymId) {
//        adminGMSDao.approveSingleGymRequest(gymId);
//    }
//
//    /**
//     * Approves all pending gym requests.
//     */
//    public void approveAllGymRequest() {
//        adminGMSDao.approveAllGymRequest();
//    }
//}
