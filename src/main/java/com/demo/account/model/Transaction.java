package com.demo.account.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
public class Transaction {
    @Id
    private int transactionId;
    private String accountNumber;
    private String accountName;
    private Date transactionDate;
    private String currencyCode;
    private BigDecimal transactionAmount;
    private boolean isCredit;
    private String transactionNarrative;
}
