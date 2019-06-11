package com.instaply.thermodataco.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class ScaleTest {
	
	private Scale celsius = Scale.CELSIUS;
	private Scale fahrenheit = Scale.FAHRENHEIT;
	
	
	private Temperature temp1;
	private Temperature temp2;
	private Temperature temp3;
	private Temperature temp4;
	
    @Before
    public void init() {
    	temp1 = new Temperature(21, Scale.CELSIUS, LocalDateTime.now());
    	temp2 = new Temperature(69, Scale.FAHRENHEIT, LocalDateTime.now());
    	temp3 = new Temperature(21, Scale.CELSIUS, LocalDateTime.now());
    	temp4 = new Temperature(70, Scale.FAHRENHEIT, LocalDateTime.now());    	
    }
	
	@Test
	public void test_celsiusToFahrenheit() {
		celsius.celsiusToFahrenheit(temp1);
		assertEquals(temp2.getDegrees(), temp1.getDegrees());
		assertEquals(temp2.getScale(), temp1.getScale());
	}

	@Test
	public void test_FahrenheitToCelsius() {
		fahrenheit.FahrenheitToCelsius(temp4);
		assertEquals(temp3.getDegrees(), temp4.getDegrees());
		assertEquals(temp3.getScale(), temp4.getScale());
	}	

}
