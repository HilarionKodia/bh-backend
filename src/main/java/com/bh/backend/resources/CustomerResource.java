package com.bh.backend.resources;

import com.bh.backend.mappers.CustomerMapper;
import com.bh.backend.models.CustomerDTO;
import com.bh.backend.services.CustomerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@ApplicationScoped
public class CustomerResource {

    private static final Logger LOGGER = Logger.getLogger(CustomerResource.class.getName());

    @Inject
    CustomerService customerService;

    @Inject
    CustomerMapper customerMapper;

    @GET
    @Path("")
    public Response getAllCustomers() {
        try{
            List<CustomerDTO> customers= customerMapper.toCustomerDTOList(customerService.get());
            if (customers.isEmpty()) {
                return Response.noContent().build();
            } else {
                return Response.ok(customers).build();
            }
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return Response.serverError().build();
        }

    }
}
