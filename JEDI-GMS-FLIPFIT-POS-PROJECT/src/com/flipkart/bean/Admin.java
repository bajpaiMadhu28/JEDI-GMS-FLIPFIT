package com.flipkart.bean;

/**
 * Admin class extending User class represents an administrator in the system.
 */
public class Admin extends User {

    // Admin-specific attributes
    private String adminId; // Unique identifier for the admin
    private String department; // Department to which the admin belongs

    /**
     * Constructor to initialize Admin object with username, password, adminId, and department.
     *
     * @param username   Username of the admin.
     * @param password   Password of the admin.
     * @param adminId    Unique identifier for the admin.
     * @param department Department to which the admin belongs.
     */
    public Admin(String username, String password, String adminId, String department) {
        super(username, password);
        this.adminId = adminId;
        this.department = department;
    }

    // Getter and setter methods specific to Admin

    /**
     * Getter method to retrieve the admin's unique identifier.
     *
     * @return The admin's unique identifier.
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * Setter method to set the admin's unique identifier.
     *
     * @param adminId The unique identifier to set for the admin.
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /**
     * Getter method to retrieve the department to which the admin belongs.
     *
     * @return The department to which the admin belongs.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Setter method to set the department to which the admin belongs.
     *
     * @param department The department to set for the admin.
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
