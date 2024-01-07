package com.flipkart.utils;
import java.util.Scanner;

public class InputUtils {
    Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Consume the invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    // Utility method to get string input from the user
    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public void readEnter(){
        scanner.next();
    }
}
