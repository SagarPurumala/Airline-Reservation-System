package com.jfsfeb.airlinereservationsystemspringboot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;
import com.jfsfeb.airlinereservationsystemspringboot.dao.FlightDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFlightDAO {

	@Autowired
	private FlightDAO flightDAO;

	@Test
	public void addFlightTest() {

		FlightDetails flightInformation = new FlightDetails();
		flightInformation.setFlightNumber("20001");
		flightInformation.setAirline("Indigo");
		flightInformation.setDepartureTime("11:30 AM");
		flightInformation.setArrivalTime("12:00 AM");
		flightInformation.setArrivalCity("Mumbai");
		flightInformation.setDepartureCity("Delhi");
		flightInformation.setBussinessClassFare(2000);
		flightInformation.setFirstClassSeats(2);
		flightInformation.setBussinessClassSeats(3);
		flightInformation.setFirstClassSeatFare(1500);
		flightInformation.setArrivalDate("12-05-2019");
		flightInformation.setDepartureDate("13-05-2019");

		assertEquals(true, flightDAO.addFlight(flightInformation));

	}

}
