package com.demo.account.controller

import com.demo.account.service.impl.TransactionServiceImpl
import spock.lang.Specification

import javax.servlet.http.HttpServletRequest

class TransactionControllerTest extends Specification {

    def transactionService = Mock(TransactionServiceImpl)
    def httpServletRequest = Mock(HttpServletRequest)

    def transactionController = new TransactionController(
            transactionService: transactionService
    )

    def "transaction controller invokes transaction service"() {
        given:
        when:
        def response = transactionController.getTransactionsForAccount("34567", httpServletRequest)
        then:
        1 * transactionService.getTransactionsForAccount("34567")
    }
}
