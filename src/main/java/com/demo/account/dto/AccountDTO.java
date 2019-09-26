package com.demo.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO {

    private String accountNumber;

    private String accountName;

    private String accountType;

    private String balanceDate;

    private String currencyCode;

    private BigDecimal accountBalance;
}
