package com.demo.account.service.impl;

import com.demo.account.dto.TransactionDTO;
import com.demo.account.exception.ResourceNotFoundException;
import com.demo.account.model.Transaction;
import com.demo.account.repository.TransactionRepo;
import com.demo.account.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionServiceImpl  implements TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    ModelMapper modelMapper;

    public static final String uiDatePattern = "MMM dd, yyyy";

    public List<TransactionDTO> getTransactionsForAccount(String accountNumber) {

        List<Transaction> transactionList = transactionRepo.findAllByAccountAccountNumber(accountNumber);
        if (transactionList ==null || transactionList.isEmpty()) {
            throw new ResourceNotFoundException("1001","No valid transactions found for the account: " + accountNumber);
        }
        return transactionList.stream()
                 .map(transaction -> convertToDto(transaction))
            .collect(Collectors.toList());
}

    private TransactionDTO convertToDto(Transaction transaction) {
        TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);
        transactionDTO.setCreditDebitFlag(transaction.isCredit()?"Credit":"Debit");
        if (transaction.isCredit()) {
            transactionDTO.setCreditAmount(transaction.getTransactionAmount());
        } else {
            transactionDTO.setDebitAmount(transaction.getTransactionAmount());
        }
        transactionDTO.setValueDate(dateFormatter(transaction.getValueDate()));
        return transactionDTO;
    }

    /**
     * dateFormatter - to format the date as per UI's requirement
     * @param valueDate - date retrieved from the repository
     * @return String
     */
    private String dateFormatter(Date valueDate) {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(uiDatePattern);
        return simpleDateFormat.format(valueDate);
    }


}
