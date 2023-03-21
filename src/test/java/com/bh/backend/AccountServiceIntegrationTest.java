package com.bh.backend;

import com.bh.backend.entities.Account;
import com.bh.backend.entities.Transaction;
import com.bh.backend.models.UserInfoDTO;
import com.bh.backend.services.AccountService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class AccountServiceIntegrationTest {

    @Inject
    AccountService accountService;

    @Test
    void testOpenNewAccount() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setCustomerID(1);
        userInfoDTO.setInitialCredit(5.0);
        Account account = accountService.openNewAccount(userInfoDTO);
        Assertions.assertNotNull(account);
        Assertions.assertNotNull(account.getAccountId());
        Assertions.assertEquals(account.getBalance(), 5);
    }
}
