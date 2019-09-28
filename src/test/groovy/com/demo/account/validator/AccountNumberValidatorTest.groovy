package com.demo.account.validator

import com.demo.account.exception.InvalidAccountNumberException
import spock.lang.Specification

class AccountNumberValidatorTest  extends Specification{

    def accountNumberValidator = new AccountNumberValidator()

    def 'validates account number to be number with an optional \'-\' with a maximum of 16 digits'() {
        expect:
        result == accountNumberValidator.isValid(account_number,null)
        where:
            account_number             |  result
            '12-12-12-12-12'           |  true
            '12686868686'              |  true

    }

    def 'throws InvalidAccountNumberException when invalid account number is provided'() {
        expect:
        result == accountNumberValidator.isValid(account_number,null)
        where:
        account_number              |  result
        '12-12-12-12-12A'           |  false
        'USERS'                     |  false

    }
}
