package com.jfsfeb.airlinereservationsystemspringboot.response;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;

import lombok.Data;
@Data
public class FlightResponse {
	private int statusCode;
	private String message;
	private String description;
	private String bookingid;
	private double totalFare;
	private FlightDetails flightInformation;
	private List<FlightDetails> searchFlight;

}
