package com.demo.account.service;

import com.demo.account.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {

    List<TransactionDTO> getTransactionsForAccount(String accountNumber);
}
