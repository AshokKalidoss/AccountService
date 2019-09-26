package com.demo.account.controller;

import com.demo.account.dto.TransactionDTO;
import com.demo.account.service.TransactionService;
import com.demo.account.validator.ValidAccountNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/v1/accounts/{accountNumber}/transactions")
    public ResponseEntity<List<TransactionDTO>> getTransactionsForAccount(
            @PathVariable("accountNumber") @ValidAccountNumber String accountNumber) {
        return new ResponseEntity(transactionService.getTransactionsForAccount(accountNumber)
                , HttpStatus.OK);
    }
}
