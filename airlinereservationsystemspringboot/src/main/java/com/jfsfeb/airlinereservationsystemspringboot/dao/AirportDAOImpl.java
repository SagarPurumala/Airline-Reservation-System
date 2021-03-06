
package com.jfsfeb.airlinereservationsystemspringboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.jfsfeb.airlinereservationsystemspringboot.beans.AirportBeans;


@Repository
public class AirportDAOImpl implements AirportDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addAirport(AirportBeans airport) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			manager.persist(airport);
			tx.commit();				
			return true;	

		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return false;
	}

	@Override

	public boolean updateAirport(AirportBeans airport) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		boolean isUpdated = false;
		try {
			tx.begin();
			AirportBeans airportInfo = manager.find(AirportBeans.class, airport.getAbbreviation());

			if (airportInfo != null) {
				if (airport.getCity() != null) {

					airportInfo .setAbbreviation(airport.getAbbreviation());
					airportInfo.setAirportName(airport.getAirportName());
					airportInfo.setCity(airport.getCity());
					airportInfo.setState(airport.getState());
					airportInfo.setZipCode(airport.getZipCode());

					manager.persist(airportInfo);
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
	public boolean deleteAirport(String abbreviation) {
		EntityManager entityManager = emf.createEntityManager();
		AirportBeans airportInformation = entityManager.find(AirportBeans.class, abbreviation);
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(airportInformation);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}
}
