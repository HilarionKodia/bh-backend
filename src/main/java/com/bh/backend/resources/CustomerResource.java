package com.bh.backend.resources;

import com.bh.backend.services.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello2")
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2() {

        customerService.get();
        return "Hello from RESTEasy Reactive";
    }
}
