package com.sarathe.expense.service;

import com.sarathe.expense.models.House;
import com.sarathe.expense.models.Member;

import java.util.Optional;

public interface IHouse {

    public void createOrUpdateHouse(House house);
    public Optional<House> findHouseById(Long id);
    public House findHouseByMember(Member member);
    public void deleteHouse(Long id);

}
