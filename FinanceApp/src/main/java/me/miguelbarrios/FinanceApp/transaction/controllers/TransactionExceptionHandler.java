package me.miguelbarrios.FinanceApp.transaction.controllers;


import me.miguelbarrios.FinanceApp.transaction.exceptions.TransactionNotFoundException;
import me.miguelbarrios.FinanceApp.transaction.exceptions.TransactionUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionHandler {

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<String> handleTransactionNotFoundException(TransactionNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TransactionUnauthorizedException.class)
    public ResponseEntity<String> handleTransactionUnauthorizedException(TransactionUnauthorizedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not authorized to delete this transaction");
    }
}