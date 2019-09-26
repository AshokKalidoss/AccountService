package com.demo.account.controller

import com.demo.account.service.impl.AccountServiceImpl
import spock.lang.Specification

import javax.servlet.http.HttpServletRequest

class AccountsControllerTest extends Specification{

    def accountService = Mock(AccountServiceImpl)
    def httpServletRequest = Mock(HttpServletRequest)

    def accountsController = new AccountsController(
            accountService: accountService
    )

    def 'accounts controller invokes account service'() {
        given:
        when:
        def response = accountsController.getAccountsByUserId("123456", httpServletRequest)
        then:
        1 * accountService.getAccounts("123456")

    }
}
