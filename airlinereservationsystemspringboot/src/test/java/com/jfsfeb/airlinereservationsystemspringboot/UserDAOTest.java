package com.jfsfeb.airlinereservationsystemspringboot;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserDetails;
import com.jfsfeb.airlinereservationsystemspringboot.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {
	
	@Autowired
	private UserDAO dao;
	
	@Test
	public void registerByAdminTest() {
		UserDetails userBean = new UserDetails();
		userBean.setUserFirstName("Sagar");
		userBean.setUserLastName("Purumala");
		userBean.setUserEmail("admin@gmail.com");
		userBean.setUserContact(9582848408l);
		userBean.setUserId("sagar123");
		userBean.setUserPassword("sagar@12");
		userBean.setUserRole("admin");
		boolean exepected=dao.registerByAdmin(userBean);
		assertEquals(true,exepected);
	}
	
	@Test
	public void userLoginTest() {
		UserDetails actual = dao.userLogin("sagar123", "sagar@12");
		Assertions.assertNotNull(actual);
		
	}

}
