package com.bh.backend.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello1")
public class AccountResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello1() {
        return "Hello from RESTEasy Reactive";
    }
}