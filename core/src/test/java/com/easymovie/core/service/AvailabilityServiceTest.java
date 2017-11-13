/**
 * 
 */
package com.easymovie.core.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.core.util.datetime.FixedDateFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easymovie.data.entity.Audi;
import com.easymovie.data.entity.AudiSchedule;
import com.easymovie.data.entity.Availabilty;
import com.easymovie.data.entity.City;
import com.easymovie.data.entity.Country;
import com.easymovie.data.entity.Location;
import com.easymovie.data.entity.Movie;
import com.easymovie.data.entity.State;
import com.easymovie.data.entity.Theatre;
import com.easymovie.data.entity.TimeSlot;
import com.easymovie.data.repository.AudiRepository;
import com.easymovie.data.repository.AudiScheduleRepository;
import com.easymovie.data.repository.AvailabiltyRepository;
import com.easymovie.data.repository.MovieRepository;
import com.easymovie.data.repository.TheatreRepository;
import com.easymovie.data.repository.TimeSlotRepository;
import com.easymovie.domain.request.AvailabiltyRequest;
import com.easymovie.domain.request.AvailabiltyRequestTypeEnum;
import com.easymovie.domain.request.SlotAvailaibilityRequest;
import com.easymovie.core.service.BaseTest;

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
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	AudiScheduleRepository audiScheduleRepository;
	
	@Before
	public void prepareData() throws ParseException{/*

		
		
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = (Date)dt.parse("11/01/2017");
		Date endDate = (Date)dt.parse("11/15/2017");
		
		Date currentDate =(Date)dt.parse("11/10/2017"); 

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
		timeSlot.setStartTime(startDate.getTime());
		timeSlot.setEndTime(endDate.getTime());
		timeSlot.setPrice(230.0);
		timeSlotRepository.save(timeSlot);
		
		List<TimeSlot> timeSlots = new ArrayList<>();
		timeSlots.add(timeSlot);
		
		
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
		
		Availabilty availabilty = new Availabilty();
		availabilty.setAudi(audi2);
		availabilty.setAvailable(true);
		availabilty.setTimeSlot(timeSlot);
		availabilty.setSeatNumber(1);
		availabilty.setMovie("RDB");
		
		availabiltyRepository.save(availabilty);
		availabiltyRepository.findAll();
	*/}
	
	@Test
	public void checkSlotAvailabilityByMovieName() throws ParseException{
		
		SlotAvailaibilityRequest slotAvailaibilityRequest = new SlotAvailaibilityRequest();
		slotAvailaibilityRequest.setDate(new Date());
		slotAvailaibilityRequest.setTheatreName("PVR");
		slotAvailaibilityRequest.setMovie("RDB");
		availabiltyService.getSlotAvailability(slotAvailaibilityRequest);
	}
	
	@Test
	public void testForAvailabilityByMovie(){
		AvailabiltyRequest availabiltyRequest = new AvailabiltyRequest();
		availabiltyRequest.setMovieName("RDB");
		availabiltyRequest.setDate(new Date());
		availabiltyRequest.setAvailabiltyRequestTypeEnum(AvailabiltyRequestTypeEnum.MOVIE);
		Assert.assertNotNull(availabiltyService.getAvailability(availabiltyRequest).getAvailabilityMap());
	}
	@Test
	public void testForAvailabilityByTheatre(){
		AvailabiltyRequest availabiltyRequest = new AvailabiltyRequest();
		availabiltyRequest.setTheatreName("PVR");
		availabiltyRequest.setDate(new Date());
		availabiltyRequest.setAvailabiltyRequestTypeEnum(AvailabiltyRequestTypeEnum.THEATRE);
		Assert.assertNotNull(availabiltyService.getAvailability(availabiltyRequest).getAvailabilityMap());
	}
	
	@Test
	public void testForAvailabilityByLocation(){
		AvailabiltyRequest availabiltyRequest = new AvailabiltyRequest();
		availabiltyRequest.setCityName("DELHI");
		availabiltyRequest.setDate(new Date());
		availabiltyRequest.setAvailabiltyRequestTypeEnum(AvailabiltyRequestTypeEnum.LOCATION);
		Assert.assertNotNull(availabiltyService.getAvailability(availabiltyRequest).getAvailabilityMap());
	}

}
