package com.demo.account.controller;

import com.demo.account.dto.AccountDTO;
import com.demo.account.exception.ErrorResponse;
import com.demo.account.service.AccountService;
import com.demo.account.validator.ValidUserId;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Validated
@Slf4j
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/v1/users/{userId}/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get Accounts", response = AccountDTO.class, responseContainer = "List",
            notes = "This API retrieves a list of accounts for the user id provided as input")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = AccountDTO.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    public ResponseEntity<List<AccountDTO>> getAccountsByUserId(
            @ApiParam(name = "userId", value = "User ID that will be used to retrieve accounts", required = true)
            @PathVariable("userId")  @ValidUserId String userId ,
            final HttpServletRequest request) {

        log.info("Inside AccountController to retrieve accounts for user: {}", userId);
        return new ResponseEntity(accountService.getAccounts(userId), HttpStatus.OK);
    }


}