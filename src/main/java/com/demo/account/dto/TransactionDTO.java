package com.demo.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
