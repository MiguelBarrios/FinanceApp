package me.miguelbarrios.FinanceApp.transaction.services;

import lombok.AllArgsConstructor;
import me.miguelbarrios.FinanceApp.transaction.exceptions.TransactionNotFoundException;
import me.miguelbarrios.FinanceApp.transaction.exceptions.TransactionUnauthorizedException;
import me.miguelbarrios.FinanceApp.transaction.models.Transaction;
import me.miguelbarrios.FinanceApp.transaction.repositories.TransactionRepository;
import me.miguelbarrios.FinanceApp.user.models.AppUser;
import me.miguelbarrios.FinanceApp.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    private final UserRepository userRepository;

    @Override
    public List<Transaction> getUserTransactions(String username) {
        AppUser user = userRepository.findByUsername(username);
        return transactionRepository.findAllByUserId(user.getId());
    }

    @Override
    public Transaction addTransaction(String username, Transaction transaction) {
        AppUser user = userRepository.findByUsername(username);
        transaction.setUser(user);
        Transaction transaction1 = transactionRepository.save(transaction);
        return transaction1;
    }

    @Override
    public void deleteTransactionById(String username, int transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException(transactionId));

        if(!transactionBelongsToUser(transaction, username)){
            throw new TransactionUnauthorizedException();
        }

        transactionRepository.deleteById(transactionId);
    }

    @Override
    public Transaction updateTransactionById(String username, Transaction transaction, Integer transactionId) {
        Transaction managedTransaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException(transactionId));

        if(!transactionBelongsToUser(managedTransaction, username)){
            throw new TransactionUnauthorizedException();
        }

        transaction.setId(transactionId);
        transaction.setUser(managedTransaction.getUser());
        return transactionRepository.save(transaction);
    }

    public boolean transactionBelongsToUser(Transaction transaction, String username){
        return transaction.getUser().getUsername().equals(username);
    }
}
