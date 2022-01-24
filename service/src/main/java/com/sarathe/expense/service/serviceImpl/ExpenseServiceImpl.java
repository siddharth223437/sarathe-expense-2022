package com.sarathe.expense.service.serviceImpl;

import com.sarathe.expense.models.Expense;
import com.sarathe.expense.models.Member;
import com.sarathe.expense.service.IExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements IExpense {

    private static final String email = "sarathe@mail.usf.edu";

    private final Expense.ExpenseRepository expenseRepository;
    private final Member.MemberRepository memberRepository;

    @Override
    public Double findExpenseAmountByDate(LocalDate localDate) {
        return null;
    }

    @Override
    public Set<Expense> findExpenseAmountByDate(LocalDate sourceDate, LocalDate targetDate) {
        Member byEmail = memberRepository.findByEmail(email);
        Set<Expense> byExpensesExpenseDateBetween = expenseRepository.findExpenseByExpenseDateBetweenAndMember(sourceDate, targetDate,byEmail);
        return byExpensesExpenseDateBetween;
    }

    @Override
    public void addOrUpdateExpense(Expense expense) {
        if(expense.getId() == null){
            //new Expense
            expense.setTransactionId(UUID.randomUUID());
        }
        //delete this later, this is just for testing
        Member byEmail = memberRepository.findByEmail(email);
        expense.setMember(byEmail);
        expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
