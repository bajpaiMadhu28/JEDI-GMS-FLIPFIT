package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.business.CenterService;
import com.flipkart.business.CustomerService;
import com.flipkart.business.PaymentService;
import com.flipkart.business.SlotService;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.CenterDAO;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.dao.SlotDAO;
import com.flipkart.utils.InputUtils;

public class FlipfitCustomerMenu {
    private Scanner scanner;
    private BookingDAO bookingDAO = new BookingDAO();
    private CustomerDAO customerDAO=new CustomerDAO();
    private CenterDAO centerDAO=new CenterDAO();
    private CustomerService customerService=new CustomerService(customerDAO,bookingDAO);
    private CenterService centerService=new CenterService(centerDAO);
    private PaymentService paymentService;
    private SlotDAO slotDAO = new SlotDAO();
    private SlotService slotService=new SlotService(slotDAO);

    private String customerId;
    InputUtils inputUtils=new InputUtils();

    // Constructor
//    public FlipfitCustomerMenu(
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

    // Methods for customer menu options

    private void displaySlotsForCenter() {
        int centerId = inputUtils.getIntInput("Enter Center ID to see slots: ");
        slotDAO.addDummyDataSlot();
        slotService.getAllSlots(centerId);
        int slotId = inputUtils.getIntInput("Enter Slot ID to book slot: ");
        slotService.bookSlot(slotId, customerId);
    }

    private void displayCustomerUpdate() {
        String name = inputUtils.getStringInput("Enter your new name: ");
        String email = inputUtils.getStringInput("Enter your new email: ");
        String username = inputUtils.getStringInput("Enter your new username: ");
        String password = inputUtils.getStringInput("Enter your new password: ");
        customerService.updateCustomerInfo(name, email, username, password, customerId);
    }

    private void displayCancelBooking() {
        int slotId = inputUtils.getIntInput("Enter Slot ID to cancel: ");
        slotService.cancelBooking(slotId);
    }

    private void displayBookedCustomerSlots() {
        slotService.showBookedSlots(customerId);
        int functionCode = inputUtils.getIntInput("Enter your functions (1 for Cancel Booking, 2 for Exit):");
        switch (functionCode) {
            case 1:
                displayCancelBooking();
                break;
            case 2:
                break;
            default:
                displayErrorMessage("Invalid function. Please try again.");
                displayBookedCustomerSlots();
        }
    }

    private void displayLoggedInUserMenu() {
        int functionCode = inputUtils.getIntInput("Enter your functions (1 for Display Centers, 2 for Edit Profile, 3 for View Booked Slots): ");
        switch (functionCode) {
            case 1:
                centerDAO.addDummyDataCenter();
                centerService.getAllCenters();
                displaySlotsForCenter();
                break;
            case 2:
                displayCustomerUpdate();
                break;
            case 3:
                slotDAO.addDummyDataSlot();
                displayBookedCustomerSlots();
                break;
            default:
                displayErrorMessage("Invalid function. Please try again.");
                displayLoggedInUserMenu();
        }
    }

    public void displayMenu(String username, String password) {
        displaySuccessMessage("You are inside Customer Menu !!!");
        customerDAO.addDummyDataCustomer();
        if (customerService.authenticateCustomer(username, password)) {
            displaySuccessMessage("Actual Customer Options!!!");
            customerId = customerService.getCustomerIdByLoginCreds(username, password);
            displayLoggedInUserMenu();
        } else {
            displayErrorMessage("Incorrect Credentials");
        }
    }

    public void displayRegistrationMenu() {
        displaySuccessMessage("You are inside Customer Registration Menu !!!");
        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");

        String generatedCustomerId = customerDAO.getCustomerId();

        Customer customer = new Customer(username, password, generatedCustomerId, name, email);
        customerService.registerCustomer(customer);
    }

    // Helper methods for displaying formatted messages
    private void displayErrorMessage(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }

    private void displaySuccessMessage(String message) {
        System.out.println("\u001B[32m" + message + "\u001B[0m");
    }

    private void displayTableMessage(String message) {
        System.out.println("\u001B[33m" + message + "\u001B[0m");
    }





    // Other customer menu methods
}
