package com.sarathe.expense.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "member")
public class Member extends WithMetaData {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Embedded
    private MemberBio memberBio;

    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "is_active")
    private boolean isActive;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private Set<Expense> expenses = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "member_role", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

//    public void addExpenses(Expense expenses) {
//        this.expenses.add(expenses);
//    }

    @Repository
    public interface MemberRepository extends JpaRepository<Member,Long> {
        public Set<Member> findMemberByHouse(House house);
        public Member findByEmail(String email);
        public Member findByUsername(String username);
    }
}
