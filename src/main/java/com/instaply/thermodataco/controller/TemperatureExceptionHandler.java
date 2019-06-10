package com.instaply.thermodataco.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.instaply.thermodataco.error.ZoneNotFoundException;
import com.instaply.thermodataco.error.ZoneOrCustomerNotFoundException;

@ControllerAdvice
public class TemperatureExceptionHandler {


	
	@ExceptionHandler(ZoneNotFoundException.class)
	public void handleZoneNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(ZoneOrCustomerNotFoundException.class)
	public void handleZoneOrCustomeNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}


}
