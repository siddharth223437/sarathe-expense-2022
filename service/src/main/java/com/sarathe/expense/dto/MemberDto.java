package com.sarathe.expense.dto;

import com.sarathe.expense.models.PaymentType;
import com.sarathe.expense.models.RoleName;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class MemberDto{

    private Long id;
    private String email;
    private boolean isActive;
    private String phoneNumber;
    private RoleName roleName;
    private HouseDto houseDto;
    private ExpenseDto expenseDto;

    @Data
    public static class ExpenseDto {
        private Long id;
        private UUID transactionId;
        private Double amount;
        private String category;
        private String notes;
        private String expensePaidBy;
        private PaymentType paymentType;
        private LocalDate expenseDate;
    }

}
