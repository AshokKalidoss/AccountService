package com.demo.account.repository;

import com.demo.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, String> {

    public List<Transaction> findAllByAccountAccountNumber(String accountNumber);

}
