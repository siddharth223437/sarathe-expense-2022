package com.sarathe.expense.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "house")
@Entity
public class House extends WithMetaData {

    @Id
    @GeneratedValue
    @Column(name = "house_id")
    private Long id;

    @Column(name = "house_name")
    private String name;

    @Embedded
    private Address address;

//    @ElementCollection
//    @CollectionTable(name = "member", joinColumns = @JoinColumn(name = "house_id"))
//    private Set<Member> members = new HashSet<>();


    @Repository
    public interface HouseRepository extends JpaRepository<House,Long>{

    }

}
