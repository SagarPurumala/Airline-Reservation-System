package com.jfsfeb.airlinereservationsystemspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightBooking;
import com.jfsfeb.airlinereservationsystemspringboot.response.BookingResponse;
import com.jfsfeb.airlinereservationsystemspringboot.response.FlightResponse;
import com.jfsfeb.airlinereservationsystemspringboot.service.FlightService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class FlightBookingController {

	@Autowired
	private FlightService service;

	@SuppressWarnings("unused")
	@PostMapping("/bookFlight")
	public FlightResponse bookFlight(@RequestBody FlightBooking flightBooking) {

		FlightBooking bookinginfo = service.bookFlight(flightBooking);
		String bookingId = bookinginfo.getBookingId();
		double totalFare = bookinginfo.getTotalFare();

		FlightResponse response = new FlightResponse();
		if (bookinginfo != null) {
			response.setStatusCode(201);
			response.setMessage("Congratulations!Sir/Mam Flight booked successfully.");
			response.setDescription("Congratulations! Flight booked successfully. Your BookingId is " + bookingId);
			response.setBookingid(bookingId);
			response.setTotalFare(totalFare);
		} else {
			response.setStatusCode(401);
			response.setMessage("Oops! Flight booking failed.");
			response.setDescription(" Oops! Flight booked failed due to unavailability of seats.");
		}
		return response;
	}

	@GetMapping(path = "/getAllBooking/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)

	public BookingResponse getAllBookingInfo(@PathVariable("userId") String userId) {

		List<FlightBooking> allBookingInfo = service.getAllBooking(userId);
		BookingResponse response = new BookingResponse();
		if (allBookingInfo != null&&!allBookingInfo.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("All the flight booking information retrieved successfully.");
			response.setDescription("All the flight booking information retrieved successfully for userId : " + userId);
			response.setGetAllBookingInfo(allBookingInfo);
		} else {

			response.setStatusCode(401);
			response.setMessage("No booking found!");
			response.setDescription(" No booking found with UserId:" + userId);

		}
		return response;

	}// end of getAllBookingInfo()

	@DeleteMapping("/deleteBooking")
	public BookingResponse deleteBooking(String bookingId) {
		boolean isDeleted = service.deleteBooking(bookingId);
		BookingResponse response = new BookingResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage(
					"Congratulation! Flight booking cancelled successfully. We will refund your payment within 3 working days. ");
			response.setDescription(
					"Congratulation! Flight booking cancelled successfully. We will refund your payment within 3 working days ");
		} else {
			response.setStatusCode(401);
			response.setMessage("Oops! Flight booking can not be cancelled.");
			response.setDescription("Oops! Flight booking can not be cancelled.");

		}
		return response;
	}
}
