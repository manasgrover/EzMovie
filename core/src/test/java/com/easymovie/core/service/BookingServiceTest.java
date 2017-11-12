package com.easymovie.core.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easymovie.data.entity.BookingStatus;
import com.easymovie.data.repository.AvailabiltyRepository;
import com.easymovie.data.repository.BookingTransactionRepository;
import com.easymovie.domain.request.BookingRequest;
import com.easymovie.domain.request.CancelBookingRequest;
import com.easymovie.domain.response.BookingResponse;

public class BookingServiceTest extends BaseTest {

	private CancelBookingRequest cancelBookingRequest;
	
	private BookingRequest bookingRequest;
	
	@Autowired
	private BookingService service;
	
	@Autowired
	private AvailabiltyRepository availabiltyRepository;
	
	@Autowired
	private BookingTransactionRepository bookingTransactionRepository;
	
	@Before
	public void setup() throws ParseException{
		cancelBookingRequest = new CancelBookingRequest();
		cancelBookingRequest.setUserEmail("manasgrover7789@gmail.com");
		cancelBookingRequest.setBookingId(1L);
		
		bookingRequest = new BookingRequest();
		bookingRequest.setAudiId(1L);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date d1 = format.parse(format.format(new Date()));
		bookingRequest.setDate(d1);
		bookingRequest.setMovie("don");
		bookingRequest.setSeatNumbers(Arrays.asList(1,4));
		bookingRequest.setTimeSlotId(1L);
		bookingRequest.setUserEmail("manasgrover7789@gmail.com");
	}
	
//	@Test
	public void cancelBookingTest(){
		Assert.assertEquals("SUCCESS", (service.cancelBooking(cancelBookingRequest)).getStatus());
		Assert.assertFalse(availabiltyRepository.findAll().stream().filter(av -> !av.getAvailable()).findAny().isPresent());
		Assert.assertFalse(bookingTransactionRepository.findAll().stream().filter(transaction -> transaction.getBookingStatus() == BookingStatus.CANCELED && transaction.getAvailabilty().size() != 0).findAny().isPresent());
	}
	
	@Test
	public void doBookingSeatUnavailability() throws ParseException{
		bookingRequest.setSeatNumbers(Arrays.asList(1,5));
		BookingResponse response = service.doBooking(bookingRequest);
		Assert.assertEquals("SEAT_UNAVAILABLE", response.getErrorCode());
		Assert.assertEquals("FAILURE", response.getStatus());
	}
	
	@Test
	public void doBookingSuccess() throws ParseException{
		BookingResponse response = service.doBooking(bookingRequest);
		Assert.assertEquals("SUCCESS", response.getStatus());
	}
	
}
