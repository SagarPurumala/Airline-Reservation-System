package com.capgemini.airlinereservationsystemjdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.jfsfeb.airlinereservationsystemjdbc.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystemjdbc.dao.AdminDAOJDBCImpl;
import com.jfsfeb.airlinereservationsystemjdbc.dto.FlightDetails;


public class AdminDAOTest {
    
	AdminDAO admin=new AdminDAOJDBCImpl();
	@Test
	public void addFlights() {
		FlightDetails flightDetails=new FlightDetails();
		flightDetails.setFlightId(2004);
		flightDetails.setFlightName("SpiceJet");
		flightDetails.setSource("Hyderabad");
		flightDetails.setDestination("Bangalore");
		flightDetails.setArrivalDate( LocalDate.of(2020,2,20));
		flightDetails.setArrivalTime(LocalTime.of(9,00));
		flightDetails.setDepartureDate(LocalDate.of(2020,2,20));
		flightDetails.setDepartureTime(LocalTime.of(11, 00));
		flightDetails.setNoofseatsavailable(23);
		boolean status = admin.addFlights(flightDetails);
		 assertEquals(true, status);
	}
}
