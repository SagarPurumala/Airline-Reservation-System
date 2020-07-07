package com.jfsfeb.airlinereservationsystemspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightBooking;
import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;
import com.jfsfeb.airlinereservationsystemspringboot.dao.BookingDAO;
import com.jfsfeb.airlinereservationsystemspringboot.dao.FlightDAO;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDAO flightdao;

	@Autowired
	private BookingDAO bookingDao;

	@Override
	public FlightDetails getFlight(String flightNumber) {
		return flightdao.getFlight(flightNumber);
	}

	@Override
	public boolean addFlight(FlightDetails flightInformation) {
		return flightdao.addFlight(flightInformation);
	}

	@Override
	public boolean updateFlight(FlightDetails flightInformation) {
		return flightdao.updateFlight(flightInformation);
	}

	@Override
	public boolean deleteFlight(String flightNumber) {
		return flightdao.deleteFlight(flightNumber);
	}

	@Override
	public List<FlightDetails> searchFlight(String departureCity, String arrivalCity) {

		return flightdao.searchFlight(departureCity, arrivalCity);
	}

	@Override
	public List<FlightDetails> getAllFlights() {
		return flightdao.getAllFlights();
	}

	@Override
	public FlightBooking bookFlight(FlightBooking flightBooking) {
		return bookingDao.bookFlight(flightBooking);
	}

	@Override
	public List<FlightBooking> getAllBooking(String userId) {
		return bookingDao.getAllBooking(userId);
	}

	@Override
	public boolean deleteBooking(String bookingId) {
		return bookingDao.deleteBooking(bookingId);
	}

}
