package com.instaply.thermodataco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instaply.thermodataco.model.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Long>{
	
	/**
	 * Gets a zone given a customer and zonename
	 * @param customer
	 * @param zone
	 * @return
	 */
	@Query("SELECT z FROM Zone z WHERE z.customer = ?1 AND z.zone = ?2")
	Zone findZoneByCustomerAndName(String customer, String zone);
}
