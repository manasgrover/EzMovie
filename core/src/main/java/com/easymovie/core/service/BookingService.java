package com.easymovie.core.service;

import com.easymovie.domain.request.BookingRequest;
import com.easymovie.domain.request.CancelBookingRequest;
import com.easymovie.domain.response.BaseResponse;
import com.easymovie.domain.response.BookingResponse;

public interface BookingService {

	public BaseResponse cancelBooking(CancelBookingRequest request);
	
	public BookingResponse doBooking(BookingRequest request);
	
}
