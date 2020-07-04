package com.jfsfeb.airlinereservationsystemspringboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.airlinereservationsystemspringboot.beans.AirlineExecutiveBeans;
import com.jfsfeb.airlinereservationsystemspringboot.dao.AirlineExecutiveDAO;

@Service
public class AirlineExecutiveServiceImpl implements AirlineExecutiveService {

	@Autowired
	private AirlineExecutiveDAO airlineDao;

	@Override
	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber) {

		return airlineDao.viewFlightOccupancy(flightNumber);
	}

}
