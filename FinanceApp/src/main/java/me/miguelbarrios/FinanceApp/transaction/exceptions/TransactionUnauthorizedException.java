package me.miguelbarrios.FinanceApp.transaction.exceptions;

public class TransactionUnauthorizedException extends RuntimeException{
    public TransactionUnauthorizedException() {
        super("The transaction can only be deleted by its creator ");
    }
}
