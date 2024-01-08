package com.flipkart.client;

import java.util.Date;
import java.util.Scanner;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.business.*;
import com.flipkart.dao.*;
import com.flipkart.exception.InvalidChoiceException;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.utils.InputUtils;

/**
 * Class representing the menu for Gym Owners in the Flipfit application.
 */
public class FlipfitGymOwnerMenu {
    private Scanner scanner;
    private CustomerService customerService;
    private PaymentService paymentService;


    private SlotDAO slotDAO = new SlotDAO();
    private SlotService slotService=new SlotService(slotDAO);
    private CenterDAO centerDAO = new CenterDAO();
    private GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private GymOwnerService gymOwnerService = new GymOwnerService();
    private CenterService centerService = new CenterService(centerDAO);

    private String gymOwnerId;
    private String centerId;

    InputUtils inputUtils = new InputUtils();

    /**
     * Display the main menu for a logged-in Gym Owner.
     *
     * @param username The Gym Owner's username.
     * @param password The Gym Owner's password.
     */
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
            case 4:
                displayAllGyms(username, password);
                displayGymDetailsEditForm(username, password);
                displayLoggedInUserMenu(username, password);
                break;
            case 5:
                displaySlotDetailsMenu(username, password);
                displayLoggedInUserMenu(username, password);
                break;
            default:
                System.out.println("Invalid function. Please try again.");
                displayLoggedInUserMenu(username, password);
        }
    }

    /**
     * Display all registered gyms under the Gym Owner.
     *
     * @param username The Gym Owner's username.
     * @param password The Gym Owner's password.
     */
    public void displayAllGyms(String username, String password) {
        System.out.println("All Registered Gym under you : ");
        gymOwnerService.displayAllGyms(username, password);
    }

    /**
     * Display the slot details menu for adding or deleting slots.
     *
     * @param username The Gym Owner's username.
     * @param password The Gym Owner's password.
     */
    public void displaySlotDetailsMenu(String username, String password) {
        displayAllGyms(username, password);

        int functionCode = inputUtils.getIntInput("\nEnter your functions : \n1 to add slot." +
                "\n2 to delete slot. \n\nEnter Input : ");

        switch (functionCode) {
            case 1:
                addNewSlot(username, password);
                break;
            case 2:
                removeExistingSlot(username, password);
                break;
            default:
                System.out.println("Invalid function. Please try again.");
                displaySlotDetailsMenu(username, password);
        }
    }

    /**
     * Add a new slot for a Gym.
     *
     * @param username The Gym Owner's username.
     * @param password The Gym Owner's password.
     */
    public void addNewSlot(String username, String password) {
        Integer centerId = inputUtils.getIntInput("Enter Gym ID");
        String date = inputUtils.getDateInput("Enter the date (DD/MM/YYYY) : ", "dd/MM/yyyy");
        String time = inputUtils.getStringInput("Enter slot timings (eg HH:MM AM - HH:MM PM) : ");

        java.util.Date utilDate = new java.util.Date();
        Slot slot = new Slot(null, new java.sql.Date(utilDate.getTime()), time, centerId);

        gymOwnerService.addGymSlot(slot);
    }
//
    public void removeExistingSlot(String username, String password) {
        Integer centerId = inputUtils.getIntInput("Enter Gym ID");
        slotService.getAllSlots(centerId);
        Integer slotId = inputUtils.getIntInput("\n\nEnter the Slot Id to remove the Slot : ");
        gymOwnerService.removeGymSlot(slotId);
        System.out.println("Slot deleted Successfully !!!");
    }

    /**
     * Register a new Gym.
     *
     * @param username The Gym Owner's username.
     * @param password The Gym Owner's password.
     */
    public void registerNewCenter(String username, String password) {
        String name = inputUtils.getStringInput("Enter Gym's name: ");
        String location = inputUtils.getStringInput("Enter Gym's location: ");

        Center center = new Center(null, name, location, gymOwnerId);

        gymOwnerService.onboardGym(center);

        System.out.println("\nYour New Gym has been added !!!");
        System.out.println("\nThese are all your listed Gyms !!!");
        displayAllGyms(username, password);
    }

    /**
     * Display the main menu for the Gym Owner.
     *
     * @param username The Gym Owner's username.
     * @param password The Gym Owner's password.
     */
    public void displayMenu(String username, String password) {
        System.out.println("\nYou are inside Gym Owner Menu !!!");

        if (gymOwnerService.authenticateGymOwner(username, password)) {
            System.out.println("Actual Gym Owner Options!!!");
            gymOwnerId = gymOwnerService.getGymOwnerIdByLoginCreds(username, password);
            displayLoggedInUserMenu(username, password);
        } else {
            System.out.println("\nIncorrect Credentials");
        }
    }

    /**
     * Display the registration menu for Gym Owners.
     */
    public void displayRegistrationMenu() throws RegistrationFailedException {
        System.out.println("\nYou are inside Gym Owner Registration Menu !!!");
        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");

        GymOwner gymOwner = new GymOwner(name, username, password, null, email);
        gymOwnerService.registerGymOwner(gymOwner);
    }

    /**
     * Display the form for updating Gym Owner details.
     */
    public void displayGymOwnerUpdateForm() {
        System.out.println("\nPlease Enter Updated Gym Owner Details :");

        String name = inputUtils.getStringInput("Enter your name: ");
        String email = inputUtils.getStringInput("Enter your email: ");
        String username = inputUtils.getStringInput("Enter your username: ");
        String password = inputUtils.getStringInput("Enter your password: ");

        gymOwnerService.updateGymOwnerProfile(new GymOwner(name, username, password, gymOwnerId, email));
    }

    /**
     * Display the form for updating Gym details.
     *
     * @param username The Gym Owner's username.
     * @param password The Gym Owner's password.
     */
    public void displayGymDetailsEditForm(String username, String password) {
        System.out.println("\nPlease Enter Updated Gym Details along with Gym ID from above :");

        Integer centerId = inputUtils.getIntInput("Enter Gym ID");
        String name = inputUtils.getStringInput("Enter Gym's name: ");
        String location = inputUtils.getStringInput("Enter your Gym's location: ");

        centerService.updateCenterProfile(new Center(centerId, name, location, gymOwnerId));
    }

    // Other gym owner menu methods
}
