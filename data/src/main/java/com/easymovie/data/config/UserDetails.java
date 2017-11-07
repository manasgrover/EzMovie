package com.easymovie.data.config;

import java.io.Serializable;

/**
 * @author Manas Grover
 *
 */
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2842068226981084860L;
	private String user;

	public UserDetails() {
		this.user = "SYSTEM";
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
