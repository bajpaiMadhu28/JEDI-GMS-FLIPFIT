package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Slot;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SlotDAO implements SlotDAOInterface {

    ArrayList<Slot> slots = new ArrayList<Slot>();
    Connection conn = null;
    PreparedStatement stmt = null;
    // Add methods for CRUD operations on Slot entities

    public void addDummyDataSlot(){
        slots.add(new Slot(1, (java.sql.Date) new Date(),"9 AM - 10 AM",1));
        slots.add(new Slot(2,(java.sql.Date)new Date(),"10 AM - 11 AM",1));
        slots.add(new Slot(3,(java.sql.Date)new Date(),"11 AM - 12 PM",1));
        slots.add(new Slot(4,(java.sql.Date) new Date(),"12 PM - 1 PM",1));
        slots.get(0).setAvailable(false);
        slots.get(0).setCustomerId("45");
        slots.get(0).addWaitlistedCustomerIds("test ID 123");
    }

    public ArrayList<Slot> getAllDummySlots(){
        return slots;
    }
    public ArrayList<Slot> getDummyData(Integer centerId){
        ArrayList<Slot> filteredSlots=new ArrayList<Slot>();
        for(Slot currentSlot:slots){
//            System.out.println(filteredSlots.size()+" "+centerId+" "+currentSlot.getCenterId());
            if(currentSlot.getCenterId()==centerId){
                filteredSlots.add(currentSlot);
            }
        }
        System.out.println(filteredSlots.size());
        return filteredSlots;
    }

    public ResultSet getAllSlots(Integer centerId){
        ResultSet answerSet=null;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.GET_ALL_SLOTS);
            stmt.setInt(1, centerId);
            ResultSet output = stmt.executeQuery();
            answerSet=output;

            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return answerSet;
    }

    // Save a new Slot
    public boolean saveSlot(Slot slot) {
        // Implementation to save a slot to the database
        // Validate input, insert into the database, etc.
        return false;
    }

    // Retrieve Slot details by slotId
    public ResultSet getSlotById(Integer slotId) {
        ResultSet answerSet=null;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.GET_SLOT_BY_ID);
            stmt.setInt(1, slotId);
            ResultSet output = stmt.executeQuery();
            answerSet=output;

            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return answerSet;
    }

    public ResultSet getBookedSlotsByCustomerId(String customerId){
        ResultSet answerSet=null;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.GET_BOOKED_SLOTS_BY_CUSTOMER_ID);
            stmt.setString(1, customerId);
            ResultSet output = stmt.executeQuery();
            answerSet=output;

            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return answerSet;
    }

    // Update Slot details
    public void updateSlot(Slot slot) {
        // Implementation to update slot details in the database
        // You may use JDBC or any other data access mechanism
    }

    // Delete Slot by slotId
    public void deleteSlot(Integer slotId) {
        // Implementation to delete slot details from the database based on the slotId
        // You may use JDBC or any other data access mechanism
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.REMOVE_GYM_SLOT_QUERY);
            stmt.setInt(1, slotId);
            stmt.executeUpdate();
            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    // Get available slots for a center
    public List<Slot> getAvailableSlots(Integer centerId) {
        // Implementation to retrieve available slots for a center from the database
        // You may use JDBC or any other data access mechanism
        return null; // Placeholder, replace with actual implementation
    }

    // Book a slot for a customer
    public Boolean bookSlot(Slot slot) {
        // Implementation to book a slot
        // Validate input, check availability, update database, etc.
        Boolean bookedSuccessfully=true;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.BOOK_SLOT);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1,slot.getCustomerId());
            stmt.setInt(2, slot.getSlotId());  // This would set age
            stmt.executeUpdate();

            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            bookedSuccessfully=false;
        }
        return bookedSuccessfully;
    }

    // Update the waitlist for a slot
    public void updateWaitlist(Slot slot) {
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.UPDATE_WAITLIST);

            // Hard coded d
            //Bind values into the parameters.

            String commaSeparatedList = slot.getWaitlistedCustomerIds().toString();
            commaSeparatedList = commaSeparatedList.replace("[", "").replace("]", "").replace(" ", "");

            stmt.setString(1,commaSeparatedList);
            stmt.setInt(2, slot.getSlotId());  // This would set age
            stmt.executeUpdate();

            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }


    }

    public void cancelSlotBooking(Slot slot) {
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.CANCEL_BOOKING);

            // Hard coded d
            //Bind values into the parameters.

            String commaSeparatedList = slot.getWaitlistedCustomerIds().toString();
            commaSeparatedList = commaSeparatedList.replace("[", "").replace("]", "").replace(" ", "");

            stmt.setInt(1,slot.isAvailable() ? 1 : 0);
            stmt.setString(2, slot.getCustomerId());
            stmt.setString(3, commaSeparatedList);
            stmt.setInt(4,slot.getSlotId());// This would set age
            stmt.executeUpdate();

            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }


    }

    // Add a new slot to the database
    public boolean addSlot(Slot slot) {
        // Implementation to add a new slot to the database
        // Validate input, insert into the database, etc.
        return false; // Placeholder, replace with actual implementation
    }

    // Check if a slot already exists in the database
    public boolean isSlotAlreadyExists(Slot slot) {
        // Implementation to check if a slot already exists in the database
        // Placeholder, replace with actual implementation
        return false;
    }
}
