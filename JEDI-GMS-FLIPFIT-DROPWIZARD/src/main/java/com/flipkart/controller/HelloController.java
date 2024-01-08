package com.flipkart.controller;


import com.flipkart.bean.Test;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController {

    @GET
    public String getEmployees() {
        return "my dropwizard service 2";
    }

    @POST
    public Test testPost(Test test){
        Test sampleTest=new Test();
        sampleTest.setTestId("Hello"+test.getTestId());
        return sampleTest;
    }

}

