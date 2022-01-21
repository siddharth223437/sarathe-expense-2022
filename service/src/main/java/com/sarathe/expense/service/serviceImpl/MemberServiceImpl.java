package com.sarathe.expense.service.serviceImpl;

import com.sarathe.expense.models.House;
import com.sarathe.expense.models.Member;
import com.sarathe.expense.models.RoleName;
import com.sarathe.expense.models.Roles;
import com.sarathe.expense.service.IMember;
import com.sarathe.expense.service.IRole;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class MemberServiceImpl implements IMember, IRole {

    private final Member.MemberRepository memberRepository;
    private final Roles.RoleRepository roleRepository;

    @Override
    public void createOrUpdateMember(Member member) {
        try{
            memberRepository.save(member);
        }catch (Exception e){
            log.error("--Exception in saving or updating member---");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Member> findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Set<Member> findMemberByHouse(House house) {
        return memberRepository.findMemberByHouse(house);
    }

    @Override
    public void deleteMember(Long id) {
        Optional<Member> memberById = findMemberById(id);
        if(memberById.isPresent()){
            memberRepository.delete(memberById.get());
        }else {
            throw new RuntimeException("---Cannot delete member---- id is not present");
        }
    }

    @Override
    public void add(Roles role) {
        roleRepository.save(role);
    }

    @Override
    public Roles findRoleByName(RoleName roleName) {
        return roleRepository.findRolesByName(roleName);
    }
}
