package com.sarathe.expense.service.serviceImpl;

import com.sarathe.expense.models.House;
import com.sarathe.expense.models.Member;
import com.sarathe.expense.service.IHouse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class HouseServiceImpl implements IHouse {

    private final House.HouseRepository houseRepository;

    @Override
    public void createOrUpdateHouse(House house) {
        try {
            houseRepository.save(house);
        }catch (Exception e){
            log.error("Exception in saving house");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<House> findHouseById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public House findHouseByMember(Member member) {
        return member.getHouse();
    }

    @Override
    public void deleteHouse(Long id) {
        Optional<House> houseById = findHouseById(id);
        if(houseById.isPresent()){
            houseRepository.delete(houseById.get());
        }else {
            throw new RuntimeException("---Cannot delete house, house not found----");
        }
    }
}
