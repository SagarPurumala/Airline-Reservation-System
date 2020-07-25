package com.jfsfeb.airlinereservationsystemhibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.jfsfeb.airlinereservationsystemhibernate.dao.AirlineDAO;
import com.jfsfeb.airlinereservationsystemhibernate.dao.AirlineDAOJPAImpl;
import com.jfsfeb.airlinereservationsystemhibernate.dto.User;



public class AirlineDAOTest {
	AirlineDAO dao=new AirlineDAOJPAImpl();
	@Test
	public void register() {
		 User user=new User();
		 user.setId(1098);
		 user.setEmailId("Kutt@gmail.com");
		 user.setName("Kanna");
		 user.setPassword("Kannaa@1");
		 user.setMobileNumber(98786452310l);
		 user.setRole("user");
		 boolean status = dao.register(user);
		 assertEquals(true, status);	
	}
	@Test
	public void userLoginTest() {
		User actual = dao.authenticate("Kutt@gmail.com","Kannaa@1");
		Assertions.assertNotNull(actual);
		
	}


}
