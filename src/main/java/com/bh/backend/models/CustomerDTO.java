package com.bh.backend.models;

import java.util.Set;

public class CustomerDTO {

    private int customerId;
    private String name;
    private String surname;
    private Set<AccountDTO> accounts;
}
