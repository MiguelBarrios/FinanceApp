package me.miguelbarrios.FinanceApp.transaction.services;

import me.miguelbarrios.FinanceApp.transaction.models.Transaction;

import java.util.List;


public interface TransactionService {

    List<Transaction> getUserTransactions(String username);
    Transaction addTransaction(String username, Transaction transaction);
    void deleteTransactionById(String username, int transactionId);
    Transaction updateTransactionById(String username, Transaction transaction, Integer transactionId);
}
