package com.demo.account.validator

import com.demo.account.exception.InvalidUserIdException
import spock.lang.Specification

class UserIdValidatorTest extends Specification {

    def userIdValidator = new UserIdValidator()

    def 'returns true when a valid user Id is specified in the input'() {
        when:
        def result = userIdValidator.isValid('12121212',null)
        then:
        result == true
    }

    def 'throws InvalidUserIdException when an invalid user Id is provided as input'() {
        when:
        def result = userIdValidator.isValid('user',null)
        then:
        result == false
    }
}
