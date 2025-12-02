package com.invilens.pharmacy.handler;

import com.invilens.pharmacy.exception.ProductNotFoundException;
import com.invilens.pharmacy.exception.ProductPurchaseException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductPurchaseException.class)
    public ResponseEntity<String> handle(ProductPurchaseException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handle(ProductNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

   @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handle(DataAccessException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Database error");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body("Something Went Wrong");
    }


}
