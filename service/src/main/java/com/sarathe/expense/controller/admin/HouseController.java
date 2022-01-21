package com.sarathe.expense.controller.admin;

import com.sarathe.expense.dto.HouseDto;
import com.sarathe.expense.dto.mappers.DtoMapper;
import com.sarathe.expense.models.House;
import com.sarathe.expense.service.IHouse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("house")
public class HouseController {

    private final IHouse iHouse;
    private final DtoMapper mapper;

    @PostMapping("/add")
    public ResponseEntity<String> addNewHouse(@RequestBody HouseDto dto) {
        try{
            House house = mapper.houseDtoToHouse(dto);
            iHouse.createOrUpdateHouse(house);
            System.out.println("");
        }catch (Exception e){

        }
        return null;
    }
}
