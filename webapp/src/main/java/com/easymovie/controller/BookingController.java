package com.easymovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easymovie.core.service.BookingService;
import com.easymovie.domain.request.BookingRequest;
import com.easymovie.domain.request.CancelBookingRequest;
import com.easymovie.domain.response.BaseResponse;
import com.easymovie.domain.response.BookingResponse;

/**
 * @author Manas Grover
 *
 */
@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping(value = "/cancelBooking", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponse cancelBooking(@RequestBody CancelBookingRequest cancelBookingRequest) {
		return bookingService.cancelBooking(cancelBookingRequest);
	}

	@PostMapping(value = "/doBooking", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BookingResponse doBooking(@RequestBody BookingRequest bookingRequest) {
		return bookingService.doBooking(bookingRequest);
	}

}
