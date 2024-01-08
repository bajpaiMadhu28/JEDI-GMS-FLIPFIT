package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.business.CenterService;
import com.flipkart.business.CustomerService;
import com.flipkart.business.PaymentService;
import com.flipkart.business.SlotService;
import com.flipkart.constant.CommonConstant;
import com.flipkart.dao.*;
import com.flipkart.utils.InputUtils;

/**
 * Class representing the customer menu for the Flipfit application.
 */
public class FlipfitCustomerMenu {
    private BookingDAO bookingDAO = new BookingDAO();
    private CustomerDAOInterface customerDAO = new CustomerDAO();
    private CustomerService customerService = new CustomerService(customerDAO, bookingDAO);
    private CenterService centerService = new CenterService();
    private PaymentService paymentService;
    private SlotDAO slotDAO = new SlotDAO();
    private SlotService slotService = new SlotService(slotDAO);

    private String customerId;
    InputUtils inputUtils = new InputUtils();

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

    /**
     * Display available slots for a selected center and allow booking.
     */
    private void displaySlotsForCenter() {
        int centerId = inputUtils.getIntInput("Enter Center ID to see slots: ");
        slotDAO.addDummyDataSlot();
        if (slotService.getAllSlots(centerId)) {
            int slotId = inputUtils.getIntInput("Enter Slot ID to book slot: ");
            slotService.bookSlot(slotId, customerId);
        }
//       else{
//           return;
//        }
    }

    /**
     * Display options to update customer information.
     */
    private void displayCustomerUpdate() {
        System.out.println("\u001B[33m\n== Update Customer Information ===\u001B[0m");

        System.out.printf("\u001B[33m| \u001B[36m%-20s\u001B[33m | \u001B[36m%-20s\u001B[33m |\u001B[0m%n", "Field", "New Value");
        System.out.println("\u001B[33m|----------------------|----------------------|\u001B[0m");

        String name = inputUtils.getStringInput(CommonConstant.INPUT_NAME);
        String email = inputUtils.getStringInput(CommonConstant.INPUT_EMAIL);
        String username = inputUtils.getStringInput(CommonConstant.INPUT_USERNAME);
        String password = inputUtils.getStringInput(CommonConstant.INPUT_PASSWORD);
        customerService.updateCustomerInfo(name, email, username, password, customerId);
    }

    /**
     * Display options to cancel a booked slot.
     */
    private void displayCancelBooking() {
        System.out.println("\n");
        System.out.println("\u001B[31m\n==== Cancel Booking ====\u001B[0m");
        int slotId = inputUtils.getIntInput("\nEnter Slot ID to cancel: ");
        slotService.cancelBooking(slotId);
    }

    /**
     * Display booked slots for the customer and allow cancelation.
     */
    private void displayBookedCustomerSlots() {
        System.out.println("\u001B[33m\n==== Booked Customer Slots ====\u001B[0m");
        System.out.println("\n");

        slotService.showBookedSlots(customerId);
        int functionCode = inputUtils.getIntInput("\u001B[36mMake a choice:\n1 - Cancel Booking\n2 - Exit \u001B[0m");
        switch (functionCode) {
            case 1:
                displayCancelBooking();
                break;
            case 2:
                break;
            default:
                System.out.println("\u001B[31mInvalid function. Please try again.\u001B[0m");
                displayBookedCustomerSlots();
        }
    }

    /**
     * Display the main menu for a logged-in user.
     */
    private void displayLoggedInUserMenu() {
        System.out.println("\u001B[33m\n==== Logged In User Menu ====\u001B[0m");
        int functionCode = inputUtils.getIntInput("\u001B[36m\nMake a choice :\n1 - Display Centers \n2 - Edit Profile \n3 - View Booked Slots\n \u001B[0m");
        switch (functionCode) {
            case 1:
                centerService.getAllCenters();
                displaySlotsForCenter();
                break;
            case 2:
                displayCustomerUpdate();
                break;
            case 3:
                displayBookedCustomerSlots();
                break;
            default:
                System.out.println("\u001B[31mInvalid function. Please try again.\u001B[0m");
                displayLoggedInUserMenu();
        }
    }

    /**
     * Display the main customer menu based on provided username and password.
     *
     * @param username The customer username.
     * @param password The customer password.
     */

    public void displayMenu(String username, String password) {
        System.out.println("\u001B[36mYou are inside Customer Menu !!!\u001B[0m");
        if (customerService.authenticateCustomer(username, password)) {
            System.out.println("\u001B[32mActual Customer Options!!!\u001B[0m");
            customerId = customerService.getCustomerIdByLoginCreds(username, password);
            displayLoggedInUserMenu();
        } else {
            System.out.println(CommonConstant.INCORRECT_CREDENTIALS);
        }

        // Implementation to display the customer menu
    }

    /**
     * Display the customer registration menu.
     */
    public void displayRegistrationMenu() {
        System.out.println("\u001B[36mYou are inside Customer Registration Menu !!!\u001B[0m");
        String name = inputUtils.getStringInput(CommonConstant.INPUT_NAME);
        String email = inputUtils.getStringInput(CommonConstant.INPUT_EMAIL);
        String username = inputUtils.getStringInput(CommonConstant.INPUT_USERNAME);
        String password = inputUtils.getStringInput(CommonConstant.INPUT_PASSWORD);


        Customer customer = new Customer(username, password, null, name, email);
        customerService.registerCustomer(customer);
//        displayMenu(username,password);
    }


    // Other customer menu methods
}
