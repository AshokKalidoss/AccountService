package com.demo.account.controller

import com.demo.account.service.impl.AccountServiceImpl
import spock.lang.Specification

class AccountsControllerTest extends Specification{

    def accountService = Mock(AccountServiceImpl)

    def accountsController = new AccountsController(
            accountService: accountService
    )

    def 'accounts controller invokes account service'() {
        given:
        when:
        def response = accountsController.getAccountsByUserId("123456")
        then:
        1 * accountService.getAccounts("123456")

    }
}
