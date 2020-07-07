package com.jfsfeb.airlinereservationsystemspringboot.service;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserDetails;

public interface UserService {

	public boolean registerUser(UserDetails userBean);

	public UserDetails userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserDetails userBean);

}
