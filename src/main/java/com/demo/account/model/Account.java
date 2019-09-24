package com.demo.account.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
public class Account {
    @Id
    private String accountId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private Customer customer;

    private String accountNumber;

    private String accountName;

    private String accountType;

    private Date balanceDate;

    private String currencyCode;

    private BigDecimal accountBalance;
}
