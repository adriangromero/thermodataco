package com.instaply.thermodataco.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Zone {

	@Id
	@GeneratedValue
	private Long id;
	private String customer;
	private String zone;
	@OneToMany(cascade = CascadeType.ALL)
	@OrderBy("dateTime DESC")
	private Set<Temperature> temperatures;
	
	/**
	 * Default constructor
	 */
	public Zone(){}

	/**
	 * Custom constructor
	 * @param customer
	 * @param zone
	 * @param temperatures
	 */
	public Zone(String customer, String zone, Set<Temperature> temperatures) {
		this.customer = customer;
		this.zone = zone;
		this.temperatures = temperatures;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
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
	 * @return the temperatures
	 */
	public Set<Temperature> getTemperatures() {
		return temperatures;
	}

	/**
	 * @param temperatures the temperatures to set
	 */
	public void setTemperatures(Set<Temperature> temperatures) {
		this.temperatures = temperatures;
	}	

}
