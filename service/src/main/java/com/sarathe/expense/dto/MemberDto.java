package com.sarathe.expense.dto;

import com.sarathe.expense.models.RoleName;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberDto{

    private Long id;
    private String email;
    private boolean isActive;
    private String phoneNumber;
    private RoleName roleName;
    private HouseDto houseDto;

    @Data
    private static class ExpenseDto {
        private Double amount;
        private String category;
        private String notes;
        private String expensePaidBy;
        private String expenseType;
        private LocalDate expenseDate;
    }

}
