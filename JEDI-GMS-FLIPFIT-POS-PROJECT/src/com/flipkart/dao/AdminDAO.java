package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Customer;

public class AdminDAO {

    ArrayList<Admin> flipfitAdmin = new ArrayList<Admin>();
    static Integer adminId=0;
    public void registerAdmin(Admin admin) {
        // Implementation to save admin details to the database
        // You may use JDBC or any other data access mechanism
        flipfitAdmin.add(admin);
        System.out.println("successful");
    }

    public String getAdminID(){
        return (++adminId).toString();
    }

    public void addDummyAdminData(){
        flipfitAdmin.add(new Admin("techAdmin","12345","45","Technical"));
        flipfitAdmin.add(new Admin("payAdmin","12345","45","payments"));
        flipfitAdmin.add(new Admin("logAdmin","12345","45","logistics"));
    }

    public ArrayList<Admin> getDummyAdminData(){
        return flipfitAdmin;
    }
}
//package com.flipkart.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.flipkart.bean.GymOwner;
//import com.flipkart.bean.Gymnasium;
//import com.flipkart.business.AdminGMSInterface;
//import com.flipkart.constants.SQLConstants;
//import com.flipkart.utils.InputUtils;
//
//public class AdminGMSDaoImpl implements AdminGMSInterface {
//
//    Connection conn = null;
//    PreparedStatement stmt = null;
//
//    public List<GymOwner> seeAllGymOwner() {
//
//        List<GymOwner> gymOwnerDetails = new ArrayList<GymOwner>();
//
//        try {
//            conn = DBUtils.getConnection();
//            System.out.println("Fetching gym owners..");
//
//            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYMOWNERS);
//
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()) {
//                GymOwner gymOwner = new GymOwner();
//                gymOwner.setEmail(rs.getString("email"));
//                gymOwner.setName(rs.getString("name"));
//                gymOwner.setMobile(rs.getString("mobile"));
//                gymOwner.setDob(rs.getString("dob"));
//                gymOwner.setAadhaarNumber(rs.getString("aadharNumber"));
//                gymOwner.setPanNumber(rs.getString("panNumber"));
//                gymOwner.setGstNumber(rs.getString("gstNumber"));
//                gymOwner.setAddress(rs.getString("address"));
//                gymOwner.setApproved(rs.getBoolean("approved"));
//                gymOwnerDetails.add(gymOwner);
//            }
//
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
//
//        return gymOwnerDetails;
//    }
//
//    public List<Gymnasium> seeAllGyms() {
//
//        List<Gymnasium> gymDetails = new ArrayList<Gymnasium>();
//
//        try {
//            conn = DBUtils.getConnection();
//            System.out.println("Fetching gyms..");
//
//            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYMS);
//
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()) {
//                Gymnasium gym = new Gymnasium();
//                gym.setGymId(rs.getInt("gymId"));
//                gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
//                gym.setName(rs.getString("name"));
//                gym.setAddress(rs.getString("address"));
//                gym.setNumItem(rs.getInt("numItem"));
//                gym.setTotalArea(rs.getDouble("totalArea"));
//                gym.setApproved(rs.getInt("isApproved"));
//                gymDetails.add(gym);
//            }
//
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
//
//        return gymDetails;
//        // TODO Auto-generated method stub
//
//    }
//
//    public List<GymOwner> seePendingGymOwnerRequest() {
//        // TODO Auto-generated method stub
//        List<GymOwner> gymOwnerDetails = new ArrayList<GymOwner>();
//
//        try {
//            conn = DBUtils.getConnection();
//            System.out.println("Fetching pending gym owners..");
//
//            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_NOT_APPROVED_GYMOWNERS);
//
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()) {
//                GymOwner gymOwner = new GymOwner();
//                gymOwner.setEmail(rs.getString("email"));
//                gymOwner.setName(rs.getString("name"));
//                gymOwner.setMobile(rs.getString("mobile"));
//                gymOwner.setDob(rs.getString("dob"));
//                gymOwner.setAadhaarNumber(rs.getString("aadharNumber"));
//                gymOwner.setPanNumber(rs.getString("panNumber"));
//                gymOwner.setGstNumber(rs.getString("gstNumber"));
//                gymOwner.setAddress(rs.getString("address"));
//                gymOwner.setApproved(rs.getBoolean("approved"));
//                gymOwnerDetails.add(gymOwner);
//            }
//
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
//
//        return gymOwnerDetails;
//    }
//
//    public List<Gymnasium> seePendingGymRequest() {
//        // TODO Auto-generated method stub
//        List<Gymnasium> gymDetails = new ArrayList<Gymnasium>();
//
//        try {
//            conn = DBUtils.getConnection();
//            System.out.println("Fetching gyms..");
//
//            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_NOT_APPROVED_GYMS);
//
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()) {
//                Gymnasium gym = new Gymnasium();
//                gym.setGymId(rs.getInt("gymId"));
//                gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
//                gym.setName(rs.getString("name"));
//                gym.setAddress(rs.getString("address"));
//                gym.setNumItem(rs.getInt("numItem"));
//                gym.setTotalArea(rs.getDouble("totalArea"));
//                gym.setApproved(rs.getInt("isApproved"));
//                gymDetails.add(gym);
//            }
//
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
//
//        return gymDetails;
//    }
//
//
//    public void approveSingleOwnerRequest(String email) {
//        // TODO Auto-generated method stub
//        try {
//            conn = DBUtils.getConnection();
//            System.out.println("Fetching gyms owners..");
//
//            stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_OWNER_BY_ID);
//            stmt.setString(1, email);
//            stmt.executeUpdate();
//            System.out.println("The gym owner has been approved!");
//
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
//    }
//
//
//    public void approveAllOwnerRequest() {
//        // TODO Auto-generated method stub
//        try {
//            conn = DBUtils.getConnection();
//
//            stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_ALL_GYMOWNERS);
//            stmt.executeUpdate();
//            System.out.println("All gyms owners have been approved!");
//
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
//    }
//
//
//    public void approveSingleGymRequest(int gymId) {
//        // TODO Auto-generated method stub
//        try {
//            conn = DBUtils.getConnection();
//            System.out.println("Fetching gyms..");
//
//            stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_GYM_BY_ID);
//            stmt.setInt(1, gymId);
//            stmt.executeUpdate();
//            System.out.println("The gym has been approved!");
//
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
//    }
//
//
//    public void approveAllGymRequest() {
//
//        try {
//            conn = DBUtils.getConnection();
//            System.out.println("Fetching gyms..");
//
//            stmt = conn.prepareStatement(SQLConstants.SQL_APPROVE_ALL_GYMS);
//            stmt.executeUpdate();
//            System.out.println("All gyms have been approved!");
//
//        } catch (SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        }
//        // TODO Auto-generated method stub
//    }
//
//}
