package com.capgemini.airlinereservationsystemjdbc;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.jfsfeb.airlinereservationsystemjdbc.dao.AirlineDAO;
import com.jfsfeb.airlinereservationsystemjdbc.dao.AirlineDAOJDBCImp;
import com.jfsfeb.airlinereservationsystemjdbc.dto.User;



public class AirlineDAOTest {
	
	AirlineDAO dao=new AirlineDAOJDBCImp();
	@Test
	public void register() {
		 User user=new User();
		 user.setId(1006);
		 user.setEmailId("Kutti@gmail.com");
		 user.setName("Kanna");
		 user.setPassword("Kanna@1");
		 user.setMobileNumber(98786452310l);
		 user.setRole("user");
		 boolean status = dao.register(user);
		 assertEquals(true, status);	
	}
	@Test
	public void userLoginTest() {
		User actual = dao.authenticate("Kutti@gmail.com", "Kanna@1");
		Assertions.assertNotNull(actual);
		
	}


}
