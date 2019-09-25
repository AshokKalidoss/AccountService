package com.demo.account.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
public class Transaction {
    @Id
    private int transactionId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "accountNumber", nullable = false)
    private Account account;

    private Date valueDate;

    private String currencyCode;

    private BigDecimal transactionAmount;

    private boolean isCredit;

    private String transactionNarrative;
}
