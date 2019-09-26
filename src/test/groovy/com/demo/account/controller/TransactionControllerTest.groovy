package com.demo.account.controller

import com.demo.account.service.impl.TransactionServiceImpl
import spock.lang.Specification

class TransactionControllerTest extends Specification {

    def transactionService = Mock(TransactionServiceImpl)

    def transactionController = new TransactionController(
            transactionService: transactionService
    )

    def "transaction controller invokes transaction service"() {
        given:
        when:
        def response = transactionController.getTransactionsForAccount("34567")
        then:
        1 * transactionService.getTransactionsForAccount("34567")
    }
}
