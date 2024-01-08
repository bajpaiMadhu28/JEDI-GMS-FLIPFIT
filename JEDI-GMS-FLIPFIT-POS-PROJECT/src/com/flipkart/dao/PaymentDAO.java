package com.flipkart.dao;

import com.flipkart.bean.Payment;
import com.flipkart.constant.SqlQueryConstant;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO implements PaymentInterfaceDAO {
    public boolean savePayment(Payment payment) {


        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQueryConstant.SAVE_PAYMENT);

            // Hard coded d
            //Bind values into the parameters.
            stmt.setString(1, payment.getCustomerId());
            stmt.setDouble(2, payment.getAmount());
            stmt.setString(3, payment.getUpiId());
//            stmt.setString(3, payment.setPassword());
            stmt.executeUpdate();

            //STEP 6: Clean-up environment
            // rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
//        try (Connection conn = DBUtils.getConnection()) {
//            String query = "INSERT INTO payments (paymentId, customerId, amount, isSuccessful) VALUES (?, ?, ?, ?)";
//            PreparedStatement pstmt = conn.prepareStatement(query);
//
//
//            int rowsAffected = pstmt.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException | SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
        return false;
    }

    public Payment getPaymentDetails(Integer paymentId) {

        // Implementation to retrieve payment details from the database
        // Validate input, query the database, etc.
        return null;
    }

    // Other payment-related methods
}
