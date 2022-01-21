package com.sarathe.expense.dto.mappers;

import com.sarathe.expense.dto.HouseDto;
import com.sarathe.expense.models.House;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface DtoMapper {

    @Mapping(source = "houseDto.addressDto",target = "address")
    public House houseDtoToHouse(HouseDto houseDto);
}
