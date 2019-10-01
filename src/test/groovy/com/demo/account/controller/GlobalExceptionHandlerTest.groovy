package com.demo.account.controller

import com.demo.account.exception.ErrorResponse
import com.demo.account.exception.InvalidAccountNumberException
import com.demo.account.exception.InvalidUserIdException
import com.demo.account.exception.ResourceNotFoundException
import com.demo.account.exception.handler.GlobalExceptionHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpServerErrorException
import spock.lang.Specification

import javax.servlet.http.HttpServletRequest
import java.nio.charset.Charset

class GlobalExceptionHandlerTest extends Specification{

    def handler
    def request
    def resourceNotFoundException
    def internalServerError
    def invalidUserIdException
    def invalidAccountNumberException

    def setup() {
        handler = new GlobalExceptionHandler()
        request = Mock(HttpServletRequest)
        resourceNotFoundException = new ResourceNotFoundException("Not_found","1001")
        internalServerError = new HttpServerErrorException.InternalServerError("InternalError",null,null, Charset.defaultCharset());
        invalidUserIdException = new InvalidUserIdException("Invalid user id","1002")
        invalidAccountNumberException = new InvalidAccountNumberException("Invalid account number","1003")
    }

    def 'set code and message when handling ResourceNotFoundException'() {
        when:
        ResponseEntity<ErrorResponse> response = handler.handleResourceNotFoundException(resourceNotFoundException, request)
        then:

        response.statusCode == HttpStatus.NOT_FOUND
        response.body.errorCode == "1001"
        response.body.errorDescription == "Not_found"
    }

    def 'set code and message when handling InternalServerError'() {
        when:
        ResponseEntity<ErrorResponse> response = handler.handleInternalServerError(internalServerError, request)
        then:

        response.statusCode == HttpStatus.INTERNAL_SERVER_ERROR
        response.body.errorCode == "9001"
        response.body.errorDescription == "Unexpected Error"
    }

    def 'set code and message when handling InvalidUserIdException'() {
        when:
        ResponseEntity<ErrorResponse> response = handler.handleInvalidUserIdException(invalidUserIdException, request)
        then:

        response.statusCode == HttpStatus.BAD_REQUEST
        response.body.errorCode == "1002"
        response.body.errorDescription == "Invalid user id"
    }

    def 'set code and message when handling InvalidAccountNumberException'() {
        when:
        ResponseEntity<ErrorResponse> response = handler.handleInvalidAccountNumberException(invalidAccountNumberException, request)
        then:

        response.statusCode == HttpStatus.BAD_REQUEST
        response.body.errorCode == "1003"
        response.body.errorDescription == "Invalid account number"
    }


}
