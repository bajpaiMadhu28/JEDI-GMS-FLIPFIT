package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Customer;

public class AdminDAO implements AdminInterfaceDAO {

    ArrayList<Admin> flipfitAdmin = new ArrayList<Admin>();
    static Integer adminId = 0;

    public void registerAdmin(Admin admin) {
        // Implementation to save admin details to the database
        // You may use JDBC or any other data access mechanism
        flipfitAdmin.add(admin);
        System.out.println("successful");
    }

    public String getAdminID() {
        return (++adminId).toString();
    }

    public void addDummyAdminData() {
        flipfitAdmin.add(new Admin("techAdmin", "12345", "45", "Technical"));
        flipfitAdmin.add(new Admin("payAdmin", "12345", "45", "payments"));
        flipfitAdmin.add(new Admin("logAdmin", "12345", "45", "logistics"));
    }

    public ArrayList<Admin> getDummyAdminData() {
        return flipfitAdmin;
    }
}
