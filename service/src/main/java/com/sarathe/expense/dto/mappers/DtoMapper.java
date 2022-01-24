package com.sarathe.expense.dto.mappers;

import com.sarathe.expense.dto.HouseDto;
import com.sarathe.expense.dto.MemberDto;
import com.sarathe.expense.models.Expense;
import com.sarathe.expense.models.House;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(
        componentModel = "spring"
)
public interface DtoMapper {

    @Mapping(source = "houseDto.addressDto",target = "address")
    public House houseDtoToHouse(HouseDto houseDto);
    
    public Set<MemberDto.ExpenseDto> toExpenseDtoSet(Set<Expense> expenses);
    public Expense toExpense(MemberDto.ExpenseDto  expenseDto);
}
