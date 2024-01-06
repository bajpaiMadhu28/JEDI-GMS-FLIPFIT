package com.flipkart.bean;

public class Admin extends User {
    private String adminId;
    private String department;

    // Constructor
    public Admin(String username, String password, String adminId, String department) {
        super(username, password);
        this.adminId = adminId;
        this.department = department;
    }

    // Getter and setter methods specific to Admin
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

///**
// *
// */
//package com.flipkart.bean;
//
///**
// *
// */
//public class Admin {
//
//    private String email;
//    private String name;
//    private String mobile;
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
