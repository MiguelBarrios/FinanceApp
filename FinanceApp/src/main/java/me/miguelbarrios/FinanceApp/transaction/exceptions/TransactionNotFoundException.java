package me.miguelbarrios.FinanceApp.transaction.exceptions;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(int id) {
        super("Transaction not found with id: " + id);
    }
}
