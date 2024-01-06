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

    private void displaySlotsForCenter(){
        int centerId = inputUtils.getIntInput("Enter Center ID to see slots: ");
        slotDAO.addDummyDataSlot();
        slotService.getAllSlots(centerId);
        int slotId = inputUtils.getIntInput("Enter Slot ID to book slot: ");
        slotService.bookSlot(slotId,customerId);
    }

    private void displayCustomerUpdate() {
        System.out.println("\u001B[33m\n== Update Customer Information ===\u001B[0m");

        System.out.printf("\u001B[33m| \u001B[36m%-20s\u001B[33m | \u001B[36m%-20s\u001B[33m |\u001B[0m%n", "Field", "New Value");
        System.out.println("\u001B[33m|----------------------|----------------------|\u001B[0m");

        String name = inputUtils.getStringInput("Enter your new name: ");
        String email = inputUtils.getStringInput("Enter your new email: ");
        String username = inputUtils.getStringInput("Enter your new username: ");
        String password = inputUtils.getStringInput("Enter your new password: ");
        customerService.updateCustomerInfo(name,email,username,password,customerId);
    }


    private void displayCancelBooking() {
        System.out.println("\u001B[31m\n==== Cancel Booking ====\u001B[0m");
        int slotId = inputUtils.getIntInput("Enter Slot ID to cancel: ");
        slotService.cancelBooking(slotId);
    }

    private void displayBookedCustomerSlots() {
        System.out.println("\u001B[33m\n==== Booked Customer Slots ====\u001B[0m");
        slotService.showBookedSlots(customerId);
        int functionCode = inputUtils.getIntInput("\u001B[36mEnter your functions (1 for Cancel Booking, 2 for Exit): \u001B[0m");
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

    private void displayLoggedInUserMenu() {
        System.out.println("\u001B[33m\n==== Logged In User Menu ====\u001B[0m");
        int functionCode = inputUtils.getIntInput("\u001B[36mEnter your functions :\n 1 to  Display Centers, \n2 to Edit Profile, \n3 to View Booked Slots \u001B[0m");
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
                System.out.println("\u001B[31mInvalid function. Please try again.\u001B[0m");
                displayLoggedInUserMenu();
        }
    }
    public void displayMenu(String username, String password) {
        System.out.println("\u001B[36mYou are inside Customer Menu !!!\u001B[0m");
        customerDAO.addDummyDataCustomer();
        if (customerService.authenticateCustomer(username, password)) {
            System.out.println("\u001B[32mActual Customer Options!!!\u001B[0m");
            customerId = customerService.getCustomerIdByLoginCreds(username, password);
            displayLoggedInUserMenu();
        } else {
            System.out.println("\u001B[31mIncorrect Credentials\u001B[0m");
        }

        // Implementation to display the customer menu
    }
    public void displayRegistrationMenu() {
        System.out.println("\u001B[36mYou are inside Customer Registration Menu !!!\u001B[0m");
        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");

        String generatedCustomerId=customerDAO.getCustomerId();

        Customer customer = new Customer(username,password,generatedCustomerId,name,email);
        customerService.registerCustomer(customer);
//        displayMenu(username,password);
    }




    // Other customer menu methods
}
