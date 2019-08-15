package com.angularspring.mvn.springbackendrest;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class DemoApplicationTests {

	UserRepository repositoryMock = Mockito.mock(UserRepository.class);
	List<User> users = new ArrayList<>();
	

	@BeforeAll
	 void setup(){
		System.out.println("@Beforeall executed");
		User user = new User();
		user.setEmail("mail yahoo com");
		user.setName("Amani");

		users.add(user);
	 }

	@BeforeEach
	 void setupEach(){
		System.out.println("@BeforeAll executed");
	}

	@Test
	void contextLoads() {
		
		Iterable<User> iterable = new ArrayList<>();
		iterable = users;
		when(repositoryMock.findAll()).thenReturn(iterable);

		UserController service = new UserController(repositoryMock);
		Iterable<User> r = service.getUsers();

		assertSame(iterable, r);

	}


}
