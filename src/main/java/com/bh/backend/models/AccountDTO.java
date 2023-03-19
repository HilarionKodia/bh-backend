package com.bh.backend.models;

import java.util.Set;

public class AccountDTO {

    private int accountID;
    private int customerID;
    private double balance;
    private Set<TransactionDTO> transactions;
}
