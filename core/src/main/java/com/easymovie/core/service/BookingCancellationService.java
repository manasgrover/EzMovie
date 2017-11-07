package com.easymovie.core.service;

import com.easymovie.domain.request.CancelBookingRequest;
import com.easymovie.domain.response.BaseResponse;

public interface BookingCancellationService {

	public BaseResponse cancelBooking(CancelBookingRequest request);
	
}
