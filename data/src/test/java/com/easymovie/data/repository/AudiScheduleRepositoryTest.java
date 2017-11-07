/**
 * 
 */
package com.easymovie.data.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easymovie.data.entity.Audi;
import com.easymovie.data.entity.AudiSchedule;
import com.easymovie.data.entity.City;
import com.easymovie.data.entity.Country;
import com.easymovie.data.entity.Location;
import com.easymovie.data.entity.Movie;
import com.easymovie.data.entity.State;
import com.easymovie.data.entity.Theatre;
import com.easymovie.data.entity.TimeSlot;

/**
 * @author Manas Grover
 *
 */
public class AudiScheduleRepositoryTest extends BaseTest {
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	AudiRepository audiRepository;
	
	@Autowired
	TimeSlotRepository timeSlotRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	AudiScheduleRepository audiScheduleRepository;
	
	@Test
	public void testForNotNullAudiSchedule(){
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
		audi2=audiRepository.save(audi2);
		//Assert.assertNotNull(theatreRepository.findAll().get(0).getAudiList());
		
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setStartTime(new Long(1000));
		timeSlot.setEndTime(new Long(1200));
		timeSlot = timeSlotRepository.save(timeSlot);
		
		TimeSlot timeSlot2 = new TimeSlot();
		timeSlot.setStartTime(new Long(1100));
		timeSlot.setEndTime(new Long(1300));
		timeSlotRepository.save(timeSlot2);
		
		List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
		timeSlots.add(timeSlot);
		timeSlots.add(timeSlot2);
		
		Movie movie = new Movie();
		movie.setMovieName("RDB");
		movie.setDescription("Great");
		movieRepository.save(movie);
		
		AudiSchedule schedule = new AudiSchedule();
		schedule.setAudi(audi2);
		schedule.setStartDate(Long.valueOf("1509520256000"));
		schedule.setEndDate(Long.valueOf("1510729856000"));
		schedule.setTimeSlots(timeSlots);
		schedule.setMovie(movie);
		audiScheduleRepository.save(schedule);
		Assert.assertNotNull(audiScheduleRepository.findByDatesBetween(Long.valueOf("1510038656000")));
	}

}
