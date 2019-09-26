package com.demo.account.controller;

import com.demo.account.dto.ErrorResponse;
import com.demo.account.dto.TransactionDTO;
import com.demo.account.service.TransactionService;
import com.demo.account.util.Constants;
import com.demo.account.validator.ValidAccountNumber;
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
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@Validated
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/v1/accounts/{accountNumber}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Transactions", response = TransactionDTO.class, responseContainer = "List",
            notes = "This API retrieves a list of transactions for the account number provided as input.")
    @ApiResponses({
            @ApiResponse(code = Constants.HTTP_200, message = "OK"),
            @ApiResponse(code = Constants.HTTP_400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = Constants.HTTP_404, message = "Not Found", response = ErrorResponse.class),
            @ApiResponse(code = Constants.HTTP_500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    public ResponseEntity<List<TransactionDTO>> getTransactionsForAccount(
            @ApiParam(name = "accountNumber", value = "Account number that will be used to retrieve user's information", required = true)
            @PathVariable("accountNumber") @ValidAccountNumber String accountNumber,
            final HttpServletRequest request) {

        log.info("Inside TransactionController to retrieve transactions for the account: {}", accountNumber);
        return new ResponseEntity(transactionService.getTransactionsForAccount(accountNumber)
                , HttpStatus.OK);
    }
}
