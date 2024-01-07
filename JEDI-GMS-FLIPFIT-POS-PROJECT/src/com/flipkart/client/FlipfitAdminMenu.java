package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;
import com.flipkart.business.*;
import com.flipkart.dao.*;
import com.flipkart.business.AdminService;
import com.flipkart.business.PaymentService;
import com.flipkart.business.SlotService;
import com.flipkart.exception.AuthenticationFailedException;
import com.flipkart.exception.InvalidMenuOptionException;
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

    private SlotDAO slotDAO = new SlotDAO();

    private CenterDAO centerDAO = new CenterDAO();
    private AdminService adminService = new AdminService(adminDAO);

    InputUtils inputUtils = new InputUtils();

    private void displaySuccessMessage(String message) {
        System.out.println("\u001B[32m" + message + "\u001B[0m"); // Green color for success message
    }

    private void displayErrorMessage(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m"); // Red color for error message
    }

    private void displayTableMessage(String message) {
        System.out.println("\u001B[33m" + message + "\u001B[0m"); // Yellow color for table message
    }


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

    public ArrayList<Slot> getUnapprovedSlots() {
        slotDAO.addDummyDataSlot();
        ArrayList<Slot> flipfitSlots = slotDAO.getAllDummySlots();
        ArrayList<Slot> unapprovedCenters = new ArrayList<>();
        for (Slot slot : flipfitSlots) {
            if (!slot.getApproved()) {
                unapprovedCenters.add(slot);
            }
        }
        return unapprovedCenters;
    }


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
        System.out.println("1. View All Gyms");
        System.out.println("2. View All Gym Owners");
        System.out.println("3. View Pending Gym Owner Requests");
        System.out.println("4. View Pending Gym Requests");
        System.out.println("5. Approve Single slot at once");
        System.out.println("6. Approve All Gym Owner Requests");
        System.out.println("7. Approve Single Gym Request ");
        System.out.println("8. Approve All Gym Requests");
        System.out.println("9. Exit");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        try {
            switch (action) {
                case 1:
                    ArrayList<Center> allGymCenters = adminService.getAllGymCenters();
                    if (allGymCenters.isEmpty()) {
                        displayErrorMessage("No unapproved gym centers found.");
                    } else {
                        displaySuccessMessage("all Gym Centers:");
                        displayTableMessage("----------------------------");
                        System.out.printf("| \u001B[33m%-10s\u001B[0m | \u001B[33m%-15s\u001B[0m |%n", "Center ID", "Name");
                        displayTableMessage("----------------------------");
                        for (Center center : allGymCenters) {
                            System.out.printf("| \u001B[33m%-10s\u001B[0m | \u001B[33m%-15s\u001B[0m |%n", center.getCenterId(), center.getName());
                            displayTableMessage("----------------------------");
                        }
                        System.out.println("----------------------------");
                    }
                    break;

                case 2:
                    // Your code for option 2
                    break;

                case 7:
                    ArrayList<Center> unapprovedCenters = getUnapprovedGymCenters();
                    if (unapprovedCenters.isEmpty()) {
                        displayErrorMessage("No unapproved gym centers found.");
                    } else {
                        displaySuccessMessage("Unapproved Gym Centers:");
                        displayTableMessage("----------------------------");
                        System.out.printf("| \u001B[33m%-10s\u001B[0m | \u001B[33m%-15s\u001B[0m |%n", "Center ID", "Name");
                        displayTableMessage("----------------------------");
                        for (Center center : unapprovedCenters) {
                            System.out.printf("| \u001B[33m%-10s\u001B[0m | \u001B[33m%-15s\u001B[0m |%n", center.getCenterId(), center.getName());
                            displayTableMessage("----------------------------");
                        }
                        System.out.println("----------------------------");

                        int centerId = 1;
                        while (centerId != 0) {
                            System.out.println("Enter the ID of the gym center to approve (or 0 to exit)");
                            centerId = scanner.nextInt();
                            boolean f = false;
                            for (Center center : unapprovedCenters) {
                                if (center.getCenterId() == centerId) {
                                    f = true;
                                    center.setApproved(true);
                                    System.out.println("\n \u001B[32mGym center with ID " + centerId + " has been approved.\n\n\u001B[0m");
                                    break;
                                }
                            }
                            if (!f) {
                                System.out.println("\u001B[31mNo centre for the given centreID\u001B[0m");
                            }
                        }
                    }
                    break;

                case 5:
                    ArrayList<Slot> unapprovedSlots = getUnapprovedSlots();
                    if (unapprovedSlots.isEmpty()) {
                        System.out.println("\u001B[31mNo unapproved gym slots found.\u001B[0m");
                    } else {
                        System.out.println("\u001B[32mUnapproved Gym Slots:\u001B[0m");
                        System.out.println("\u001B[33m-----------------------------------------------------------------\u001B[0m");
                        System.out.printf("| \u001B[33m%-10s\u001B[0m | \u001B[33m%-15s\u001B[0m | \u001B[33m%-15s\u001B[0m |\n", "Centre ID", "Name", "Slot ID");
                        System.out.println("\u001B[33m-----------------------------------------------------------------\u001B[0m");
                        for (Slot slot : unapprovedSlots) {
                            System.out.printf("| \u001B[33m%-10s\u001B[0m | \u001B[33m%-15s\u001B[0m | \u001B[33m%-15s\u001B[0m |\n", slot.getCenterId(), slot.getTime(), slot.getSlotId());
                        }
                        System.out.println("\u001B[33m-----------------------------------------------------------------\u001B[0m");

                        int slotId = 1;
                        while (slotId != 0) {
                            System.out.println("\u001B[33mEnter the ID of the gym slot to approve (or 0 to exit):\u001B[0m");
                            slotId = scanner.nextInt();
                            boolean found = false;
                            for (Slot slot : unapprovedSlots) {
                                if (slot.getSlotId() == slotId) {
                                    slot.setApproved(true);
                                    System.out.println("\u001B[32mGym slot with ID " + slotId + " has been approved.\u001B[0m");
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("\u001B[31mGym slot with ID does not exist\u001B[0m");
                            }
                        }
                    }
                    System.out.println("\u001B[32mExiting admin menu.\u001B[0m");
                    break;

                default:
                    throw new InvalidMenuOptionException("Invalid menu option: " + action);
            }
        }catch(InvalidMenuOptionException e){
                System.out.println(e.getMessage());
            }
        }


    public void displayMenu(String username, String password) {
        String text = "\u001B[34mAdmin Menu !!!\u001B[0m";
        int width = 80; // Adjust this value based on your console width

// Calculate padding for center alignment
        int padding = (width - text.length()) / 2;

// Print centered text in blue color
        System.out.println(String.format("%" + padding + "s%s%" + padding + "s", "", text, ""));
        try {
            adminDAO.addDummyAdminData();
            if (adminService.authenticateAdmin(username, password)) {
                displayLoggedInAdminMenu();
            } else {
                throw new AuthenticationFailedException("Incorrect Credentials");
            }
        } catch (AuthenticationFailedException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
        // Implementation to display the customer menu


    public void displayAdminRegistrationMenu() {
        String text = "\u001B[34mAdmin Registration Menu !!!\u001B[0m";
        int width = 80; // Adjust this value based on your console width

// Calculate padding for center alignment
        int padding = (width - text.length()) / 2;

// Print centered text in blue color
        System.out.println(String.format("%" + padding + "s%s%" + padding + "s", "", text, ""));
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
