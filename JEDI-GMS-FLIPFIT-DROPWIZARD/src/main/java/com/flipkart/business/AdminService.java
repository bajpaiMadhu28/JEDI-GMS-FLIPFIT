package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Slot;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.AdminDAOInterface;
import com.flipkart.dao.SlotDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminService implements AdminServiceInterface {
    private AdminDAOInterface adminDAO;
    private SlotDAO slotDAO=new SlotDAO();

    // Constructor
    public AdminService(AdminDAOInterface adminDAO) {
        this.adminDAO = adminDAO;
    }

    // Business logic methods for admins
    public void registerAdmin(Admin admin) {
        adminDAO.registerAdmin(admin);
    }

    public boolean authenticateAdmin(String username, String password) {
        return adminDAO.authenticateAdmin(username,password);
    }

    public ArrayList<Center> getAllGymCenters() {
        ResultSet centerInfo= adminDAO.getAllGymCenters();
        ArrayList<Center> centerList= new ArrayList<Center>();

        try{
            while (centerInfo.next()){
                Center centerToShow=new Center(centerInfo.getInt(1),centerInfo.getString(2),centerInfo.getString(3),centerInfo.getString(4));
                Integer isApproved=centerInfo.getInt(5);
                if(isApproved==1){
                    centerToShow.setApproved(true);
                }
                else{
                    centerToShow.setApproved(false);
                }
                centerList.add(centerToShow);
            }
        }catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }

        return centerList;
    }

    public ArrayList<Center> getAllUnapprovedGymCenters() {
        ResultSet centerInfo= adminDAO.getAllUnapprovedCenters();
        ArrayList<Center> centerList= new ArrayList<Center>();

        try{
            while (centerInfo.next()){
                Center centerToShow=new Center(centerInfo.getInt(1),centerInfo.getString(2),centerInfo.getString(3),centerInfo.getString(4));
                Integer isApproved=centerInfo.getInt(5);
                if(isApproved==1){
                    centerToShow.setApproved(true);
                }
                else{
                    centerToShow.setApproved(false);
                }
                centerList.add(centerToShow);
            }
        }catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }

        return centerList;
    }

    public void approveCenter(Integer centerId){
        adminDAO.approveGymCenter(centerId);
    }

    public ArrayList<Slot> getUnapprovedSlots(){
        ResultSet slotResult= adminDAO.getAllUnapprovedSlots();
        ArrayList<Slot> currentSlots=new ArrayList<Slot>();

        try{
            while (slotResult.next()){
                Slot slotToShow=new Slot(null,null,null,null);
                slotToShow.setSlotId(slotResult.getInt(1));
                slotToShow.setDate(slotResult.getDate(2));
                slotToShow.setTime(slotResult.getString(3));
                slotToShow.setCenterId(slotResult.getInt(4));

                Integer isAvailable=slotResult.getInt(5);
                if(isAvailable==1){
                    slotToShow.setAvailable(true);
                }
                else{
                    slotToShow.setAvailable(false);
                }

                ArrayList<String> waitlistedCustomers=new ArrayList<String>();
                String waitlistedCustomersString=slotResult.getString(6);
                if(waitlistedCustomersString!=null){
                    String[] convertedCustomerList = waitlistedCustomersString.split(",");
                    waitlistedCustomers.addAll(Arrays.asList(convertedCustomerList));
                }
                slotToShow.setWaitlistedCustomerIds(waitlistedCustomers);

                slotToShow.setCustomerId(slotResult.getString(7));

                Integer isApproved=slotResult.getInt(8);
                if(isApproved==1){
                    slotToShow.setApproved(true);
                }
                else{
                    slotToShow.setApproved(false);
                }

                currentSlots.add(slotToShow);
            }
        }catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        }
        return currentSlots;
    }

    public void approveSlot(Integer slotId){
        adminDAO.approveGymSlot(slotId);
    }

    // Other business methods
}
