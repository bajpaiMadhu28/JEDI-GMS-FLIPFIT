package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Slot;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import com.flipkart.utils.DBUtils;

public class CustomerDAO {
    ArrayList<Customer> flipfitCustomers = new ArrayList<Customer>();
    static Integer customerId=0;
    Connection conn = null;
    PreparedStatement stmt = null;
    public void registerCustomer(Customer customer) {
        // Implementation to save a customer to the database
        // Validate input, insert into the database, etc.
//        flipfitCustomers.add(customer);
            try{

                // Step 4 make/open  a connection

    //			      System.out.println("Connecting to database...");
                conn = DBUtils.getConnection();
                stmt = conn.prepareStatement(SqlQueryConstant.INSERT_CUSTOMER_QUERY);

                // Hard coded d
                //Bind values into the parameters.
                stmt.setString(1, customer.getName());  // This would set age
                stmt.setString(2,customer.getEmail());
                stmt.setString(3, customer.getUsername());
                stmt.setString(4, customer.getPassword());
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

    public String getCustomerIdByLoginCreds(String username,String password){
        String customerId=null;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.GET_CUSTOMER_BY_LOGIN_CREDS);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet output = stmt.executeQuery();
            if(output.next()){
                customerId=output.getString(1);
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
        return customerId;
    }

    public String getCustomerId(){
        return (++customerId).toString();
    }

    public void addDummyDataCustomer(){
        flipfitCustomers.add(new Customer("prachir123","12345","45","prachir","prachir@prachir.com"));
        flipfitCustomers.add(new Customer("arjav123","12345","46","arjav","arjav@prachir.com"));
        flipfitCustomers.add(new Customer("madhu123","12345","47","madhu","madhu@prachir.com"));
    }

    public ArrayList<Customer> getDummyData(){
        return flipfitCustomers;
    }

    public boolean authenticateCustomer(String username,String password){
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
            stmt = conn.prepareStatement(SqlQueryConstant.AUTHENTICATE_CUSTOMER);

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

    public void updateCustomerInfo(String name,String email,String username,String password,String customerId){
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.UPDATE_CUSTOMER_INFO);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1,name);
            stmt.setString(2,email);
            stmt.setString(3,username);
            stmt.setString(4,password);
            stmt.setString(5,customerId);
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

    public Customer getCustomerById(String customerId) {
        // Implementation to retrieve slot details from the database based on the slotId
        // You may use JDBC or any other data access mechanism
        for(Customer currentCustomer:flipfitCustomers){
            if(Objects.equals(customerId, currentCustomer.getCustomerId())){
                return currentCustomer;
            }
        }
        return null; // Replace with actual logic
    }

    // Other customer-related methods
}
