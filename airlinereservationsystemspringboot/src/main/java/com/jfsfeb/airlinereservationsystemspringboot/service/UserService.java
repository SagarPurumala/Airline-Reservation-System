package com.jfsfeb.airlinereservationsystemspringboot.service;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserBean;

public interface UserService {

	public boolean registerUser(UserBean userBean);

	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);

}
