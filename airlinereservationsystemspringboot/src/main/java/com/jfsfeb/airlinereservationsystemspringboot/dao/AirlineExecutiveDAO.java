package com.jfsfeb.airlinereservationsystemspringboot.dao;

import com.jfsfeb.airlinereservationsystemspringboot.beans.AirlineExecutiveBeans;

public interface AirlineExecutiveDAO {

	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber);

}
