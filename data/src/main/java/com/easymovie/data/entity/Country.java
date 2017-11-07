package com.easymovie.data.entity;

import java.io.Serializable;

/**
 * @author Manas Grover
 *
 */
public enum Country implements Serializable{
	INDIA("IN"),
	UAE("AE"),
	USA("USA"),
	UNKNOWN("UNONOWN");

	private String countryCode;

	Country(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}
}