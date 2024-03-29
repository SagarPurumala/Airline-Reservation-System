package com.jfsfeb.airlinereservationsystemspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;
import com.jfsfeb.airlinereservationsystemspringboot.response.FlightResponse;
import com.jfsfeb.airlinereservationsystemspringboot.service.FlightService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class FlightController {
	@Autowired
	private FlightService service;

	@GetMapping("/getFlight")
	public FlightResponse getFlight(String flightNumber) {

		FlightDetails flightInformation = service.getFlight(flightNumber);
		FlightResponse response = new FlightResponse();
		if (flightInformation != null) {
			response.setStatusCode(210);
			response.setMessage("Success! Flight information retrived successfully.");
			response.setDescription("Flight information found successfully for the flightNo. : " + flightNumber);
			response.setFlightInformation(flightInformation);
		} else {

			response.setStatusCode(401);
			response.setMessage("Oops! Unable to retrived flight information.");
			response.setDescription(" Flight information not found for the Flight Number : " + flightNumber);

		}
		return response;

	}// end of getflight()

	@DeleteMapping("/deleteFlight")

	public FlightResponse deleteFlight(String flightNumber) {
		boolean isDeleted = service.deleteFlight(flightNumber);

		FlightResponse response = new FlightResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Congratulation! Flight information deleted successfully.");
			response.setDescription("Congratulation! Flight information deleted successfully.");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to delete flight. Check whether you have entered correct flight number ");

		}
		return response;
	}

	@PutMapping(path = "/updateFlight")
	public boolean updateFlight(@RequestBody FlightDetails flightInformation) {
		return service.updateFlight(flightInformation);
	}

	@PostMapping("/addFlight")
	public FlightResponse addFlight(@RequestBody FlightDetails flightInformation) {
		boolean isAdded = service.addFlight(flightInformation);

		FlightResponse response = new FlightResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Flight added sucessfully.");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add flight. Flight Number Already Exists. ");

		}
		return response;

	}

	@PostMapping("/searchFlight")
	public FlightResponse searchFlight(@RequestBody FlightDetails flightInformation) {
		String departureCity = flightInformation.getDepartureCity();
		String arrivalCity = flightInformation.getArrivalCity();
		
		List<FlightDetails> searchFlight = service.searchFlight(departureCity, arrivalCity);

		FlightResponse response = new FlightResponse();
		if (searchFlight != null && !searchFlight.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("List of flights ");
			response.setSearchFlight(searchFlight);
		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to fetch flights. No Flights found in this route .");
		}
		return response;

	}

	@GetMapping("/getAll")
	public FlightResponse getAllFlights() {

		List<FlightDetails> flightList = service.getAllFlights();

		FlightResponse response = new FlightResponse();
		if (flightList != null && !flightList.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("All Flights Found ");
			response.setSearchFlight(flightList);
		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to find any flights.");

		}
		return response;

	}

}// end of class
