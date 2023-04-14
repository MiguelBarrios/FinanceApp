package me.miguelbarrios.FinanceApp.transaction.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.miguelbarrios.FinanceApp.user.models.AppUser;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name="transaction_item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String merchant;

    @Column(name="transaction_date")
    private LocalDate transactionDate;

    private double amount;


    private String category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser user;
}
