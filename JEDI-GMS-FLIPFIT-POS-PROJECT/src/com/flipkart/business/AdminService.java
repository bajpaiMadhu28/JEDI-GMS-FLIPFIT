package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.dao.AdminDAO;

public class AdminService {
    private AdminDAO adminDAO;

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

    // Other business methods
}
