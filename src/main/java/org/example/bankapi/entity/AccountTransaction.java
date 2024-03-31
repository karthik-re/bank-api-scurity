package org.example.bankapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "account_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "account_number")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Date transactionDate;

    private String transactionSummary;

    private int transactionAmount;

    private String transactionType;

    private int closingBalance;

    private String created_at;
}
