package com.sarathe.expense.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@Embeddable
public class Expense {

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
    @Column(name = "type")
    private String expenseType;
    @Basic
    @Column(name = "expense_date")
    private LocalDate expenseDate;
}
