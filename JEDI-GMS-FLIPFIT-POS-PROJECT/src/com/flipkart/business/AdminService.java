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
