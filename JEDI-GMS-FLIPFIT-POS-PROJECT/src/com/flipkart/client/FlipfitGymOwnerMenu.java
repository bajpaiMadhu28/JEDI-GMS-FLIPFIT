package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.*;
import com.flipkart.dao.*;
import com.flipkart.utils.InputUtils;

public class FlipfitGymOwnerMenu {
    private Scanner scanner;
    private CustomerService customerService;
    private PaymentService paymentService;
    private SlotService slotService;

    private SlotDAO slotDAO = new SlotDAO();
    private CenterDAO centerDAO = new CenterDAO();
    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private GymOwnerService gymOwnerService = new GymOwnerService(gymOwnerDAO, slotDAO);
    private CenterService centerService = new CenterService(centerDAO);

    private String gymOwnerId;
    private String centerId;

    InputUtils inputUtils = new InputUtils();

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

    private void displaySlotsForCenter() {
        int centerId = inputUtils.getIntInput("\u001B[33m\n== Enter Center ID to see slots ==\u001B[0m\n");
        slotDAO.addDummyDataSlot();
        slotService.getAllSlots(centerId);
    }

    private void displayLoggedInUserMenu(String username, String password) {
        int functionCode = inputUtils.getIntInput("\u001B[33m\n== Enter your functions (1 for Edit Your Profile, " +
                "2 for Editing Gym details, 3 for Editing slot details) ==\u001B[0m\n");
        switch (functionCode) {
            case 1:
                displayGymOwnerUpdateForm();
                break;
            case 2:
                displayGymDetailsEditForm(username, password);
                break;
            case 3:
                System.out.println("\u001B[31mEdit slot Details\u001B[0m");
                break;
            default:
                System.out.println("\u001B[31mInvalid function. Please try again.\u001B[0m");
                displayLoggedInUserMenu(username, password);
        }
    }

    public void displayMenu(String username, String password) {
        System.out.println("\u001B[36m\n== You are inside Gym Owner Menu !!! ==\u001B[0m\n");
        gymOwnerDAO.addDummyDataGymOwner();
        centerDAO.addDummyDataCenter();

        if (gymOwnerService.authenticateGymOwner(username, password)) {
            System.out.println("\u001B[32mActual Gym Owner Options!!!\u001B[0m");
            gymOwnerId = gymOwnerService.getGymOwnerIdByLoginCreds(username, password);
            displayLoggedInUserMenu(username, password);
        } else {
            System.out.println("\u001B[31m\nIncorrect Credentials\u001B[0m");
        }
    }

    public void displayRegistrationMenu() {
        System.out.println("\u001B[36m\n== You are inside Gym Owner Registration Menu !!! ==\u001B[0m\n");
        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");
        String gymName = inputUtils.getStringInput("Enter your GYM Name: ");

        String gymOwnerId = gymOwnerDAO.getGymOwnerId();

        GymOwner gymOwner = new GymOwner(name, username, password, gymOwnerId, gymName, email);
        gymOwnerService.registerGymOwner(gymOwner);
    }

    public void displayGymOwnerUpdateForm() {
        System.out.println("\u001B[36m\n== Please Enter Updated Gym Owner Details ==\u001B[0m\n");

        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");
        String gymName = inputUtils.getStringInput("Enter your GYM Name: ");

        gymOwnerService.updateGymOwnerProfile(new GymOwner(name, username, password, gymOwnerId, gymName, email));
    }

    public void displayGymDetailsEditForm(String username, String password) {
        GymOwner gymOwner = gymOwnerService.getGymOwnerByLoginCreds(username, password);
        Center center = centerService.getCenterByOwnerId(gymOwner.getOwnerId());

        System.out.println("\u001B[36m\n== Current Gym Details ==\u001B[0m\n");
        System.out.println("Gym Name : " + center.getName());
        System.out.println("Gym Location : " + center.getLocation());
        System.out.println("Gym Id : " + center.getCenterId());
        System.out.println("Owner Id : " + center.getOwnerId());

        System.out.println("\u001B[36m\n== Please Enter Updated Gym Details ==\u001B[0m\n");

        String name = inputUtils.getStringInput("Enter Gym's name: ");
        String location = inputUtils.getStringInput("Enter your Gym's location: ");

        centerService.updateCenterProfile(new Center(center.getCenterId(), name, location, gymOwner.getOwnerId()));
    }

}
