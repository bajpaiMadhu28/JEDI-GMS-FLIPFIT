package com.flipkart.dao;

import com.flipkart.bean.Admin;

import java.sql.ResultSet;

public interface AdminDAOInterface {
    public void registerAdmin(Admin admin);
    public boolean authenticateAdmin(String username,String password);
    public ResultSet getAllUnapprovedCenters();
    public ResultSet getAllGymCenters();
    public void approveGymCenter(Integer centerId);
    public ResultSet getAllUnapprovedSlots();
    public void approveGymSlot(Integer slotId);

}
