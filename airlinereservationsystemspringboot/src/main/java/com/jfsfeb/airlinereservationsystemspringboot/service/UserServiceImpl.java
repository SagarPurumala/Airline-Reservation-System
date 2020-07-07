

package com.jfsfeb.airlinereservationsystemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserDetails;
import com.jfsfeb.airlinereservationsystemspringboot.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;

	@Override
	public boolean registerUser(UserDetails userBean) {
		
		return dao.registerUser(userBean);
	}

	@Override
	public UserDetails userLogin(String userId, String userPassword) {
	
		return dao.userLogin(userId, userPassword);
	}

	@Override
	public boolean registerByAdmin(UserDetails userBean) {
		
		return dao.registerByAdmin(userBean);
	}

}
