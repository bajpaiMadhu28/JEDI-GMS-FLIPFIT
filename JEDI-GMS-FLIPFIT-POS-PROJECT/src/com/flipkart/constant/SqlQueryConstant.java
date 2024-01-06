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






}
