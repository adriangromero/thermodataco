package com.instaply.thermodataco.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instaply.thermodataco.model.Temperature;
import com.instaply.thermodataco.model.Zone;
import com.instaply.thermodataco.repository.ZoneRepository;
import com.instaply.thermodataco.request.TemperatureRequest;
import com.instaply.thermodataco.service.TemperatureService;

@Service
public class TemperatureServiceImpl implements TemperatureService{
	
	@Autowired
	ZoneRepository zoneRepository;
	
	@Override
	public Temperature createTemperature(TemperatureRequest request) {
		
		Temperature temperature = request.getTemperature();
		temperature.setDateTime(LocalDateTime.now()); // Setting current time
		
		// Get the proper zone to add the temperature
		Zone zone = zoneRepository.findZoneByCustomerAndName(request.getUser(), request.getZone());
		if (zone == null) {
			return null;
		}
		
		zone.getTemperatures().add(temperature);
		zoneRepository.save(zone);
		
		return temperature;
	}
	
	@Override
	public Zone getHistorical(String customer, String zoneName) {
		// Getting the historical data for the customer's zone
		Zone zone = zoneRepository.findZoneByCustomerAndName(customer, zoneName);
		return zone;
	}

	@Override
	public List<Zone> findAllZones() {
		// List all the zones. ADMIN
		return zoneRepository.findAll();
	}
	
}
