package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceInterface;
import com.flipkart.constant.CommonConstant;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.AdminDAOInterface;
import com.flipkart.utils.DateUtils;
import com.flipkart.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing the admin menu for the Flipfit application.
 */
public class FlipfitAdminMenu {
    private AdminDAOInterface adminDAO = new AdminDAO();
    private AdminServiceInterface adminService = new AdminService(adminDAO);

    InputUtils inputUtils = new InputUtils();

    /**
     * Display success message in green color.
     *
     * @param message The success message to be displayed.
     */
    private void displaySuccessMessage(String message) {
        System.out.println("\u001B[32m" + message + "\u001B[0m"); // Green color for success message
    }

    /**
     * Display error message in red color.
     *
     * @param message The error message to be displayed.
     */
    private void displayErrorMessage(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m"); // Red color for error message
    }

    /**
     * Display table message in yellow color.
     *
     * @param message The table message to be displayed.
     */
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


    // Method to approve a gym center by ID


    /**
     * Display the logged-in admin menu options.
     */
    private void displayLoggedInAdminMenu() {
//        System.out.println("\u001B[34m\n1 - Approve Gym Center\n2 - approve Slots\u001B[0m");
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
        if (action == 1) {
            ArrayList<Center> allGymCenters = adminService.getAllGymCenters();
            if (allGymCenters.isEmpty()) {
                displayErrorMessage("No gym centers found.");
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
        } else if (action == 2) {


        } else if (action == 7) {
            ArrayList<Center> unapprovedCenters = adminService.getAllUnapprovedGymCenters();
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
                int centerId;
                System.out.println("Enter the ID of the gym center to approve");
                centerId = scanner.nextInt();
                adminService.approveCenter(centerId);
                System.out.println("\n \u001B[32mGym center with ID " + centerId + " has been approved.\n\n\u001B[0m");
            }
        } else if (action == 5) {
            ArrayList<Slot> unapprovedSlots = adminService.getUnapprovedSlots();
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
                int slotId;
                System.out.println("\u001B[33mEnter the ID of the gym slot to approve:\u001B[0m");
                slotId = scanner.nextInt();
                adminService.approveSlot(slotId);
                System.out.println("\u001B[32mGym slot with ID " + slotId + " has been approved.\u001B[0m");
            }

            System.out.println("\u001B[32mExiting admin menu.\u001B[0m");
        }
    }

    /**
     * Display the main admin menu based on provided username and password.
     *
     * @param username The admin username.
     * @param password The admin password.
     */

    public void displayMenu(String username, String password) {
        String text = "\u001B[34mAdmin Menu !!!\u001B[0m";
        int width = 80; // Adjust this value based on your console width

// Calculate padding for center alignment
        int padding = (width - text.length()) / 2;

// Print centered text in blue color
        System.out.println(String.format("%" + padding + "s%s%" + padding + "s", "", text, ""));
        if (adminService.authenticateAdmin(username, password)) {
            DateUtils.getLoggedInDateTime();
            displayLoggedInAdminMenu();
        } else {
            System.out.println(CommonConstant.INCORRECT_CREDENTIALS);
        }

        // Implementation to display the customer menu
    }

    /**
     * Display admin registration menu.
     */
    public void displayAdminRegistrationMenu() {
        String text = "\u001B[34mAdmin Registration Menu !!!\u001B[0m";
        int width = 80; // Adjust this value based on your console width

// Calculate padding for center alignment
        int padding = (width - text.length()) / 2;

// Print centered text in blue color
        System.out.println(String.format("%" + padding + "s%s%" + padding + "s", "", text, ""));
        String username = inputUtils.getStringInput(CommonConstant.INPUT_USERNAME);
        String password = inputUtils.getStringInput(CommonConstant.INPUT_PASSWORD);
        String department = inputUtils.getStringInput("Enter your department: ");


        Admin admin = new Admin(username, password, null, department);
        adminService.registerAdmin(admin);


        // Implementation to display the customer menu
    }

    // Other admin menu methods
}
