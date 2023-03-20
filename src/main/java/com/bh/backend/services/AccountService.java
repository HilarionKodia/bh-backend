package com.bh.backend.services;

import com.bh.backend.entities.Account;
import com.bh.backend.models.UserInfoDTO;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountService  {

    public Account openNewAccount (UserInfoDTO userInfo) {
        if (userInfo.getCustomerID() != null) {
            Account account = new Account();
            account.setCustomerId(userInfo.getCustomerID());
            if (userInfo.getInitialCredit() != null) {
                account.setBalance(userInfo.getInitialCredit());
            } else {
                account.setBalance(0.0);
            }
            Account.persist(account);
            return account;
        }
        return null;
    }
}
