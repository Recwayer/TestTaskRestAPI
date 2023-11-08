package com.example.testtaskrestapi.exceptions.handlers;

import com.example.testtaskrestapi.exceptions.ClientRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ClientRequestException.InputException.class)
    public ResponseEntity<?> handleInputException(ClientRequestException.InputException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
