package com.instaply.thermodataco.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.instaply.thermodataco.error.ZoneNotFoundException;
import com.instaply.thermodataco.error.ZoneOrCustomerNotFoundException;
import com.instaply.thermodataco.model.Temperature;
import com.instaply.thermodataco.model.Zone;
import com.instaply.thermodataco.request.TemperatureRequest;
import com.instaply.thermodataco.service.TemperatureService;

@RestController
public class TemperatureController {
	
	private static final Logger logger = LoggerFactory.getLogger(TemperatureController.class);

	@Autowired
	TemperatureService temperatureService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/status")
	public String checkStatus () {
		logger.debug("checkStatus ini");
		return "API REST is UP! @ localhost:8080/";
	}	
		
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/zones")
	public List<Zone> findAllZones () {
		logger.debug("findAllZones ini");
		return temperatureService.findAllZones();
	}	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/historicals")
	public Zone getHistorical (@RequestParam String zone, Authentication auth) {
		logger.debug("getHistorical ini");
		Zone response = temperatureService.getHistorical(auth.getName(), zone);
		if(response == null) {
			logger.error("getHistorical Error: ZoneNotFoundException");
			throw new ZoneNotFoundException(zone);
		}
		return response;
	}		
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/temperatures", consumes = "application/json", produces = "application/json")
	public Temperature createTemperature (@RequestBody TemperatureRequest request, Authentication auth) {
		logger.debug("createTemperature ini");
		request.setUser(auth.getName());
		Temperature response = temperatureService.createTemperature(request);
		if(response == null) {
			logger.error("getHistorical Error: ZoneOrCustomerNotFoundException");
			throw new ZoneOrCustomerNotFoundException(request.getZone(), auth.getName());
		}
		return response;
	}
		
}
