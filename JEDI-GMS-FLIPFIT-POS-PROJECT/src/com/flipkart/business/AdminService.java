package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.dao.AdminInterfaceDAO;

import java.util.ArrayList;

public class AdminService {
    private AdminInterfaceDAO adminDAO;

    // Constructor
    public AdminService(AdminInterfaceDAO adminDAO) {
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
