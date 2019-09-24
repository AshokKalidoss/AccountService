package com.demo.account.service;

import com.demo.account.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    public abstract List<AccountDTO> getAccounts(String userId);
}
