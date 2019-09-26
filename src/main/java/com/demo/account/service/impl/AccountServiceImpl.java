package com.demo.account.service.impl;

import com.demo.account.dto.AccountDTO;
import com.demo.account.exception.ResourceNotFoundException;
import com.demo.account.model.Account;
import com.demo.account.repository.AccountRepo;
import com.demo.account.service.AccountService;
import com.demo.account.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AccountDTO> getAccounts(String userId) throws ResourceNotFoundException {

        List<Account> accountList;
        accountList = accountRepository.findAllByCustomerUserId(userId);
        if (accountList == null || accountList.isEmpty()) {
            throw new ResourceNotFoundException("No valid account found for the user: " + userId, Constants.ACCOUNT_NOT_FOUND_ERRORCODE);
        }
        return accountList.stream()
                .map(account -> convertEntityToDto(account))
                .collect(Collectors.toList());
    }

    private AccountDTO convertEntityToDto(Account account) {
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
        return accountDTO;
    }
}
