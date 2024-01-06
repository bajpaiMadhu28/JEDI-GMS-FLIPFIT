package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Customer;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtils;

public class AdminDAO {

    ArrayList<Admin> flipfitAdmin = new ArrayList<Admin>();
    Connection conn = null;
    PreparedStatement stmt = null;
    static Integer adminId=0;
    public void registerAdmin(Admin admin) {
        // Implementation to save admin details to the database
        // You may use JDBC or any other data access mechanism
        try{

            // Step 4 make/open  a connection

            //			      System.out.println("Connecting to database...");
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.REGISTER_ADMIN);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1, admin.getDepartment());  // This would set age
            stmt.setString(2,admin.getUsername());
            stmt.setString(3, admin.getPassword());
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

    public boolean authenticateAdmin(String username,String password){
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
            stmt = conn.prepareStatement(SqlQueryConstant.AUTHENTICATE_ADMIN);

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

    public ResultSet getAllUnapprovedCenters(){
        ResultSet answerSet=null;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.GET_UNAPPROVED_CENTERS_QUERY);
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
}
