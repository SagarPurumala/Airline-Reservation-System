package com.jfsfeb.airlinereservationsystemspringboot.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightBooking;
import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;

public interface FlightService {

	public FlightDetails getFlight(String flightNumber);

	public boolean addFlight(FlightDetails flightInformation);

	public boolean updateFlight(FlightDetails flightInformation);

	public boolean deleteFlight(String flightNumber);

	public List<FlightDetails> searchFlight(String departureCity, String arrivalCity);

	public List<FlightDetails> getAllFlights();

	public FlightBooking bookFlight(FlightBooking flightBooking);

	public List<FlightBooking> getAllBooking(String userId);
	
	public boolean deleteBooking(String bookingId);
}
