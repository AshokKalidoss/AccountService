package com.demo.account.repository;

import com.demo.account.model.Account;
import com.demo.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, String > {

    public List<Account> findAllByCustomerUserId(String userId);
}
