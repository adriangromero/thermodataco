package com.instaply.thermodataco.request;

import com.instaply.thermodataco.model.Temperature;

public class TemperatureRequest {
	
	private String user;
	private String zone;
	private Temperature temperature;
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	/**
	 * @return the temperature
	 */
	public Temperature getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
	

	
}
