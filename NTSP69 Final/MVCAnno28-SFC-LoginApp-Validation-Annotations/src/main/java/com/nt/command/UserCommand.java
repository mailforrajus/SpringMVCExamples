package com.nt.command;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCommand {
	
	@NotEmpty(message="username is required")
	private String username;
	@NotEmpty(message="password is required")
	private String password;
	private String[] countries,hobies;
	private Date dor;
	
	public UserCommand() {
		System.out.println("UserCommand:0-param constructor");
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getCountries() {
		return countries;
	}

	public void setCountries(String[] countries) {
		this.countries = countries;
	}

	public String[] getHobies() {
		return hobies;
	}

	public void setHobies(String[] hobies) {
		this.hobies = hobies;
	}

	public Date getDor() {
		return dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}

	@Override
	public String toString() {
		return "UserCommand [username=" + username + ", password=" + password + ", countries="
				+ Arrays.toString(countries) + ", hobies=" + Arrays.toString(hobies) + ", dor=" + dor + "]";
	}

	
	
}
