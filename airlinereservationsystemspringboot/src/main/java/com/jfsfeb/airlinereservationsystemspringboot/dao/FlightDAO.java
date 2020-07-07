package com.jfsfeb.airlinereservationsystemspringboot.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.AirportBeans;
import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;

public interface FlightDAO {

	public FlightDetails getFlight(String flightNumber);

	public boolean addFlight(FlightDetails flightInformation);

	public boolean updateFlight(FlightDetails flightInformation);

	public boolean deleteFlight(String flightNumber);

	public List<FlightDetails> searchFlight(String departureCity, String arrivalCity);
	
	public List<FlightDetails> getAllFlights();
	
	public List<AirportBeans> getAllAirport();
		
	}
