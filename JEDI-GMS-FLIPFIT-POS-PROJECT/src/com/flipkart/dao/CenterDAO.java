package com.flipkart.dao;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CenterDAO {
    ArrayList<Center> flipfitCenters = new ArrayList<Center>();
    Connection conn = null;
    PreparedStatement stmt = null;
    public boolean saveCenter(Center center) {
        // Implementation to save a center to the database
        // Validate input, insert into the database, etc.
        return false;
    }

    public void addDummyDataCenter() {
        flipfitCenters.add(new Center(1, "Fitness123", "Bellandur", "1"));
        flipfitCenters.add(new Center(2, "NewFitness123", "ETV", "1"));
        flipfitCenters.add(new Center(3, "SuperFitness123", "HSR", "2"));
        flipfitCenters.add(new Center(4, "SuperFitness", "HSR", "2"));
        flipfitCenters.add(new Center(5, "Fitness1", "Bellandur", "3"));
        flipfitCenters.add(new Center(6, "NewFitness1", "ETV", "3"));
        flipfitCenters.add(new Center(7, "SuperFitness1", "HSR", "4"));
        flipfitCenters.add(new Center(8, "SuperFitness", "HSR", "4"));
    }

    public ArrayList<Center> getDummyData(){
        return flipfitCenters;
    }

    public ResultSet getAllCenters(){
        ResultSet answerSet=null;
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.GET_CENTERS_QUERY);
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

    public void updateCenterInfo(Center center){
        try{
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SqlQueryConstant.UPDATE_CENTER_INFO);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1,center.getName());
            stmt.setString(2,center.getLocation());
            stmt.setInt(3,center.getCenterId());
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

    // Other center-related methods
}
