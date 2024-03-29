package com.jfsfeb.airlinereservationsystemspringboot.dao;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightBooking;

public interface BookingDAO {

	public FlightBooking bookFlight(FlightBooking flightBooking);

	public List<FlightBooking> getAllBooking(String userId);
	
	public boolean deleteBooking(String bookingId);
}
