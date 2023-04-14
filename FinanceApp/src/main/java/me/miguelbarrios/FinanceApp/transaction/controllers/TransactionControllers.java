package me.miguelbarrios.FinanceApp.transaction.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.miguelbarrios.FinanceApp.transaction.models.Transaction;
import me.miguelbarrios.FinanceApp.transaction.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/transaction")
@RequiredArgsConstructor
@Controller
public class TransactionControllers {
    private final TransactionService transactionService;

    private static final String username = "user1";

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        Transaction newTransaction = transactionService.addTransaction(username, transaction);
        return ResponseEntity.ok(newTransaction);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getUserTransactions(){
        List<Transaction> transactions = transactionService.getUserTransactions(username);
        return ResponseEntity.ok(transactions);
    }

    @DeleteMapping("{transactionId}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable Integer transactionId){
        transactionService.deleteTransactionById(username, transactionId);
        return ResponseEntity.ok("Transaction with id " + transactionId + " deleted");
    }

    @PutMapping("{transactionId}")
    public ResponseEntity<Transaction> updateTransactionId(@PathVariable Integer transactionId, @RequestBody Transaction transaction){
        Transaction updatedTransaction = transactionService.updateTransactionById(username, transaction, transactionId);
        return ResponseEntity.ok(updatedTransaction);
    }




}
