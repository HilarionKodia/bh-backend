package com.bh.backend.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello2")
public class UserResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2() {
        return "Hello from RESTEasy Reactive";
    }
}