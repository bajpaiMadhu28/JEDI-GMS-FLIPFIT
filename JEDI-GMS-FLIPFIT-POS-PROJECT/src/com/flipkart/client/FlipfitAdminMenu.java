package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Center;
import com.flipkart.business.CenterService;
import com.flipkart.business.CustomerService;
import com.flipkart.business.PaymentService;
import com.flipkart.business.SlotService;
import com.flipkart.business.AdminService;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.CenterDAO;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.dao.PaymentDAO;
import com.flipkart.dao.SlotDAO;

public class FlipfitAdminMenu {
    private Scanner scanner=new Scanner(System.in);
    private CenterService centerService;
    private CustomerService customerService;
    private PaymentService paymentService;
    private SlotService slotService;

    // Constructor
//    public FlipfitAdminMenu(
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

    // Methods for admin menu options
    public void displayMenu(String username, String password) {
        // Implementation to display the admin menu
     System.out.println("1.View All gyms");
     System.out.println("Enter choice:");
     int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                viewAllGyms();
                break;
        }

    }
   public void viewAllGyms() {
       List<Center> gyms = AdminService.viewAllGyms();
       for (Center gym : gyms) {
           System.out.println("NAME: "+gym.getName());
           System.out.println("ID: "+gym.getCenterId());
           System.out.println("LOCATION: "+gym.getLocation());
       }
   }
    // Other admin menu methods
}
