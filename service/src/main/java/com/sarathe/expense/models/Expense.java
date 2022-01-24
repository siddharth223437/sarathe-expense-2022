package com.sarathe.expense.models;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "expense")
public class Expense extends WithMetaData {

    @Id
    @GeneratedValue
    @Column(name = "expense_id")
    private Long id;

    @Column(name = "transaction_id")
    private UUID transactionId;

    @Basic
    @Column(name = "amount")
    private Double amount;

    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "notes")
    private String notes;
    @Basic
    @Column(name = "expense_paid_by")
    private String expensePaidBy;
    @Basic
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @Basic
    @Column(name = "expense_date")
    private LocalDate expenseDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Repository
    public interface ExpenseRepository extends JpaRepository<Expense,Long> {
        public Set<Expense> findExpenseByExpenseDateBetweenAndMember(LocalDate sourceDate, LocalDate targetDate, Member member);
    }

}
