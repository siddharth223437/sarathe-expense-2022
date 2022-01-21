package com.sarathe.expense.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.HashSet;
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

    @ElementCollection()
    @CollectionTable(name = "expense",joinColumns = @JoinColumn(name = "member_id"))
    private Set<Expense> expenses = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_role", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    public interface MemberRepository extends JpaRepository<Member,Long> {

        public Set<Member> findMemberByHouse(House house);
    }
}
