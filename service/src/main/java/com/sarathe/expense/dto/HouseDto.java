package com.sarathe.expense.dto;

import com.sarathe.expense.models.AddressType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseDto extends BaseDto{

    private String name;
    private AddressDto addressDto;


    @Data
    public static class AddressDto {
        private String street1;
        private String street2;
        private String city;
        private String state;
        private String country;
        private AddressType addressType;
        private String postalCode;
    }
}
