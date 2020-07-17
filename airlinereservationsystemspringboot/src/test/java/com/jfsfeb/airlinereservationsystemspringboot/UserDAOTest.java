package com.jfsfeb.airlinereservationsystemspringboot;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
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
	//@Qualifier("dao")
	private UserDAO dao;
	
	//@Ignore
	@Test
	public void registerTest() {
		UserDetails userBean = new UserDetails();
		userBean.setUserFirstName("Sagar");
		userBean.setUserLastName("Purumala");
		userBean.setUserEmail("admin@gmail.com");
		userBean.setUserContact(9582848408l);
		userBean.setUserId("sagar12345");
		userBean.setUserPassword("sagar@123");
		userBean.setUserRole("admin");
		//dao.registerByAdmin(userBean);
		assertEquals(true, dao.registerByAdmin(userBean));
	}
	
//	@Test
//	public void userLoginTest() {
//		String actual = dao.userLogin("sagar12345", "sagar@123");
//		assertEquals("user", actual);
//	}
//	
//	@Test
//	public void adminLoginTest1() {
//		String actual = dao.userLogin("admin1", "Admin@123");
//		assertEquals("admin", actual);
//	}


}
