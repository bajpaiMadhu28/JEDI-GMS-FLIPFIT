package com.flipkart.dao;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.flipkart.dao.CustomerDAO.customerId;

public class GymOwnerDAO implements GymOwnerInterfaceDAO {
    ArrayList<GymOwner> flipfitGymOwners = new ArrayList<GymOwner>();
    Connection conn = null;
    PreparedStatement stmt = null;

    static Integer gymOwnerId = 0;

    // Register a new GymOwner
    public void registerGymOwner(GymOwner gymOwner) throws RegistrationFailedException {
        try {
            // Implementation to register a new gym owner in the database
            // You may use JDBC or any other data access mechanism
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.INSERT_GYM_OWNER_QUERY);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1, gymOwner.getOwnerName());
            stmt.setString(2, gymOwner.getUsername());
            stmt.setString(3, gymOwner.getPassword());
            stmt.setString(4, gymOwner.getEmail());
            stmt.executeUpdate();

            //STEP 6: Clean-up environment
            // rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            throw new RegistrationFailedException(gymOwner.getOwnerId());
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            throw new RegistrationFailedException(gymOwner.getOwnerId());
        }
    }

    public boolean authenticateGymOwner(String username,String password){
        boolean isAuthenticated=false;
        try{

            // Step 4 make/open  a connection

            //			      System.out.println("Connecting to database...");
            conn = DBUtils.getConnection();

            //STEP 4: Execute a query
            //			      System.out.println("Creating statement...");
            //String sql = "UPDATE Employees set age=? WHERE id=?";
            // String sql1="delete from employee where id=?";
            // stmt.setInt(1, 101);
            stmt = conn.prepareStatement(SqlQueryConstant.AUTHENTICATE_GYM_OWNER);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet output = stmt.executeQuery();
            if(output.next()) {
                isAuthenticated=true;
            }
            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    public String getGymOwnerIdByLoginCreds(String username,String password){
        String gymOwnerId=null;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.GET_GYM_OWNER_BY_LOGIN_CREDS);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet output = stmt.executeQuery();
            if(output.next()){
                gymOwnerId=output.getString(1);
            }

            //STEP 6: Clean-up environment
            // rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return gymOwnerId;
    }

    public ResultSet getCentersForOwner(String ownerId){
        ResultSet answerSet=null;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.GET_CENTERS_FOR_GYM_OWNER);
            stmt.setString(1,ownerId);
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

    public void updateGymOwnerInfo(GymOwner gymOwner){
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.UPDATE_GYM_OWNER_INFO);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1,gymOwner.getOwnerName());
            stmt.setString(2,gymOwner.getUsername());
            stmt.setString(3,gymOwner.getPassword());
            stmt.setString(4,gymOwner.getEmail());
            stmt.setString(5,gymOwner.getOwnerId());
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

    public void addGymCenter(Center center){
        try{

            // Step 4 make/open  a connection

            //			      System.out.println("Connecting to database...");
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.INSERT_GYM_CENTER_QUERY);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1, center.getName());  // This would set age
            stmt.setString(2,center.getLocation());
            stmt.setString(3, center.getOwnerId());
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

    public String getGymOwnerId() {
        return (++gymOwnerId).toString();
    }

    public void addDummyDataGymOwner() {
        flipfitGymOwners.add(new GymOwner("Arjav", "arjavjn", "12345", "1", "arjav@gmail.com"));
        flipfitGymOwners.add(new GymOwner("Madhu", "Madhubp", "12345", "2", "madhu@gmail.com"));
        flipfitGymOwners.add(new GymOwner("Prachir", "prachirag", "12345", "3", "prachir@gmail.com"));
    }

    public ArrayList<GymOwner> getDummyData() {
        return flipfitGymOwners;
    }

    // Onboard a gym for a GymOwner
    public void onboardGym(int gymOwnerId, int centerId) {
        // Implementation to onboard a gym for a gym owner
        // Validate input, check availability, update database, etc.
        // Example: Save gym registration information
        // Implementation depends on your specific requirements
    }

    // Retrieve GymOwner details by ownerId
    public GymOwner getGymOwnerById(String ownerId) throws GymOwnerNotFoundException {
        for (GymOwner gymOwner : flipfitGymOwners) {
            if (gymOwner.getOwnerId().equals(ownerId)) {
                return gymOwner;
            }
        }
        throw new GymOwnerNotFoundException("No Gym Owner found with ownerId: " + ownerId);
    }

    @Override
    public void updateGymOwner(GymOwner gymOwner) {
        String ownerId = gymOwner.getOwnerId();

        for (int i = 0 ; i < flipfitGymOwners.size(); i++) {
            if(flipfitGymOwners.get(i).getOwnerId().equals(ownerId)) {
                flipfitGymOwners.set(i, gymOwner);
            }
        }

    }

    // Delete GymOwner by ownerId
    public void deleteGymOwner(String ownerId) {
        // Implementation to delete gym owner details from the database based on the ownerId
        // You may use JDBC or any other data access mechanism
    }
}
