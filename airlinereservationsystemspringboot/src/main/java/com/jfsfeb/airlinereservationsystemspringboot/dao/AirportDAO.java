package com.jfsfeb.airlinereservationsystemspringboot.dao;


import com.jfsfeb.airlinereservationsystemspringboot.beans.AirportBeans;

public interface AirportDAO {

	public boolean addAirport(AirportBeans airport);

	public boolean updateAirport(AirportBeans airport);

	public boolean deleteAirport(String abbreviation);

}
