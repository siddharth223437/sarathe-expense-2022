package com.sarathe.expense;


import com.sarathe.expense.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
public class SaratheExpenseApplication implements CommandLineRunner {


	@Autowired
	private House.HouseRepository houseRepository;
	@Autowired
	private Member.MemberRepository memberRepository;
	@Autowired
	private Roles.RoleRepository roleRepository;

	@Autowired
	private EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(SaratheExpenseApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		String setUsernameSql = "set @username=:username";
		em.createNativeQuery(setUsernameSql).setParameter("username", "siddharth").executeUpdate();
//		Address address = new Address();
//		address.setAddressType(AddressType.RS);
//		address.setStreet1("924 Horizon Dr.");
//		address.setCity("Tiffin");
//		address.setState("IA");
//		address.setCountry("USA");
//		address.setPostalCode("52340");
//
//		House house = new House();
//		house.setName("Sarathe-House");
//		house.setAddress(address);
//
//		MemberBio bio = new MemberBio();
//		bio.setFirstName("Siddharth");
//		bio.setLastName("Sarathe");
//		bio.setDob(LocalDate.of(1990,3,20));
//		bio.setAge(32);
//
//		Member member = new Member();
//		member.setActive(true);
//		member.setEmail("sarathe@mail.usf.edu");
//		member.setPhoneNumber("8134811497");
//		member.setMemberBio(bio);
//		member.setHouse(house);
//		Set<Member> memberSet = new HashSet<>();
//		memberSet.add(member);
//		Set<Expense> expenses = new HashSet<>();
//
//		Expense expense = new Expense();
//		expense.setAmount(40.02);
//		expense.setCategory("Travel");
//		expense.setExpenseType("AMEX");
//		expense.setExpensePaidBy("Siddharth");
//		expense.setExpenseDate(LocalDate.now());
//
//		expenses.add(expense);
//		member.setExpenses(expenses);
//
//		Roles roles = new Roles();
//		roles.setName(RoleName.ADMIN);
////		roles.setMembers(memberSet);
//		roleRepository.save(roles);
//
//		Set<Roles> rolesSet = new HashSet<>();
//		rolesSet.add(roles);
//
//		member.setRoles(rolesSet);
//
//		houseRepository.save(house);
//		memberRepository.save(member);

	}
}
