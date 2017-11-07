package com.easymovie.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easymovie.core.service.BookingCancellationService;
import com.easymovie.data.entity.BookingStatus;
import com.easymovie.data.entity.BoookingTransaction;
import com.easymovie.data.sql.handlers.BookingTransactionHandler;
import com.easymovie.domain.request.CancelBookingRequest;
import com.easymovie.domain.response.BaseResponse;

@Service
public class BookingCancellationServiceImpl implements BookingCancellationService {

	@Autowired
	private BookingTransactionHandler bookingTransactionHandler;
	
	public BaseResponse cancelBooking(CancelBookingRequest request) {
		
		BaseResponse response = new BaseResponse();
		BoookingTransaction transaction = bookingTransactionHandler.getBookingTransaction(request.getUserEmail(), request.getBookingId());
		
		if(transaction != null && transaction.getBookingStatus() == BookingStatus.BOOKED){
			transaction.setBookingStatus(BookingStatus.CANCELED);
			transaction.getAvailabilty().stream().filter(av -> !av.getAvailable())
					.forEach(av -> {
						av.setAvailable(true);
						av.setBookingTransaction(null);
						});
			
			bookingTransactionHandler.save(transaction);
			response.setStatus("SUCCESS");
		}else{
			response.setStatus("FAILED");
			response.setErrorCode("No Transaction Found");//will create an enum to set the status, errorCode and errorMessage
		}
		
		return response;
	}

}
