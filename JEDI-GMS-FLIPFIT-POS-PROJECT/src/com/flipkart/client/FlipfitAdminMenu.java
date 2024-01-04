package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Center;
import com.flipkart.business.*;
import com.flipkart.dao.*;
import com.flipkart.business.AdminService;
import com.flipkart.business.PaymentService;
import com.flipkart.business.SlotService;
import com.flipkart.utils.InputUtils;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.CenterDAO;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.SlotDAO;
import com.flipkart.utils.InputUtils;

public class FlipfitAdminMenu {
    private Scanner scanner;
    private CenterService centerService;

//    private CenterDAO centerDAO;
    private PaymentService paymentService;
    private SlotService slotService;
    private AdminDAO adminDAO = new AdminDAO();

    private CenterDAO centerDAO = new CenterDAO();
    private AdminService adminService=new AdminService(adminDAO);

    InputUtils inputUtils = new InputUtils();


    // Constructor
//    public FlipfitAdminMenu(
//            Scanner scanner,
//            CenterService centerService,
//            CustomerService customerService,
//            PaymentService paymentService,
//            SlotService slotService
//    ) {
//        this.scanner = scanner;
//        this.centerService = centerService;
//        this.customerService = customerService;
//        this.paymentService = paymentService;
//        this.slotService = slotService;
//    }

    // Methods for admin menu options
//    public void displayMenu(String username, String password) {
//        // Implementation to display the admin menu
//    }

    // Method to approve a gym center by ID
    public ArrayList<Center> getUnapprovedGymCenters() {
        centerDAO.addDummyDataCenter();
        ArrayList<Center> flipfitCenters = centerDAO.getDummyData();
        ArrayList<Center> unapprovedCenters = new ArrayList<>();
        for (Center center : flipfitCenters) {
            if (!center.isApproved()) {
                unapprovedCenters.add(center);
            }
        }
        return unapprovedCenters;
    }
    // Display unapproved gym centers and approve by ID
    private void displayLoggedInAdminMenu() {
        ArrayList<Center> unapprovedCenters = getUnapprovedGymCenters();
        if (unapprovedCenters.isEmpty()) {
            System.out.println("No unapproved gym centers found.");
        } else {
            System.out.println("Unapproved Gym Centers:");
            for (Center center : unapprovedCenters) {
                System.out.println("Center ID: " + center.getCenterId() + ", Name: " + center.getName());
            }
            Scanner scanner = new Scanner(System.in);
            int centerId;
            centerId = 1;
            while(centerId !=0){
                System.out.println("Enter the ID of the gym center to approve (or 0 to exit):");
                centerId = scanner.nextInt();
                    for (Center center : unapprovedCenters) {
                        if (center.getCenterId() == centerId) {
                            center.setApproved(true);
                            System.out.println("Gym center with ID " + centerId + " has been approved.");
                            break; // Exit the loop once the center is found and approved
                        }
                    }
            }
            System.out.println("Exiting admin menu.");
             }
    }
    public void displayMenu(String username, String password) {
        System.out.println("Admin Menu !!!");
        adminDAO.addDummyAdminData();
        if(adminService.authenticateAdmin(username,password)){
            System.out.println("Actual Customer Options!!!");
            displayLoggedInAdminMenu();
        }
        else{
            System.out.println("Incorrect Credentials");
        }

        // Implementation to display the customer menu
    }

    public void displayAdminRegistrationMenu() {
        System.out.println("Admin Registration Menu !!!");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");
        String department = inputUtils.getStringInput("Enter your department: ");

        String adminId = adminDAO.getAdminID();

        Admin admin = new Admin(username, password, adminId, department);
        adminService.registerAdmin(admin);


        // Implementation to display the customer menu
    }

    // Other admin menu methods
}
