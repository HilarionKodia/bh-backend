package com.bh.backend.services;

import com.bh.backend.entities.Transaction;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionService {

    public Transaction sendTransaction (Double initialCredit, Integer accountId) {
        if (initialCredit != null
                && initialCredit != 0
                && accountId != null) {
            Transaction transaction = new Transaction();
            transaction.setAccountId(accountId);
            transaction.setAmount(initialCredit);
            Transaction.persist(transaction);
            Transaction.persist(transaction);
            return transaction;
        }
        return null;
    }
}
