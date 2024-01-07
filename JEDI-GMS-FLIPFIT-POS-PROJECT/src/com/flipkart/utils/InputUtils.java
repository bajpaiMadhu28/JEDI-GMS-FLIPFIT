package com.flipkart.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    // Utility method to get date input from the user
    public String getDateInput(String prompt, String dateFormat) {
        System.out.print(prompt);
        while (true) {
            String input = scanner.next();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                sdf.setLenient(false); // Enforce strict date parsing
                Date parsedDate = sdf.parse(input);

                // Now format the parsed date to the desired output format
                SimpleDateFormat outputSdf = new SimpleDateFormat(dateFormat);
                return outputSdf.format(parsedDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in the format: " + dateFormat);
                System.out.print(prompt);
            }
        }
    }



    public void readEnter(){
        scanner.next();
    }
}
