package com.instaply.thermodataco.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Temperature implements Comparable<Temperature>{
	
	@Id
	@GeneratedValue
	private Long id;
	private	Integer degrees;
	private Scale scale;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;
	
	/**
	 * Default constructor
	 */
	public Temperature (){}
	
	/**
	 * Custom constructor
	 * @param degrees
	 * @param scale
	 * @param dateTime
	 */
	public Temperature(Integer degrees, Scale scale, LocalDateTime dateTime) {
		this.degrees = degrees;
		this.scale = scale;
		this.dateTime = dateTime;
	}

	/**
	 * @return the degrees
	 */
	public Integer getDegrees() {
		return degrees;
	}

	/**
	 * @param degrees the degrees to set
	 */
	public void setDegrees(Integer degrees) {
		this.degrees = degrees;
	}

	/**
	 * @return the scale
	 */
	public Scale getScale() {
		return scale;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(Scale scale) {
		this.scale = scale;
	}

	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public int compareTo(Temperature o) {
		if (this.getDateTime().isBefore(o.getDateTime())) {
			return -1;
		} else if (this.getDateTime().isAfter(o.getDateTime())) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
