package com.jfsfeb.airlinereservationsystemspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.airlinereservationsystemspringboot.beans.UserDetails;
import com.jfsfeb.airlinereservationsystemspringboot.response.AirlineResponse;
import com.jfsfeb.airlinereservationsystemspringboot.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserController {
	
	@Autowired
	private UserService service;
	
	AirlineResponse response = new AirlineResponse();
	
	@PostMapping("/registerUser")
	public AirlineResponse registerUser(@RequestBody UserDetails userBean) {
	
		boolean isAdded = service.registerUser(userBean);
		if(isAdded) {
			response.setStatus(200);
			response.setMessage("Data is added successfully..");
		} else {
			response.setStatus(400);
			response.setMessage("Failed to add the data..");
		}
		return response;
	}//end of register
	

	@PostMapping("/registerByAdmin")
	public AirlineResponse registerByAdmin(@RequestBody UserDetails userBean) {
		boolean isAdded = service.registerByAdmin(userBean);
		if(isAdded) {
			response.setStatus(200);
			response.setMessage("Data is added successfully..");
		} else {
			response.setStatus(400);
			response.setMessage("Failed to add the data..");
		}
		return response;
	}//end of register
	
	@PostMapping("/userLogin")
	public AirlineResponse userLogin(@RequestBody UserDetails userBean) {
		String userId = userBean.getUserId();
		String userPassword = userBean.getUserPassword();			
		UserDetails userBean2 = service.userLogin(userId, userPassword);
		String role = userBean2.getUserRole();
		String getUserId = userBean2.getUserId();
		if(role.equals("user")) {
			response.setStatus(200);
			response.setMessage("Success");
			response.setRole(role);
			response.setUserId(getUserId);
		}else if(role.equals("admin")) {
			response.setStatus(200);
			response.setMessage("Success");
			response.setRole(role);	
			response.setUserId(getUserId);
		}else {
			response.setStatus(400);
			response.setMessage("Failed");
		}
		return response;
	}// end of userLogin()
	
	

}// end of controller class
