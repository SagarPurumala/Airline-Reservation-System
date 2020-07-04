package com.jfsfeb.airlinereservationsystemspringboot.dao;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserBean;

public interface UserDAO {
	
	public boolean registerUser(UserBean userBean);
	
	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);

}
