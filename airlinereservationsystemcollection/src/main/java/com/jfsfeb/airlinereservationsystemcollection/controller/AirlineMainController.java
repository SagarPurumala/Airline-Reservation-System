
package com.jfsfeb.airlinereservationsystemcollection.controller;

import com.jfsfeb.airlinereservationsystemcollection.repository.AirlineRepository;

public class AirlineMainController {
	public static void main(String[] args) {
		
		AirlineRepository.addToDataBase();
		SubAirlineMain.airlineOperations();
	}
}
