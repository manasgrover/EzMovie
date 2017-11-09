/**
 * 
 */
package com.easymovie.core.service;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easymovie.data.entity.Audi;
import com.easymovie.data.entity.Availabilty;
import com.easymovie.data.entity.City;
import com.easymovie.data.entity.Country;
import com.easymovie.data.entity.Location;
import com.easymovie.data.entity.State;
import com.easymovie.data.entity.Theatre;
import com.easymovie.data.entity.TimeSlot;
import com.easymovie.data.repository.AudiRepository;
import com.easymovie.data.repository.AvailabiltyRepository;
import com.easymovie.data.repository.TheatreRepository;
import com.easymovie.data.repository.TimeSlotRepository;

/**
 * @author Manas Grover
 *
 */
public class AvailabilityServiceTest extends BaseTest{
	
	@Autowired
	AvailabiltyService availabiltyService;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	AudiRepository audiRepository;
	
	@Autowired
	TimeSlotRepository timeSlotRepository;
	
	@Autowired
	AvailabiltyRepository availabiltyRepository;
	
	@Test
	public void checkAvailabilityByMovieName(){
		

		Theatre theatre = new Theatre();
		theatre.setName("PVR");
		
		Location location = new Location();
		location.setPinCode(new Long("110027"));
		location.setCountry(Country.INDIA);
		location.setState(State.DELHI);
		location.setCity(City.NEW_DELHI);
		
		Audi audi= new Audi();
		audi.setAudiNumber(1);
		audi.setNumberOfSeats(60);
		
		Audi audi2= new Audi();
		audi2.setAudiNumber(2);
		audi2.setNumberOfSeats(50);
		
		
		ArrayList<Audi> audiList = new ArrayList<Audi>();
		audiList.add(audi);
		audiList.add(audi2);

		theatre.setAudiList(audiList);
		theatre.setLocation(location);
		theatreRepository.save(theatre);
		audi.setTheatre(theatre);
		audi2.setTheatre(theatre);
		audiRepository.save(audi);
		audiRepository.save(audi2);
		Assert.assertNotNull(theatreRepository.findAll().get(0).getAudiList());
		
		
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setStartTime((new Date()).getTime());
		timeSlot.setEndTime((new Date()).getTime());
		timeSlotRepository.save(timeSlot);
		
		Availabilty availabilty = new Availabilty();
		availabilty.setAudi(audi2);
		availabilty.setAvailable(true);
		availabilty.setTimeSlot(timeSlot);
		availabilty.setSeatNumber(1);
		
		availabiltyRepository.save(availabilty);
		availabiltyRepository.findAll();
	}

}
