package com.flipkart.dao;

import com.flipkart.bean.Admin;

import java.util.ArrayList;

public interface AdminInterfaceDAO {
    void registerAdmin(Admin admin);

    String getAdminID();

    void addDummyAdminData();

    ArrayList<Admin> getDummyAdminData();
}
