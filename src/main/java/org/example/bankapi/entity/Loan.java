package org.example.bankapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int loanId;

        @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.REFRESH, CascadeType.DETACH})
        @JoinColumn(name = "customer_id")
        private Customer customer;

        private String startDate;

        private int totalLoan;

        private int amountPaid;

        private int outstandingAmount;

        private String loanType;

        private String created_at;
}
