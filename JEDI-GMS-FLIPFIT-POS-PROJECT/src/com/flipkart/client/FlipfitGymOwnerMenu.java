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
    private GymOwnerService gymOwnerService = new GymOwnerService();
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

//    private void displaySlotsForCenter() {
//        int centerId = inputUtils.getIntInput("\nEnter Center ID to see slots: ");
//        slotDAO.addDummyDataSlot();
//        slotService.getAllSlots(centerId);
//    }
//
    private void displayLoggedInUserMenu(String username, String password) {
        int functionCode = inputUtils.getIntInput("\nEnter your functions \n0 to EXIT \n1 to display all Gyms . \n2 for Edit Your Profile." +
                " \n3 for Registering New Gym. \n4 for Editing Gym details. \n5 for Editing slot details. \n\nEnter Input : ");
        switch (functionCode) {
            case 0:
                break;
            case 1:
                displayAllGyms(username, password);
                displayLoggedInUserMenu(username, password);
                break;
            case 2:
                displayGymOwnerUpdateForm();
                displayLoggedInUserMenu(username, password);
                break;
            case 3:
                registerNewCenter(username, password);
                displayLoggedInUserMenu(username, password);
                break;
//            case 4:
//                displayGymDetailsEditForm(username, password);
//                displayLoggedInUserMenu(username, password);
//                break;
//            case 5:
//                displaySlotDetailsMenu(username, password);
//                displayLoggedInUserMenu(username, password);
//                break;
            default:
                System.out.println("Invalid function. Please try again.");
                displayLoggedInUserMenu(username, password);
        }
    }

    public void displayAllGyms(String username, String password) {
        System.out.println("All Registered Gym under you : ");
        gymOwnerService.displayAllGyms(username, password);
    }
//
//    public void displaySlotDetailsMenu(String username, String password) {
//        int functionCode = inputUtils.getIntInput("\nEnter your functions : \n1 to add slot." +
//                "\n2 to delete slot. \n\nEnter Input : ");
//
//        switch (functionCode) {
//            case 1:
//                addNewSlot(username, password);
//                break;
//            case 2:
//                removeExistingSlot(username, password);
//                break;
//            default:
//                System.out.println("Invalid function. Please try again.");
//                displaySlotDetailsMenu(username, password);
//        }
//    }
//
//    public void addNewSlot(String username, String password) {
//        Integer slotId = slotService.getSlotId();
//        String date = inputUtils.getDateInput("Enter the date (DD/MM/YYYY) : ", "dd/MM/yyyy");
//        String time = inputUtils.getStringInput("Enter slot timings (eg HH:MM AM - HH:MM PM) : ");
//        String ownerId = gymOwnerService.getGymOwnerIdByLoginCreds(username, password);
//
//        Slot slot = new Slot(slotId, date, time, centerService.getCenterByOwnerId(ownerId).getCenterId());
//
//        gymOwnerService.addGymSlot(slot);
//        System.out.println("Slot date    -    Slot time   -    Slot Id ");
//
//        for (Slot updatedSlots : slotService.getAllDummySlots()) {
//            String centerId = updatedSlots.getCenterId().toString();
//
//            if ((updatedSlots.getDate().equals(date)) && centerService.getOwnerIdByCenterId(centerId).equals(ownerId)) {
//                System.out.println(updatedSlots.getDate() + "      -     " + updatedSlots.getTime() + "    -    " + updatedSlots.getSlotId());
//            }
//        }
//    }
//
//    public void removeExistingSlot(String username, String password) {
//        String ownerId = gymOwnerService.getGymOwnerIdByLoginCreds(username, password);
//
//        System.out.println("Size is : " + slotService.getAllDummySlots().size());
//        System.out.println("\n\nSlot date    -    Slot time   -    Slot Id ");
//
//        for (Slot updatedSlots : slotService.getAllDummySlots()) {
//            String centerId = updatedSlots.getCenterId().toString();
//
//            if (centerService.getOwnerIdByCenterId(centerId).equals(ownerId)) {
//                System.out.println(updatedSlots.getDate() + "      -     " + updatedSlots.getTime() + "    -    " + updatedSlots.getSlotId());
//            }
//        }
//
//        String slotId = inputUtils.getStringInput("\n\nEnter the Slot Id to remove the Slot : ");
//
//        gymOwnerService.removeGymSlot(slotId);
//
//        System.out.println("\n\nSlot date    -    Slot time ");
//        for (Slot updatedSlots : slotService.getAllDummySlots()) {
//            String centerId = updatedSlots.getCenterId().toString();
//
//            if (centerService.getOwnerIdByCenterId(centerId).equals(ownerId)) {
//                System.out.println(updatedSlots.getDate() + "      -     " + updatedSlots.getTime());
//            }
//        }
//        System.out.println("Slot deleted Successfully !!!");
//    }
//
    public void registerNewCenter(String username, String password) {
        String name = inputUtils.getStringInput("Enter Gym's name: ");
        String location = inputUtils.getStringInput("Enter Gym's location: ");

        Center center = new Center(null, name, location, gymOwnerId);

        gymOwnerService.onboardGym(center);

        System.out.println("\nYour New Gym has been added !!!");
        System.out.println("\nThese are all your listed Gyms !!!");
        displayAllGyms(username, password);
    }
//
    public void displayMenu(String username, String password) {
        System.out.println("\nYou are inside Gym Owner Menu !!!");
//        centerDAO.addDummyDataCenter();

        if (gymOwnerService.authenticateGymOwner(username, password)) {
            System.out.println("Actual Gym Owner Options!!!");
            gymOwnerId = gymOwnerService.getGymOwnerIdByLoginCreds(username, password);
            displayLoggedInUserMenu(username, password);
        } else {
            System.out.println("\nIncorrect Credentials");
        }
    }

    public void displayRegistrationMenu() {
        System.out.println("\nYou are inside Gym Owner Registration Menu !!!");
        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");

        GymOwner gymOwner = new GymOwner(name, username, password, null, email);
        gymOwnerService.registerGymOwner(gymOwner);
    }

    public void displayGymOwnerUpdateForm() {
        System.out.println("\nPlease Enter Updated Gym Owner Details :");

        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");

        gymOwnerService.updateGymOwnerProfile(new GymOwner(name, username, password, gymOwnerId, email));
    }
//
//    public void displayGymDetailsEditForm(String username, String password) {
//        GymOwner gymOwner = gymOwnerService.getGymOwnerByLoginCreds(username, password);
//        Center center = centerService.getCenterByOwnerId(gymOwner.getOwnerId());
//
//        System.out.println("\nCurrent Gym Details : ");
//        System.out.println("Gym Name : " + center.getName());
//        System.out.println("Gym Location : " + center.getLocation());
//        System.out.println("Gym Id : " + center.getCenterId());
//        System.out.println("Owner Id : " + center.getOwnerId());
//
//        System.out.println("\nPlease Enter Updated Gym Details :");
//
//        String name = inputUtils.getStringInput("Enter Gym's name: ");
//        String location = inputUtils.getStringInput("Enter your Gym's location: ");
//
//        centerService.updateCenterProfile(new Center(center.getCenterId(), name, location, gymOwner.getOwnerId()));
//    }

    // Other gym owner menu methods
}
