package com.jfsfeb.airlinereservationsystemspringboot.service;

import java.util.List;

import com.jfsfeb.airlinereservationsystemspringboot.beans.AirportBeans;

public interface AirportService {
	
	public boolean addAirport(AirportBeans airport);

	public boolean updateAirport(AirportBeans airport);

	public boolean deleteAirport(String abbreviation);

	public List<AirportBeans> getAllAirport();
	

	
}
