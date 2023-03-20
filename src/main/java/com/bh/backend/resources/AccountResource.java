package com.bh.backend.resources;

import com.bh.backend.entities.Account;
import com.bh.backend.entities.Customer;
import com.bh.backend.entities.Transaction;
import com.bh.backend.mappers.AccountMapper;
import com.bh.backend.mappers.TransactionMapper;
import com.bh.backend.models.AccountDTO;
import com.bh.backend.models.UserInfoDTO;
import com.bh.backend.services.AccountService;
import com.bh.backend.services.TransactionService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.logging.Logger;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@ApplicationScoped
public class AccountResource {

    private static final Logger LOGGER = Logger.getLogger(AccountResource.class.getName());

    @Inject
    TransactionService transactionService;

    @Inject
    AccountService accountService;

    @Inject
    AccountMapper accountMapper;

    @Inject
    TransactionMapper transactionMapper;
    @POST
    public Response openNewAccount(UserInfoDTO userInfo) {
        try{
            // Sanity Check on the CustomerID
            if (userInfo.getCustomerID() == null) {
                return Response.
                        status(Response.Status.BAD_REQUEST)
                        .entity("Please fill in the CustomerID")
                        .build();
            }

            // Check if the customer exist
            Customer customer = Customer.findById(userInfo.getCustomerID());
            if (customer == null) {
                return Response.noContent()
                        .entity("The customer "+ userInfo.getCustomerID()
                                + " cannot be found!! Please verify the customerID")
                        .build();
            } else {
                // Open a new Account
                Account account = accountService.openNewAccount(userInfo);
                AccountDTO accountDTO = accountMapper.toAccountDTO(account);
                // Send a transaction
                Transaction transaction = transactionService.sendTransaction(userInfo.getInitialCredit(),
                        account.getAccountId());
                if (transaction != null) {
                    accountDTO.setTransactions(new HashSet<>());
                    accountDTO.getTransactions().add(transactionMapper.toTransactionDTO(transaction));
                }
                return Response.ok(accountDTO).build();
            }
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            return Response.serverError().build();
        }
    }
}
