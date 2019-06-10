package com.instaply.thermodataco.model;

public enum Scale {

	CELSIUS,
	FAHRENHEIT;

	/**
	 * Converts temperature from Celsius to Fahrenheit
	 * @param temperature
	 */
	public void celsiusToFahrenheit(Temperature temperature) {
		if(temperature != null && temperature.getScale() != null 
				&& temperature.getScale().equals(CELSIUS)) {
			// formula = (C * 9 / 5) + 32
			int degrees = (temperature.getDegrees() * (9 / 5)) + 32;
			temperature.setDegrees(degrees);
			temperature.setScale(FAHRENHEIT);
		}
	}

	/**
	 * Converts temperature from Fahrenheit to Celsius
	 * @param temperature
	 */
	public void FahrenheitToCelsius(Temperature temperature) {
		if(temperature != null && temperature.getScale() != null 
				&& temperature.getScale().equals(FAHRENHEIT)) {
			// formula = (F − 32) * 5 / 9
			int degrees = (temperature.getDegrees() - 32) * (9 / 5);
			temperature.setDegrees(degrees);
			temperature.setScale(CELSIUS);
		}
	}		
}
