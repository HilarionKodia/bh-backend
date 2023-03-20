package com.bh.backend.resources;

import com.bh.backend.entities.Account;
import com.bh.backend.entities.Customer;
import com.bh.backend.mappers.CustomerMapper;
import com.bh.backend.models.CustomerDTO;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

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
    CustomerMapper customerMapper;

    @GET
    @Path("")
    public Response getAllCustomers() {
        try{
            List<CustomerDTO> customers= customerMapper.toCustomerDTOList(Customer.listAll());
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

    @GET
    @Path("/{customerID}")
    public Response getCustomerByCustomerId(@PathParam Integer customerID) {
        try{
            Customer customer = Customer.findById(customerID);
            if (customer == null) {
                return Response.noContent().build();
            } else {
                return Response.ok(customerMapper.toCustomerDTO(customer)).build();
            }
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return Response.serverError().build();
        }
    }
}
