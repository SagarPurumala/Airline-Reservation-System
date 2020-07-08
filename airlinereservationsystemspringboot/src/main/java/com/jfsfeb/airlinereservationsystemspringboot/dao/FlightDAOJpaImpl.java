package com.jfsfeb.airlinereservationsystemspringboot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jfsfeb.airlinereservationsystemspringboot.beans.AirportBeans;
import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;

@Repository
public class FlightDAOJpaImpl implements FlightDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;
	List<AirportBeans> airportList = new ArrayList<AirportBeans>();

	@Override
	public FlightDetails getFlight(String flightNumber) {
		EntityManager manager = emf.createEntityManager();
		FlightDetails flightInformation = manager.find(FlightDetails.class, flightNumber);
		manager.close();
		return flightInformation;
	}

	@Override
	public boolean addFlight(FlightDetails flightInformation) {

		getAllAirport();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		String departureCity = flightInformation.getDepartureCity();
		String arrivalCity = flightInformation.getArrivalCity();

		boolean isAdded = false;
		try {
			tx.begin();
			if (airportList != null) {
				for (AirportBeans airportBeans : airportList) {
					if (departureCity.equalsIgnoreCase(airportBeans.getCity())) {
						for (AirportBeans airportBeans1 : airportList) {
							if (arrivalCity.equalsIgnoreCase(airportBeans1.getCity())) {
								manager.persist(flightInformation);
								isAdded = true;
							} else {
								continue;
							}
						}
					} else {
						continue;
					}
				}
			} else {
				return false;
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;
	}

	@Override
	public boolean updateFlight(FlightDetails flightInformation) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		boolean isUpdated = false;
		try {
			tx.begin();
			FlightDetails flightInfo = manager.find(FlightDetails.class, flightInformation.getFlightNumber());

			if (flightInfo != null) {
				if (flightInformation.getDepartureDate() != null && flightInformation.getDepartureTime() != null) {
					System.out.println(flightInformation.getAirline());
					flightInfo.setDepartureDate(flightInformation.getDepartureDate());
					flightInfo.setDepartureTime(flightInformation.getDepartureTime());
					flightInfo.setAirline(flightInformation.getAirline());
					flightInfo.setArrivalCity(flightInformation.getArrivalCity());
					flightInfo.setDepartureCity(flightInformation.getDepartureCity());
					flightInfo.setBussinessClassFare(flightInformation.getBussinessClassFare());
					flightInfo.setBussinessClassSeats(flightInformation.getBussinessClassSeats());
					flightInfo.setFirstClassSeatFare(flightInformation.getFirstClassSeatFare());
					flightInfo.setFirstClassSeats(flightInformation.getFirstClassSeats());
					flightInfo.setArrivalDate(flightInformation.getArrivalDate());
					flightInfo.setArrivalTime(flightInformation.getArrivalTime());
					
					manager.persist(flightInfo);
					isUpdated = true;
					tx.commit();
					
				}
			} else {

				isUpdated = false;
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		manager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteFlight(String flightNumber) {
		EntityManager entityManager = emf.createEntityManager();
		FlightDetails flightInformation = entityManager.find(FlightDetails.class, flightNumber);
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(flightInformation);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}

	// Search Flight details...
	@SuppressWarnings("unchecked")
	@Override
	public List<FlightDetails> searchFlight(String departureCity, String arrivalCity) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from FlightDetails where departureCity = :departure and arrivalCity = :arrival";
		Query query = manager.createQuery(jpql);
		query.setParameter("departure", departureCity);
		query.setParameter("arrival", arrivalCity);
		
		List<FlightDetails> flightList = null;
		try {
			flightList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flightList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FlightDetails> getAllFlights() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from FlightDetails";
		Query query = manager.createQuery(jpql);

		List<FlightDetails> flightList = null;
		try {
			flightList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flightList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AirportBeans> getAllAirport() {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery("FROM AirportBeans");
		airportList = query.getResultList();

		return airportList;
	}

}
