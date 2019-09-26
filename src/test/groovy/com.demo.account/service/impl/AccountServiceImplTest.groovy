package com.demo.account.service.impl

import com.demo.account.exception.ResourceNotFoundException
import com.demo.account.model.Account
import com.demo.account.repository.AccountRepo
import org.modelmapper.ModelMapper
import spock.lang.Specification
import java.sql.Date;


class AccountServiceImplTest extends Specification {

    def accountRepository = Mock(AccountRepo)
    def modelMapper = new ModelMapper()

    def accountServiceImpl = new AccountServiceImpl(
            accountRepository: accountRepository,
            modelMapper: modelMapper
    )


    def "retrieves an account list for a give userId" (){
        given:
        def accountList = new ArrayList()
        def account = new Account()
        account.accountNumber = "123456"
        account.setBalanceDate(new Date(2019,12,12))
        accountList.add(account)
        when:
        def result = accountServiceImpl.getAccounts("123456")
        then:
        1 * accountRepository.findAllByCustomerUserId(_) >> accountList
        result.size() > 0
    }

    def "throws a ResourceNotFoundException when no accounts are retrieved" (){
        given:
        def accountList = new ArrayList()
        when:
        def result = accountServiceImpl.getAccounts("123456")
        then:
        1 * accountRepository.findAllByCustomerUserId(_) >> accountList
        thrown ResourceNotFoundException
    }

    def "throws a ResourceNotFoundException when accountList is returned as null" (){
        given:
        when:
        def result = accountServiceImpl.getAccounts("123456")
        then:
        1 * accountRepository.findAllByCustomerUserId(_) >> null
        thrown ResourceNotFoundException
    }

    def "Maps multiple accounts to the DTO when a valid account list with more than 1 record is returned" (){
        given:
        def accountList = new ArrayList()
        def account1 = new Account()
        account1.accountNumber = "123456"
        account1.accountBalance = 100.00
        account1.accountName = "First Account"
        account1.setBalanceDate(new Date(2019,12,12))
        account1.accountType = "Checking"
        account1.currencyCode = "INR"
        accountList.add(account1)

        def account2 = new Account()
        account2.accountNumber = "987654"
        account2.accountBalance = 200.56
        account2.accountName = "Second Account"
        account2.setBalanceDate(new Date(2019,12,12))
        account2.accountType = "Saving"
        account2.currencyCode = "AUD"
        accountList.add(account2)

        when:
        def result = accountServiceImpl.getAccounts("123456")
        then:
        1 * accountRepository.findAllByCustomerUserId(_) >> accountList
        result.size() == 2
        result[0].accountNumber == "123456"
        result[1].accountNumber == "987654"
        result[0].accountName == "First Account"
        result[1].accountName == "Second Account"
        result[0].accountType == "Checking"
        result[1].accountType == "Saving"
        result[0].currencyCode == "INR"
        result[1].currencyCode == "AUD"
        result[0].accountBalance == 100.00
        result[1].accountBalance == 200.56
    }

}