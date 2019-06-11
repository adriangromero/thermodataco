package com.instaply.thermodataco;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.instaply.thermodataco.model.Scale;
import com.instaply.thermodataco.model.Temperature;
import com.instaply.thermodataco.model.Zone;
import com.instaply.thermodataco.repository.ZoneRepository;

@SpringBootApplication
public class ThermodatacoApplication {

	/**
	 * Starts the Spring App
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ThermodatacoApplication.class, args);
	}

	/**
	 * Setup the initial data model
	 * @param zoneRepository
	 * @return
	 */
    @Bean
    CommandLineRunner initDatabase(ZoneRepository zoneRepository) {
        return args -> {
        	
        	// Zones for a customer 
        	Zone zone1 = new Zone("user", "A", null);
        	Zone zone2 = new Zone("user", "B", null);
        	
        	// Temperature historical data
        	Temperature temp1 = new Temperature(19, Scale.CELSIUS, LocalDateTime.now());
        	Temperature temp2 = new Temperature(18, Scale.CELSIUS, LocalDateTime.now().plusMinutes(15));
        	Temperature temp3 = new Temperature(18, Scale.CELSIUS, LocalDateTime.now().plusMinutes(30));
        	Temperature temp4 = new Temperature(20, Scale.CELSIUS, LocalDateTime.now().plusMinutes(45));
        	
        	Set<Temperature> historical =  new HashSet<>();
        	
        	historical.add(temp1);
        	historical.add(temp2);
        	historical.add(temp3);
        	historical.add(temp4);
        	
        	zone1.setTemperatures(historical);
        	
        	// Persist data model
        	zoneRepository.saveAll(Arrays.asList(zone1, zone2));    

        };
    }	
	
}
