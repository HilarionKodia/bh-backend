package com.bh.backend.models;

import java.util.Set;

public class AccountDTO {

    private int accountId;
    private int customerId;
    private double balance;
    private Set<TransactionDTO> transactions;
}
