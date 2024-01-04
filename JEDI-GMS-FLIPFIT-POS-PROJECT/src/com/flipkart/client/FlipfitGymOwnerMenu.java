package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.*;
import com.flipkart.dao.*;
import com.flipkart.utils.InputUtils;

public class FlipfitGymOwnerMenu {
    private Scanner scanner;
    private CenterService centerService;
    private CustomerService customerService;
    private PaymentService paymentService;
    private SlotService slotService;

    private SlotDAO slotDAO = new SlotDAO();
    private GymOwnerDAO  gymOwnerDAO = new GymOwnerDAO();
    private GymOwnerService gymOwnerService = new GymOwnerService(gymOwnerDAO, slotDAO);

    private String gymOwnerId;
    InputUtils inputUtils=new InputUtils();

    // Constructor
//    public FlipfitGymOwnerMenu(
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

    private void displaySlotsForCenter(){
        int centerId = inputUtils.getIntInput("\nEnter Center ID to see slots: ");
        slotDAO.addDummyDataSlot();
        slotService.getAllSlots(centerId);
    }

    private void displayLoggedInUserMenu(){
        int functionCode = inputUtils.getIntInput("\nEnter your functions (1 for Edit Your Profile," +
                " 2 for Editing Gym details, 3 for Editing slot details): ");
        switch (functionCode) {
            case 1:
                displayGymOwnerUpdateForm();
                break;
            case 2:
                System.out.println("Edit GYM Details");
                break;
            case 3:
                System.out.println("Edit slot Details");
                break;
            default:
                System.out.println("Invalid function. Please try again.");
                displayLoggedInUserMenu();
        }
    }
    public void displayMenu(String username, String password) {
        System.out.println("\nYou are inside Gym Owner Menu !!!");
        gymOwnerDAO.addDummyDataGymOwner();
        if(gymOwnerService.authenticateGymOwner(username,password)){
            System.out.println("Actual Gym Owner Options!!!");
            gymOwnerId = gymOwnerService.getGymOwnerIdByLoginCreds(username, password);
            displayLoggedInUserMenu();
        }
        else{
            System.out.println("\nIncorrect Credentials");
        }
        // Implementation to display the customer menu
    }
    public void displayRegistrationMenu() {
        System.out.println("\nYou are inside Gym Owner Registration Menu !!!");
        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");
        String gymName = inputUtils.getStringInput("Enter your GYM Name: ");

        String gymOwnerId = gymOwnerDAO.getGymOwnerId();

        GymOwner gymOwner = new GymOwner(name, username, password, gymOwnerId, gymName, email);
        gymOwnerService.registerGymOwner(gymOwner);
        // Implementation to display the customer menu
    }

    public void displayGymOwnerUpdateForm() {
        System.out.println("\nPlease Enter Updated Gym Owner Details :");

        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");
        String gymName = inputUtils.getStringInput("Enter your GYM Name: ");

        gymOwnerService.updateGymOwnerProfile(new GymOwner(name, username, password, gymOwnerId, gymName, email));
    }

    // Other gym owner menu methods
}
