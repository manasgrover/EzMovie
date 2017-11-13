package com.easymovie.core.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easymovie.domain.request.BookingRequest;
import com.easymovie.domain.response.BookingResponse;

public class BookingServiceTest extends BaseTest {

	private BookingRequest bookingRequest;

	@Autowired
	private BookingService service;

	@Before
	public void setup() throws ParseException {
		bookingRequest = new BookingRequest();
		bookingRequest.setAudiId(1L);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date d1 = format.parse("10-11-2017");
		bookingRequest.setDate(d1);
		bookingRequest.setMovie("don");
		bookingRequest.setSeatNumbers(Arrays.asList(1, 4));
		bookingRequest.setTimeSlotId(1L);
		bookingRequest.setUserEmail("manasgrover7789@gmail.com");
	}

	@Test
	public void doBookingSeatUnavailability() throws ParseException {
		bookingRequest.setSeatNumbers(Arrays.asList(1, 5));
		BookingResponse response = service.doBooking(bookingRequest);
		Assert.assertEquals("SEAT_UNAVAILABLE", response.getErrorCode());
		Assert.assertEquals("FAILURE", response.getStatus());
	}

	@Test
	public void doBookingSuccess() throws ParseException {
		BookingResponse response = service.doBooking(bookingRequest);
		Assert.assertEquals("SUCCESS", response.getStatus());
	}

}
