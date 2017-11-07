/**
 * 
 */
package com.easymovie.data.repository;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easymovie.data.entity.Audi;
import com.easymovie.data.entity.BoookingTransaction;
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
public class BookingTransactionRepositoryTest extends BaseTest{
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	LocationRepository LocationRepository;
	
	@Autowired
	AudiRepository audiRepository;
	
	@Autowired
	BookingTransactionRepository BookingTransactionRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TimeSlotRepository timeSlotRepository;

	@Test
	public void testForNotNullBookingTransaction(){
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
		
		Movie movie = new Movie();
		movie.setMovieName("RDB");
		movie.setDescription("Great");
		movieRepository.save(movie);
		
		BoookingTransaction transaction = new BoookingTransaction();
/*		transaction.setAudi(audi);
		transaction.setTimeSlot(timeSlot);
*/		transaction.setUserEmail("manas@gmail.com");
		transaction.setMovie(movie);
		
		BookingTransactionRepository.save(transaction);
//		Assert.assertNotNull(BookingTransactionRepository.findAll().get(0).getAudi());
	}
}
