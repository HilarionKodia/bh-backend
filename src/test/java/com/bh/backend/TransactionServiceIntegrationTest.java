package com.bh.backend;

import com.bh.backend.entities.Account;
import com.bh.backend.entities.Transaction;
import com.bh.backend.models.UserInfoDTO;
import com.bh.backend.services.AccountService;
import com.bh.backend.services.TransactionService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class TransactionServiceIntegrationTest {

    @Inject
    TransactionService transactionService;

    @Inject
    AccountService accountService;

    @Test
    void testSendTransaction() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setCustomerID(1);
        userInfoDTO.setInitialCredit(0.0);
        accountService.openNewAccount(userInfoDTO);
        Transaction transaction = transactionService.sendTransaction(6.0, 1);
        Assertions.assertNotNull(transaction);
        Assertions.assertNotNull(transaction.getTransactionId());
        Assertions.assertEquals(transaction.getAccountId(), 1);
        Assertions.assertEquals(transaction.getAmount(), 6);
    }
}
