package com.jfsfeb.airlinereservationsystemspringboot.beans;

import javax.persistence.*;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity
@Table(name = "airport")
public class AirportBeans {
	@Id
	@Column(name = "abbr", unique = true)
	private String abbreviation;

	@Column
	private String airportName;

	@Column
	private String state;

	@Column
	private String city;

	@Column
	@Positive
	private int zipCode;

	

}
