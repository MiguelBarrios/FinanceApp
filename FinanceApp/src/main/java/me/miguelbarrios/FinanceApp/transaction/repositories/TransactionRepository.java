package me.miguelbarrios.FinanceApp.transaction.repositories;

import me.miguelbarrios.FinanceApp.transaction.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByUserId(int userId);
}
