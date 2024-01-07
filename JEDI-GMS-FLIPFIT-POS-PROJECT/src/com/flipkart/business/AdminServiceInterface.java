package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;

import java.util.ArrayList;

public interface AdminServiceInterface {
    public void registerAdmin(Admin admin);
    public boolean authenticateAdmin(String username, String password);
    public ArrayList<Center> getAllGymCenters();
    public ArrayList<Center> getAllUnapprovedGymCenters();
    public void approveCenter(Integer centerId);
    public ArrayList<Slot> getUnapprovedSlots();
    public void approveSlot(Integer slotId);

}
