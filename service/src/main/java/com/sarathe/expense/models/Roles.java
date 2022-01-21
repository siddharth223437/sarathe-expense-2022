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
@Table(name = "roles")
public class Roles extends WithMetaData{

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleName name;

//    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
//    private Set<Member> members = new HashSet<>();

    public interface RoleRepository extends JpaRepository<Roles,Long> {
        public Roles findRolesByName(RoleName name);
    }
}
