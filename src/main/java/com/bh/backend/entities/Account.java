package com.bh.backend.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "customer_id")
    private int customerId;
    @NotNull
    @Column(name = "balance")
    private double balance;
    @OneToMany(mappedBy = "accountId", fetch = FetchType.EAGER)
    private Set<Transaction> transactionSet;
}
