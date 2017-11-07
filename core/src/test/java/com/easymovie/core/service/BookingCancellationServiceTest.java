package com.easymovie.core.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easymovie.data.entity.BookingStatus;
import com.easymovie.data.repository.AvailabiltyRepository;
import com.easymovie.data.repository.BookingTransactionRepository;
import com.easymovie.domain.request.CancelBookingRequest;

public class BookingCancellationServiceTest extends BaseTest {

	private CancelBookingRequest request;
	
	@Autowired
	private BookingCancellationService service;
	
	@Autowired
	private AvailabiltyRepository availabiltyRepository;
	
	@Autowired
	private BookingTransactionRepository bookingTransactionRepository;
	
	@Before
	public void setup(){
		request = new CancelBookingRequest();
		request.setUserEmail("manasgrover7789@gmail.com");
		request.setBookingId(1L);
	}
	
	@Test
	public void cancelBookingTest(){
		Assert.assertEquals("SUCCESS", (service.cancelBooking(request)).getStatus());
		Assert.assertFalse(availabiltyRepository.findAll().stream().filter(av -> !av.getAvailable()).findAny().isPresent());
		Assert.assertFalse(bookingTransactionRepository.findAll().stream().filter(transaction -> transaction.getBookingStatus() == BookingStatus.CANCELED && transaction.getAvailabilty().size() != 0).findAny().isPresent());
	}
	
}
