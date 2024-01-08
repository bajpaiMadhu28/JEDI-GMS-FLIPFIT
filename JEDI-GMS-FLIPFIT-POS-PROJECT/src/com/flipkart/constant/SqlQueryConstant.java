package com.flipkart.constant;

public class SqlQueryConstant {
    // customer constants queries
    public static final String INSERT_CUSTOMER_QUERY = "INSERT INTO customer(name,email,username,password) values(?, ?, ?, ?)";
    public static final String GET_CENTERS_QUERY="Select * From center Where approved=1";
    public static final String GET_CUSTOMER_BY_LOGIN_CREDS="Select * From customer Where username=? AND password=?";
    public static final String AUTHENTICATE_CUSTOMER="Select * From customer Where username=? AND password=?";
    public static final String UPDATE_CUSTOMER_INFO="Update customer Set name=?,email=?,username=?,password=? WHERE id=?";
    public static final String GET_ALL_SLOTS="Select * From slot Where center_id=?";
    public static final String GET_SLOT_BY_ID="Select * From slot Where id=?";
    public static final String GET_BOOKED_SLOTS_BY_CUSTOMER_ID="Select * From slot Where customer_id=? AND is_available=0";
    public static final String BOOK_SLOT="Update slot Set is_available=0,customer_id=? WHERE id=?";
    public static final String UPDATE_WAITLIST="Update slot Set waitlisted_customers=? WHERE id=?";
    public static final String CANCEL_BOOKING="Update slot Set is_available=?,customer_id=?,waitlisted_customers=? WHERE id=?";
    public static final String REGISTER_ADMIN="INSERT INTO admin(department,username,password) values(?, ?, ?)";
    public static final String AUTHENTICATE_ADMIN="Select * From admin Where username=? AND password=?";
    public static final String GET_UNAPPROVED_CENTERS_QUERY="Select * From center Where approved is NULL or approved=0";
    public static final String GET_ALL_CENTERS_QUERY="Select * From center";
    public static final String APPROVE_GYM_CENTER="Update center Set approved=1 WHERE id=?";
    public static final String GET_ALL_UNAPPROVED_SLOTS="Select * From slot Where is_approved is NULL or is_approved=0";
    public static final String APPROVE_GYM_SLOT="Update slot Set is_approved=1 WHERE id=?";
    public static final String INSERT_GYM_OWNER_QUERY = "INSERT INTO gym_owner(name,username,password,email) values(?, ?, ?, ?)";
    public static final String AUTHENTICATE_GYM_OWNER="Select * From gym_owner Where username=? AND password=?";
    public static final String GET_GYM_OWNER_BY_LOGIN_CREDS="Select * From gym_owner Where username=? AND password=?";
    public static final String GET_CENTERS_FOR_GYM_OWNER="Select * From center Where owner_id=?";
    public static final String UPDATE_GYM_OWNER_INFO="Update gym_owner Set name=?,username=?,password=?,email=? WHERE id=?";
    public static final String INSERT_GYM_CENTER_QUERY = "INSERT INTO center(name,location,owner_id) values(?, ?, ?)";
    public static final String UPDATE_CENTER_INFO="Update center Set name=?,location=? WHERE id=?";
    public static final String INSERT_GYM_SLOT_QUERY = "INSERT INTO slot(date,time,center_id,is_available) values(?, ?, ?, 1)";

}
