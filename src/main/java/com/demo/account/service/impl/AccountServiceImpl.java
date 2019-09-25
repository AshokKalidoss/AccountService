package com.demo.account.service.impl;

import com.demo.account.dto.AccountDTO;
import com.demo.account.exception.ResourceNotFoundException;
import com.demo.account.model.Account;
import com.demo.account.model.Customer;
import com.demo.account.repository.AccountRepo;
import com.demo.account.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepository;

    @Autowired
    ModelMapper modelMapper;

    public  List<AccountDTO> getAccounts(String userId) throws ResourceNotFoundException {

       List<Account> accountList;
       accountList  = accountRepository.findAllByCustomerUserId(userId);
       if (accountList.isEmpty()) {
           throw new ResourceNotFoundException("1000","No valid account found for the user: " + userId);
       }
         return accountList.stream()
                  .map(account -> convertToDto(account))
                  .collect(Collectors.toList());
    }

    private AccountDTO convertToDto(Account account) {
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
        return accountDTO;
    }
}
