/**
 * 
 */
package com.easymovie.data.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easymovie.data.entity.City;
import com.easymovie.data.entity.Country;
import com.easymovie.data.entity.Location;
import com.easymovie.data.entity.State;

/**
 * @author Manas Grover
 *
 */
public class LocationRepositoryTest extends BaseTest{

	@Autowired
	LocationRepository locationRepository;
	
	
	@Test
	public void testForNotNullLocation(){
		
		Location location = new Location();
		location.setPinCode(new Long("110027"));
		location.setCountry(Country.INDIA);
		location.setState(State.DELHI);
		location.setCity(City.NEW_DELHI);
		locationRepository.save(location);
		Assert.assertNotNull(locationRepository.findAll());
	}
}
