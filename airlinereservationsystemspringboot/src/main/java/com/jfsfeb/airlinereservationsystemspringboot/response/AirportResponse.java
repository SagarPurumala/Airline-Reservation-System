package com.jfsfeb.airlinereservationsystemspringboot.response;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.AirportBeans;

import lombok.Data;
@Data
public class AirportResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<AirportBeans> searchAirport;
	

}
