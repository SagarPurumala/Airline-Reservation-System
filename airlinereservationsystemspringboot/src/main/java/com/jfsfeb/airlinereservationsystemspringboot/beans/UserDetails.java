package com.jfsfeb.airlinereservationsystemspringboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
@Entity
@Table(name = "user_Info")
public class UserDetails {

	@Column(name = "first_name")
	@Pattern(regexp = "[A-Za-z]*")
	private String userFirstName;

	@Column(name = "last_name")
	@Pattern(regexp = "[A-Za-z]*")
	private String userLastName;

	@Column(name = "email")
	@Email(message = "Entered email id format is not valid.")
	private String userEmail;

	@Column(name = "contact", unique = true)
	@Positive
	//@Size(min = 10, max = 10, message = "Entered mobile number must contain 10 digits.")
	//@Pattern(regexp = "[6-9]{1}[0-9]{9}*")
	private long userContact;

	@Id
	@Column(name = "user_Id")
	@Pattern(regexp = "[A-Za-z0-9]*")
	@Size(min = 6, message = "Entered userId must contain minimum of 6 characters.")
	private String userId;

	@Column(name = "user_Password")
	//@Size(min = 8, max = 15, message = "Entered password must be 8-15 characters.")
	//@Pattern(regexp = ("//w+"))	
	/*
	 * (?=.*[a-z]) : This matches the presence of at least one lowercase letter.
	 * (?=.*d) : This matches the presence of at least one digit i.e. 0-9.
	 * (?=.*[@#$%]) : This matches the presence of at least one special character.
	 * ((?=.*[A-Z]) : This matches the presence of at least one capital letter.
	 * {6,16} : This limits the length of password from minimum 6 letters to maximum
	 * 16 letters.
	 */
	private String userPassword;

	@Column(name = "role")
	@Pattern(regexp = "[A-Za-z]*")
	private String userRole;


}
