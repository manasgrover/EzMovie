package com.easymovie.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easymovie.core.handler.AvailabilityHandler;
import com.easymovie.core.handler.MovieHandler;
import com.easymovie.core.service.BookingService;
import com.easymovie.data.entity.Availabilty;
import com.easymovie.data.entity.BookingStatus;
import com.easymovie.data.entity.BookingTransaction;
import com.easymovie.data.entity.Movie;
import com.easymovie.data.sql.handlers.BookingTransactionHandler;
import com.easymovie.domain.request.BookingRequest;
import com.easymovie.domain.request.CancelBookingRequest;
import com.easymovie.domain.response.BaseResponse;
import com.easymovie.domain.response.BookingResponse;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingTransactionHandler bookingTransactionHandler;
	
	@Autowired
	private AvailabilityHandler availabilityHandler;
	
	@Autowired
	private MovieHandler movieHandler;
	
	public BaseResponse cancelBooking(CancelBookingRequest request) {
		
		BaseResponse response = new BaseResponse();
		BookingTransaction transaction = bookingTransactionHandler.getBookingTransaction(request.getUserEmail(), request.getBookingId());
		
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

	@Override
	public BookingResponse doBooking(BookingRequest request) {

		Movie movie = movieHandler.findMovieByMovieName(request.getMovie());
		
		BookingResponse response = new BookingResponse();
		response.setStatus("FAILURE");
		if(movie == null){
			response.setErrorCode("INVALID_MOVIE");
			response.setErrorMessage("Couldn't find the requested movie");
			return response;
		}
		
		List<Availabilty> availabilityList = availabilityHandler.getAvailabilityByDateAndAudiAudiIdAndTimeSlotIdAndMovie(
				request.getDate().getTime(), request.getAudiId(), request.getTimeSlotId(), request.getMovie());
		
		
		if(availabilityList == null || availabilityList.isEmpty()){
			response.setErrorCode("SEAT_UNAVAILABLE");
			response.setErrorMessage("No seats available");
			return response;
		}
		
		List<Availabilty> requestedSeatAvailabilityList = availabilityList.stream()
				.filter(a -> request.getSeatNumbers().contains(a.getSeatNumber())).collect(Collectors.toList());
		
		if (requestedSeatAvailabilityList == null || requestedSeatAvailabilityList.isEmpty()
				|| requestedSeatAvailabilityList.size() != request.getSeatNumbers().size()) {
			response.setErrorCode("SEAT_UNAVAILABLE");
			response.setErrorMessage("All Requested seats are not available");
			return response;
		}
		
		BookingTransaction transaction = new BookingTransaction();
		transaction.setBookingStatus(BookingStatus.BOOKED);
		transaction.setMovie(movie);
		transaction.setUserEmail(request.getUserEmail());
		
		requestedSeatAvailabilityList.stream().forEach(a -> {
			a.setBookingTransaction(transaction);
			a.setAvailable(true);
			});
		
		response.setMovie(movie);
		response.setSeatNumbers(request.getSeatNumbers());
		response.setAudi(requestedSeatAvailabilityList.get(0).getAudi());
		response.setTimeslot(requestedSeatAvailabilityList.get(0).getTimeSlot());
		
		bookingTransactionHandler.save(transaction);
		
		// transact!ion saved successfully
		if(transaction.getId() != null){
			response.setStatus("SUCCESS");
			transaction.setAvailabilty(requestedSeatAvailabilityList);
			List<Availabilty> updatedAvailabilties = availabilityHandler.saveIfAvailable(availabilityList);
			System.out.println(updatedAvailabilties);
		}		

		return response;
	}

}
