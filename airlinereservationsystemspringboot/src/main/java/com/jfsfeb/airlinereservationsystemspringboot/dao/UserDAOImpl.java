package com.jfsfeb.airlinereservationsystemspringboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import javax.persistence.PersistenceUnit;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserDetails;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	//New user can registered themselves
	@Override
	public boolean registerUser(UserDetails userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		try {
			entityTransaction.begin();
			String role = "user";
			userBean.setUserRole(role);
			entityManager.persist(userBean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return false;
	}

	//Authentication of all type of users(customer,admin,executive)
	@Override
	public UserDetails userLogin(String userId, String userPassword) {
		
		try {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select u from UserDetails u where u.userId =:userId and u.userPassword =: password";
		TypedQuery<UserDetails> query = entityManager.createQuery(jpql, UserDetails.class);
		query.setParameter("userId", userId);
		query.setParameter("password", userPassword);
		UserDetails userBean=query.getSingleResult();
			return userBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// end of userLogin()

	//register the new admin or new executive only by the admin
	@Override
	public boolean registerByAdmin(UserDetails userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isRegistered = false;
		try {
			entityTransaction.begin();
			entityManager.persist(userBean);
			entityTransaction.commit();
			isRegistered=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isRegistered;
	}

}// end of class
