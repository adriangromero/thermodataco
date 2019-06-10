package com.instaply.thermodataco.error;

public class ZoneNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZoneNotFoundException(String name) {
    	super("Zone name not found: " + name);
    }
}
