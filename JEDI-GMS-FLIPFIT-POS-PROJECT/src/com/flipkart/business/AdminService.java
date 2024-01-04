package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Center;
import com.flipkart.dao.AdminDAO;

import java.util.List;

public class AdminService {
    private static AdminDAO adminDAO=new AdminDAO();

    // Constructor
    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    // Business logic methods for admins
    public void registerAdmin(Admin admin) {
        // Implementation to register an admin
        // Validate input, check uniqueness, update database, etc.
        adminDAO.registerAdmin(admin);
    }

    public static List<Center> viewAllGyms() {
        // Implementation to retrieve and return all gyms
        return adminDAO.getAllGyms();
    }

    // Other business methods
}
