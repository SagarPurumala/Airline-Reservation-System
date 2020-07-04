

package com.jfsfeb.airlinereservationsystemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserBean;
import com.jfsfeb.airlinereservationsystemspringboot.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;

	@Override
	public boolean registerUser(UserBean userBean) {
		
		return dao.registerUser(userBean);
	}

	@Override
	public UserBean userLogin(String userId, String userPassword) {
	
		return dao.userLogin(userId, userPassword);
	}

	@Override
	public boolean registerByAdmin(UserBean userBean) {
		
		return dao.registerByAdmin(userBean);
	}

}
