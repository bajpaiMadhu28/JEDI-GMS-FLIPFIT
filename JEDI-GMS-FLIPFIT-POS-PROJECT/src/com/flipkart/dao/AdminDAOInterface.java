package com.flipkart.dao;

import java.sql.ResultSet;

import com.flipkart.bean.Admin;

public interface AdminDAOInterface {

    void registerAdmin(Admin admin);

    String getAdminID();

    void addDummyAdminData();

    boolean authenticateAdmin(String username, String password);

    ResultSet getAllUnapprovedCenters();
}
