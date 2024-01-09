package com.flipkart.controller;

import com.flipkart.bean.Center;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Slot;
import com.flipkart.business.CenterService;
import com.flipkart.business.SlotService;
import com.flipkart.dao.*;
import com.flipkart.dropWizardModels.*;
import com.flipkart.business.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
    private BookingDAO bookingDAO = new BookingDAO();
    private CustomerDAOInterface customerDAO=new CustomerDAO();
    private CenterDAO centerDAO=new CenterDAO();
    private SlotDAO slotDAO = new SlotDAO();
    private CustomerService customerService=new CustomerService(customerDAO,bookingDAO);
    private CenterService centerService=new CenterService(centerDAO);
    private SlotService slotService=new SlotService(slotDAO);

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

    @GET
    @Path("/slots")
    public ArrayList<Slot> viewSlotsForCenter(@QueryParam("centerId") Integer centerId){
        return slotService.getAllSlots(centerId);
    }

    @POST
    @Path("/bookSlot")
    public String bookGymSlot(BookSlot bookSlot){
        slotService.bookSlot(bookSlot.getSlotId(),bookSlot.getCustomerId());
        return "Slot Booked Successfully";
    }

    @PUT
    @Path("/update")
    public String updateCustomer(RegisterCustomer customer){
        customerService.updateCustomerInfo(customer.getName(),customer.getEmail(),customer.getUsername(),customer.getPassword(),customer.getCustomerId());
        return "Customer Updated";
    }

    @GET
    @Path("/bookedSlots")
    public ArrayList<Slot> viewSlotsForCustomer(@QueryParam("customerId") String customerId){
        return slotService.showBookedSlots(customerId);
    }

    @POST
    @Path("/cancelSlotBooking")
    public String cancelSlotBooking(CancelSlot cancelSlot){
        slotService.cancelBooking(cancelSlot.getSlotId());
        return "Slot Booking Cancelled";
    }
}
