package com.instaply.thermodataco.service;

import java.util.List;

import com.instaply.thermodataco.model.Temperature;
import com.instaply.thermodataco.model.Zone;
import com.instaply.thermodataco.request.TemperatureRequest;

public abstract interface TemperatureService {
	
	/**
	 * Report a new temperature
	 * @param request
	 * @return temperature
	 */
	public Temperature createTemperature (TemperatureRequest request);
	
	/**
	 * Gets temperature historical data for a customer's zone
	 * @param customer
	 * @param zoneName
	 * @return zone
	 */
	public Zone getHistorical (String customer, String zoneName);
	
	/**
	 * List all zones
	 * @return zones
	 */
	public List<Zone> findAllZones ();

}
