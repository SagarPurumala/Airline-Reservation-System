package com.jfsfeb.airlinereservationsystemspringboot.response;

import lombok.Data;

@Data
public class AirlineResponse {

	private int status;
	private String message;
	private String role;
	private String userId;
	


}
