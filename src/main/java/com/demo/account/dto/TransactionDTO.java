package com.demo.account.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class TransactionDTO {
    private String accountNumber;
    private String accountName;
    private String valueDate;
    private String currencyCode;
    private BigDecimal creditAmount;
    private BigDecimal debitAmount;
    private String creditDebitFlag;
    private String transactionNarrative;
}
