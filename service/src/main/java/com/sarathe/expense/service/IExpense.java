package com.sarathe.expense.service;

import com.sarathe.expense.models.Expense;

import java.time.LocalDate;
import java.util.Set;

public interface IExpense {

    Double findExpenseAmountByDate(LocalDate localDate);
    Set<Expense> findExpenseAmountByDate(LocalDate sourceDate, LocalDate targetDate);
    void addOrUpdateExpense(Expense expense);
    void deleteExpense(Long id);
}
