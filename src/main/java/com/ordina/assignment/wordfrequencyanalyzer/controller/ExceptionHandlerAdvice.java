package com.ordina.assignment.wordfrequencyanalyzer.controller;

import com.ordina.assignment.wordfrequencyanalyzer.exception.DataNotFoundException;
import com.ordina.assignment.wordfrequencyanalyzer.model.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ExceptionHandlerAdvice
 * <br>
 * <code>com.ordina.assignment.wordfrequencyanalyzer.controller.ExceptionHandlerAdvice</code>
 * <br>
 *
 * @author hemanshu.banga
 */

@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * Method to handle user not found exception
     *
     * @param dataNotFoundException exception that user is not found
     * @return response entity with not found error code and error object
     */
    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<ErrorObject> handleDataNotFoundException(DataNotFoundException dataNotFoundException) {
        ErrorObject errorObject = new ErrorObject(String.valueOf(HttpStatus.NOT_FOUND.value()), dataNotFoundException.getExceptionMessage());
        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }
}
