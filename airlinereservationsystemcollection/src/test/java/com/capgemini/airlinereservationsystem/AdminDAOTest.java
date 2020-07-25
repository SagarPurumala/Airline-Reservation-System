package com.capgemini.airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jfsfeb.airlinereservationsystemcollection.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemcollection.dao.AdminDAOImple;
import com.jfsfeb.airlinereservationsystemcollection.dto.AdminInfo;


public class AdminDAOTest {
	AdminDAO dao=new AdminDAOImple();
	@Test
	public void registerAdmin() {
		AdminInfo admin=new AdminInfo();
		admin.setId(2002);
		admin.setName("Kanna");
		admin.setMobileNo(9876542013l);
		admin.setEmailId("Kanna@gmail.com");
		admin.setPassword("Kanna@12");
		boolean exepected=dao.registerAdmin(admin);
		assertEquals(true, exepected);
		
	}

}
