package com.instaply.thermodataco.request;

import org.springframework.security.core.Authentication;

import com.instaply.thermodataco.model.Temperature;

public class TemperatureRequest {
	
	private Authentication authentication;
	private String zone;
	private Temperature temperature;
	
	/**
	 * @return the authentication
	 */
	public Authentication getAuthentication() {
		return authentication;
	}
	/**
	 * @param authentication the authentication to set
	 */
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
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
