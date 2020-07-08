package com.jfsfeb.airlinereservationsystemspringboot.response;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightBooking;

import lombok.Data;
@Data
public class BookingResponse {
	private int statusCode;
	private String message;
	private String description;
	private FlightBooking flightBooking;
	private List<FlightBooking> searchFlight;
	private List<FlightBooking> getAllBookingInfo;


}
