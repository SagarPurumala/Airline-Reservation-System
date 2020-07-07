package com.jfsfeb.airlinereservationsystemspringboot.dao;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserDetails;

public interface UserDAO {
	
	public boolean registerUser(UserDetails userBean);
	
	public UserDetails userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserDetails userBean);

}
