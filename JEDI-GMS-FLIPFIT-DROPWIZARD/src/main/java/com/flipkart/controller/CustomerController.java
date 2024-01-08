package com.flipkart.controller;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.business.CenterService;
import com.flipkart.dao.CenterDAO;
import com.flipkart.dropWizardModels.AuthenticateCustomer;
import com.flipkart.dropWizardModels.RegisterCustomer;
import com.flipkart.business.CustomerService;
import com.flipkart.dao.BookingDAO;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.dao.CustomerDAOInterface;
import com.flipkart.dropWizardModels.ViewCenter;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
    private BookingDAO bookingDAO = new BookingDAO();
    private CustomerDAOInterface customerDAO=new CustomerDAO();
    private CenterDAO centerDAO=new CenterDAO();
    private CustomerService customerService=new CustomerService(customerDAO,bookingDAO);
    private CenterService centerService=new CenterService(centerDAO);

    @POST
    @Path("/register")
    public String registerCustomer(RegisterCustomer customer){
        customerService.registerCustomer(new Customer(customer.getUsername(),customer.getPassword(),null,customer.getName(),customer.getEmail()));
        return "Registered Successfully";
    }

    @POST
    @Path("/authenticate")
    public String authenticateCustomer(AuthenticateCustomer customer){
        if (customerService.authenticateCustomer(customer.getUsername(), customer.getPassword())) {
            return "Authenticated";
        }
        return "Invalid";
    }

    @GET
    @Path("/centers")
    public ArrayList<Center> viewAllCenters(){
        return centerService.getAllCenters();
    }
}
