package com.instaply.thermodataco.error;

public class ZoneOrCustomerNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZoneOrCustomerNotFoundException(String zone, String customer) {
    	super("Zone or Customer not found: " + zone + ", " + customer);
    }
}
