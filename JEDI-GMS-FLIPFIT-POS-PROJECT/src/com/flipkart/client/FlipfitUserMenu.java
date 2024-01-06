package com.flipkart.client;

import java.util.Scanner;

public class FlipfitUserMenu {
    private Scanner scanner;
    private FlipfitAdminMenu adminMenu;
    private FlipfitCustomerMenu customerMenu;
    private FlipfitGymOwnerMenu gymOwnerMenu;

    // Constructor
    public FlipfitUserMenu(Scanner scanner, FlipfitAdminMenu adminMenu, FlipfitCustomerMenu customerMenu, FlipfitGymOwnerMenu gymOwnerMenu) {
        this.scanner = scanner;
        this.adminMenu = adminMenu;
        this.customerMenu = customerMenu;
        this.gymOwnerMenu = gymOwnerMenu;
    }

    public FlipfitUserMenu() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming you have instances of FlipfitAdminMenu, FlipfitCustomerMenu, and FlipfitGymOwnerMenu
        FlipfitAdminMenu adminMenu = new FlipfitAdminMenu();
        FlipfitCustomerMenu customerMenu = new FlipfitCustomerMenu();
        FlipfitGymOwnerMenu gymOwnerMenu = new FlipfitGymOwnerMenu();

        FlipfitUserMenu userMenu = new FlipfitUserMenu(scanner, adminMenu, customerMenu, gymOwnerMenu);
        userMenu.displayMenu();
    }

    // Display the main user menu
    public void displayMenu() {
        String boldBlue = "\033[1;34m"; // Bold: \033[1m, Blue: \033[34m
        String reset = "\033[0m"; // Reset to default

        // Text to be centered
        String text = "! WELCOME TO FLIPFIT !";
        int screenWidth = 80; // Adjust this value based on your console width

        // Calculate padding for centering text
        int padding = (screenWidth - text.length()) / 2;
        String paddingString = new String(new char[padding]).replace("\0", " ");

        // Output centered text in bold and blue color
        System.out.println(paddingString + boldBlue + text + reset);
        // Output in bold and blue color
        System.out.println("\n1. Login");
        System.out.println("2. Registration");
        System.out.println("3. Update Password");
        System.out.println("4. Exit\n");

        int choice = getIntInput("\nEnter your choice: \n");

        switch (choice) {
            case 1:
                loginMenu();
                break;
            case 2:
                registrationMenu();
                break;
            case 3:
                updatePasswordMenu();
                break;
            case 4:
                System.out.println("\nExiting Flipfit. Goodbye!\n");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu();
        }
    }


    // Login menu
    void loginMenu() {
        // Get username, password, and role from the user
        String username = getStringInput("Enter your username: ");
        String password = getStringInput("Enter your password: ");
        int role = getIntInput("Enter your role : \n1 for Customer, \n2 for GymOwner, \n3 for Admin\n ");

        // Based on the role, display the corresponding menu
        switch (role) {
            case 1:
                customerMenu.displayMenu(username, password);
                break;
            case 2:
                gymOwnerMenu.displayMenu(username, password);
                break;
            case 3:
                adminMenu.displayMenu(username, password);
                break;
            default:
                System.out.println("Invalid role. Please try again.");
                loginMenu();
        }
    }

    // Registration menu
    private void registrationMenu() {
        // Implementation for user registration
        // You can add logic to register a new user
        int role = getIntInput("Enter your role : \n1 for Customer, \n2 for GymOwner, \n3 for Admin\n ");

        // Based on the role, display the corresponding menu
        switch (role) {
            case 1:
                customerMenu.displayRegistrationMenu();
                break;
            case 2:
                gymOwnerMenu.displayRegistrationMenu();
                break;
            case 3:
                adminMenu.displayAdminRegistrationMenu();
                break;
            default:
                System.out.println("Invalid role. Please try again.");
                registrationMenu();
        }
    }

    // Update password menu
    private void updatePasswordMenu() {
        // Implementation for updating user password
        // You can add logic to update the user password
        System.out.println("Update Password menu placeholder.");
    }

    // Utility method to get integer input from the user
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Consume the invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    // Utility method to get string input from the user
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
