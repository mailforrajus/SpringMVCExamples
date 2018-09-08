package com.nt.dto;

import java.io.Serializable;

public class PassengerDetailsDTO implements Serializable {
	private String name;
	private String sourcePlace;
	private String destPlace;
	private float fare;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestPlace() {
		return destPlace;
	}
	public void setDestPlace(String destPlace) {
		this.destPlace = destPlace;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	

}
