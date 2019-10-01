package com.demo.account.exception.handler;

import com.demo.account.exception.ErrorResponse;
import com.demo.account.exception.InvalidAccountNumberException;
import com.demo.account.exception.InvalidUserIdException;
import com.demo.account.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static com.demo.account.exception.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.demo.account.exception.ErrorCode.VALIDATION_ERROR;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception
            , HttpServletRequest request) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(exception.getErrorCode())
                .errorDescription(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidUserIdException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUserIdException(InvalidUserIdException exception
            , HttpServletRequest request) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(exception.getErrorCode())
                .errorDescription(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAccountNumberException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAccountNumberException(InvalidAccountNumberException exception
            , HttpServletRequest request) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(exception.getErrorCode())
                .errorDescription(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception
            , HttpServletRequest request) {

        String validationErrorMessage = VALIDATION_ERROR.message;
        for (ConstraintViolation constraintViolation : exception.getConstraintViolations()) {
                     validationErrorMessage = constraintViolation.getMessage();

        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(VALIDATION_ERROR.code)
                .errorDescription(validationErrorMessage)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception exception
            , HttpServletRequest request) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(INTERNAL_SERVER_ERROR.code)
                .errorDescription(INTERNAL_SERVER_ERROR.message)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
