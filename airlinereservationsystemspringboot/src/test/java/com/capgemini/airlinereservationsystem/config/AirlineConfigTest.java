package com.capgemini.airlinereservationsystem.config;

import org.springframework.context.annotation.Configuration;

import com.jfsfeb.airlinereservationsystemspringboot.dao.FlightDAO;
import com.jfsfeb.airlinereservationsystemspringboot.dao.FlightDAOJpaImpl;
import com.jfsfeb.airlinereservationsystemspringboot.dao.UserDAO;
import com.jfsfeb.airlinereservationsystemspringboot.dao.UserDAOImpl;

@Configuration
public class AirlineConfigTest {
	
	//@Bean("FlightDAO")
	public FlightDAO getFlightDAO() {
		
		return new FlightDAOJpaImpl();
		
	}
	
	public UserDAO registerUser() {
		return new UserDAOImpl();
	}

}
