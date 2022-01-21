package com.sarathe.expense.service;

import com.sarathe.expense.models.House;
import com.sarathe.expense.models.Member;

import java.util.Optional;
import java.util.Set;

public interface IMember {

    public void createOrUpdateMember(Member member);
    public Optional<Member> findMemberById(Long id);
    public Set<Member> findMemberByHouse(House house);
    public void deleteMember(Long id);
}
