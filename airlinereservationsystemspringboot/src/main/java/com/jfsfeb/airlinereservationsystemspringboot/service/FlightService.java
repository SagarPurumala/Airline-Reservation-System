package com.jfsfeb.airlinereservationsystemspringboot.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightBooking;
import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightInformation;

public interface FlightService {

	public FlightInformation getFlight(String flightNumber);

	public boolean addFlight(FlightInformation flightInformation);

	public boolean updateFlight(FlightInformation flightInformation);

	public boolean deleteFlight(String flightNumber);

	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate);

	public List<FlightInformation> getAllFlights();

	public FlightBooking bookFlight(FlightBooking flightBooking);

	public List<FlightBooking> getAllBooking(String userId);
	
	public boolean deleteBooking(String bookingId);
}
