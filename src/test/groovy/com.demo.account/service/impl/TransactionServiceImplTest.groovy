package com.demo.account.service.impl

import com.demo.account.exception.ResourceNotFoundException
import com.demo.account.model.Account
import com.demo.account.model.Transaction
import com.demo.account.repository.TransactionRepo
import org.modelmapper.ModelMapper
import spock.lang.Specification

import java.sql.Date

class TransactionServiceImplTest extends Specification{

    def modelMapper = new ModelMapper()
    def transactionRepo = Mock(TransactionRepo)

    def transactionServiceImpl = new TransactionServiceImpl(
            modelMapper: modelMapper,
            transactionRepo: transactionRepo
    )

    def "retrieves a transaction list for a give account number" (){
        given:
        def transactionList = new ArrayList()
        def transaction = new Transaction()
        def account = new Account()
        account.accountNumber = "123456"
        transaction.account = account
        transaction.transactionAmount = 12345.56
        transaction.credit = true
        transaction.valueDate = new Date(2000,12,12)
        transaction.transactionAmount = 23232.86
        transactionList.add(transaction)
        when:
        def result = transactionServiceImpl.getTransactionsForAccount("123456")
        then:
        1 * transactionRepo.findAllByAccountAccountNumber(_) >> transactionList
        result.size() > 0
        result[0].accountNumber == "123456"
    }

    def "throws a ResourceNotFoundException when no transactions are retrieved for a given account number" (){
        given:
        def transactionList = new ArrayList()
        when:
        def result = transactionServiceImpl.getTransactionsForAccount("123456")
        then:
        1 * transactionRepo.findAllByAccountAccountNumber(_) >> transactionList
        thrown ResourceNotFoundException
    }

    def "throws a ResourceNotFoundException when a null value is returned by the transactionRepo" (){
        given:

        when:
        def result = transactionServiceImpl.getTransactionsForAccount("123456")
        then:
        1 * transactionRepo.findAllByAccountAccountNumber(_) >> null
        thrown ResourceNotFoundException
    }

    def "maps all attributes from entity to DTO when there are more than 1 transaction is returned by the repo" (){
        given:
        def transactionList = new ArrayList()
        def transaction = new Transaction()
        def account = new Account()
        account.accountNumber = "123456"
        transaction.account = account
        transaction.transactionAmount = 12345.56
        transaction.credit = true
        transaction.transactionNarrative = "credit transaction"
        transaction.valueDate = new Date(2000,12,12)
        transactionList.add(transaction)

        def transaction1 = new Transaction()
        transaction1.account = account
        transaction1.credit = false
        transaction1.valueDate = new Date(2018,01,01)
        transaction1.transactionAmount = 23232.86
        transaction1.transactionNarrative = "debit transaction"
        transactionList.add(transaction1)
        when:
        def result = transactionServiceImpl.getTransactionsForAccount("123456")
        then:
        1 * transactionRepo.findAllByAccountAccountNumber(_) >> transactionList
        result.size() == 2
        result[0].accountNumber == "123456"
        result[0].creditAmount == 12345.56
        result[0].transactionNarrative == "credit transaction"
        result[0].creditDebitFlag == "Credit"
        result[1].accountNumber == "123456"
        result[1].debitAmount == 23232.86
        result[1].transactionNarrative == "debit transaction"
        result[1].creditDebitFlag == "Debit"

    }


}
