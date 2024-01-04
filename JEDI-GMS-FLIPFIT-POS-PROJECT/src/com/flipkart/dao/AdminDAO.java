package com.flipkart.dao;

import java.util.List;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Center;

public class AdminDAO {

    // Add methods for CRUD operations on Admin entities

    // Save a new Admin
    public void registerAdmin(Admin admin) {
        // Implementation to save admin details to the database
        // You may use JDBC or any other data access mechanism
    }
    public List<Center> getAllGyms() {
        // Implementation to fetch and return all gyms from the database

        // For illustration purposes, let's return a dummy list
        return List.of(
                new Center(1, "Gym1", "Location1"),
                new Center(2, "Gym2", "Location2"),
                new Center(3, "Gym3", "Location3")
        );
    }
}
