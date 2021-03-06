package com.jfsfeb.airlinereservationsystemspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightBooking;
import com.jfsfeb.airlinereservationsystemspringboot.beans.FlightDetails;

@Repository
public class BookingDAOImpl implements BookingDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public FlightBooking bookFlight(FlightBooking flightBooking) {

		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		//boolean isAdded = false;
		tx.begin();
		
		FlightDetails flightInfo = manager.find(FlightDetails.class, flightBooking.getFlightNo());
		
		int bussinessClassSeats = flightInfo.getBussinessClassSeats();
		int firstClassSeats = flightInfo.getFirstClassSeats();
		double bussinessClassFare = flightInfo.getBussinessClassFare();
		double firstClassSeatFare = flightInfo.getFirstClassSeatFare();
		int passengers = flightBooking.getPassengers();

		String bookingId = GenerateBookingId.generateBookingId(10);
		String classType = flightBooking.getClassType();

		if (classType.equals("Bussiness") && passengers > 0 && passengers <= bussinessClassSeats) {

			double totalFare = passengers * bussinessClassFare;
			flightBooking.setTotalFare(totalFare);
			bussinessClassSeats = bussinessClassSeats - passengers;
			flightInfo.setBussinessClassSeats(bussinessClassSeats);
			flightBooking.setPassengers(passengers);
			flightBooking.setBookingId(bookingId);
			try {
				manager.persist(flightBooking);
				//isAdded = true;
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (classType.equals("First Class") && passengers > 0 && passengers <= firstClassSeats) {

			double totalFare = passengers * firstClassSeatFare;
			flightBooking.setTotalFare(totalFare);
			firstClassSeats = firstClassSeats - passengers;
			flightInfo.setFirstClassSeats(firstClassSeats);
			flightBooking.setPassengers(passengers);
			flightBooking.setBookingId(bookingId);
			try {
				manager.persist(flightBooking);
				//isAdded = true;
				tx.commit();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			// return isAdded;

		}
		FlightBooking getFlight = manager.find(FlightBooking.class, bookingId);

		return getFlight;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<FlightBooking> getAllBooking(String userId) {
		EntityManager manager = emf.createEntityManager();

		String jpql = "from FlightBooking where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);

		List<FlightBooking> getAllBooking = null;
		try {
			getAllBooking = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return getAllBooking;
	}

	@Override
	public boolean deleteBooking(String bookingId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ars");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		FlightDetails flightInfo = new FlightDetails();
		FlightBooking flightBooked = new FlightBooking();
		flightBooked = entityManager.find(FlightBooking.class, bookingId);
		String flightNo = flightBooked.getFlightNo();
		int passenger1 = flightBooked.getPassengers();
		String classType1 = flightBooked.getClassType();

		

		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			FlightBooking flightBooking = entityManager.find(FlightBooking.class, bookingId);
			entityManager.remove(flightBooking);

			isDeleted = true;
			if (isDeleted) {
				flightInfo = entityManager.find(FlightDetails.class, flightNo);
				int firstClass = flightInfo.getFirstClassSeats();
				
				int bussiness = flightInfo.getBussinessClassSeats();
				
				if (classType1.equalsIgnoreCase("Bussiness")) {
					bussiness = bussiness + passenger1;
					
					flightInfo.setBussinessClassSeats(bussiness);
				} else if (classType1.equalsIgnoreCase("First Class")) {
					firstClass = firstClass + passenger1;
					
					flightInfo.setFirstClassSeats(firstClass);
				} else {
					return false;
				}
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isDeleted;
	}

}
