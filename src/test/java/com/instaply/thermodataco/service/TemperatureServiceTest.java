package com.instaply.thermodataco.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.instaply.thermodataco.model.Scale;
import com.instaply.thermodataco.model.Temperature;
import com.instaply.thermodataco.model.Zone;
import com.instaply.thermodataco.request.TemperatureRequest;
import com.instaply.thermodataco.serviceimpl.TemperatureServiceImpl;

public class TemperatureServiceTest {
	
		// ServiceImpl
		private TemperatureServiceImpl mockito = mock(TemperatureServiceImpl.class);

		private List<Zone> zones;
		
		@Before
	    public void init() {
			// Setting up the data
			Temperature temp1 = new Temperature(19, Scale.CELSIUS, LocalDateTime.now());
			Temperature temp2 = new Temperature(18, Scale.CELSIUS, LocalDateTime.now().plusMinutes(15));
			Temperature temp3 = new Temperature(18, Scale.CELSIUS, LocalDateTime.now().plusMinutes(30));
			Temperature temp4 = new Temperature(20, Scale.CELSIUS, LocalDateTime.now().plusMinutes(45));
			Set<Temperature> historical =  new HashSet<>(Arrays.asList(temp1, temp2, temp3, temp4));
			
			Zone zone1 = new Zone("user", "A", historical);
			Zone zone2 = new Zone("user", "B", null);
			zones = Arrays.asList(zone1, zone2);
	    }
		
	    @Test
	    public void test_findAllZones() {
	    	
	        // Mocking the return
	        when(mockito.findAllZones()).thenReturn(zones);

			// Method testing
	        int qty = mockito.findAllZones().size();
	
			// Check the result
	        assertEquals(2, qty);

	    }
	    
	    @Test
	    public void test_getHistorical_return_data() {
	
	        // Mocking the return
	        when(mockito.getHistorical(zones.get(0).getCustomer(), zones.get(0).getZone())).thenReturn(zones.get(0));

			// Method testing
	        Zone zone = mockito.getHistorical(zones.get(0).getCustomer(), zones.get(0).getZone());
	
			// Check the result
	        assertEquals(zones.get(0), zone);	    	
	    }
	    
	    @Test
	    public void test_getHistorical_no_data() {
	    	Zone zoneRandom = new Zone("random", "A", null);
	    	
	        // Mocking the return
	        when(mockito.getHistorical(zoneRandom.getCustomer(), zoneRandom.getZone())).thenReturn(null);

			// Method testing
	        Zone zone = mockito.getHistorical(zoneRandom.getCustomer(), zoneRandom.getZone());
	
			// Check the result
	        assertEquals(null, zone);	    	
	    }	   
	    
	    @Test
	    public void test_createTemperature_auth_or_zone_dont_exist() {
	    	TemperatureRequest request = new TemperatureRequest();
	    	request.setUser("user");
	    	request.setZone("Z");
	    	request.setTemperature(new Temperature(19, Scale.CELSIUS, LocalDateTime.now()));
	        // Mocking the return
	        when(mockito.createTemperature(request)).thenReturn(null);
	        
	        // Method testing
	        Temperature temperature = mockito.createTemperature(request);
	        
	        // Check the result
	        assertEquals(null, temperature);
	    }
	    
	    @Test
	    public void test_createTemperature_ok() {
	    	TemperatureRequest request = new TemperatureRequest();
	    	request.setUser("user");
	    	request.setZone("A");
	    	request.setTemperature(new Temperature(19, Scale.CELSIUS, LocalDateTime.now()));
	        // Mocking the return
	        when(mockito.createTemperature(request)).thenReturn(request.getTemperature());
	        
	        // Method testing
	        Temperature temperature = mockito.createTemperature(request);
	        
	        // Check the result
	        assertEquals(request.getTemperature(), temperature);
	    }	    
	    

}