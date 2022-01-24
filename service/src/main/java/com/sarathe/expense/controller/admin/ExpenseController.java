package com.sarathe.expense.controller.admin;

import com.sarathe.expense.dto.MemberDto;
import com.sarathe.expense.dto.mappers.DtoMapper;
import com.sarathe.expense.models.Expense;
import com.sarathe.expense.service.IExpense;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("expense")
public class ExpenseController {

    private final IExpense iExpense;
    private DtoMapper dtoMapper;

    @GetMapping("/dates/{sourceDate}/{targetDate}")
    public ResponseEntity<Set<MemberDto.ExpenseDto>> findExpenseByDates(@PathVariable("sourceDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate sourceDate,
                                                                        @PathVariable("targetDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate targetDate) {
        Set<Expense> expenseAmountByDate = iExpense.findExpenseAmountByDate(sourceDate, targetDate);
        Set<MemberDto.ExpenseDto> expenseDtos = dtoMapper.toExpenseDtoSet(expenseAmountByDate);
        return new ResponseEntity<>(expenseDtos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateExpense(@RequestBody MemberDto.ExpenseDto expenseDto) {
        Expense expense = dtoMapper.toExpense(expenseDto);
        iExpense.addOrUpdateExpense(expense);
        return new ResponseEntity<>("Expense saved success",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id) {
        iExpense.deleteExpense(id);
        return new ResponseEntity<>("Expense deleted successfully",HttpStatus.OK);
    }

}
