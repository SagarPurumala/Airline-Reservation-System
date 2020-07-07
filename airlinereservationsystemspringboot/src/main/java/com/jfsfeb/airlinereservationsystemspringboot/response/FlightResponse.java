package com.jfsfeb.airlinereservationsystemspringboot.response;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;

public class FlightResponse {
	private int statusCode;
	private String message;
	private String description;
	private String bookingid;
	private double totalFare;
	private FlightDetails flightInformation;
	private List<FlightDetails> searchFlight;

	
	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FlightDetails getFlightInformation() {
		return flightInformation;
	}

	public void setFlightInformation(FlightDetails flightInformation) {
		this.flightInformation = flightInformation;
	}

	public List<FlightDetails> getSearchFlight() {
		return searchFlight;
	}

	public void setSearchFlight(List<FlightDetails> searchFlight) {
		this.searchFlight = searchFlight;
	}

}
