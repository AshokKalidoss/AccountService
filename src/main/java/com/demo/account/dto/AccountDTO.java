package com.demo.account.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountDTO {

    private String accountNumber;

    private String accountName;

    private String accountType;

    private Date balanceDate;

    private String currencyCode;

    private BigDecimal accountBalance;
}
