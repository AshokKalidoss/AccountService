package com.demo.account.controller;

import com.demo.account.dto.AccountDTO;
import com.demo.account.service.AccountService;
import com.demo.account.validator.ValidUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AccountsController {

    @Autowired
    AccountService accountService;

    @GetMapping("/users/{userId}/accounts")
    @ResponseBody
    public ResponseEntity<List<AccountDTO>> getAccountsByUserId( @PathVariable("userId") @ValidUserId String userId) {
        return new ResponseEntity(accountService.getAccounts(userId),HttpStatus.OK);
    }


}