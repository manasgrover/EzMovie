package com.easymovie.data.sql.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easymovie.data.entity.BoookingTransaction;
import com.easymovie.data.repository.BookingTransactionRepository;
import com.easymovie.data.sql.handlers.BookingTransactionHandler;

@Component
public class BookingTransactionHandlerImpl implements BookingTransactionHandler {

	@Autowired
	private BookingTransactionRepository bookingTransactionRepository;
	
	public BoookingTransaction getBookingTransaction(String userEmail, Long bookingId) {
		return bookingTransactionRepository.findByUserEmailAndId(userEmail, bookingId);
	}

	public void save(BoookingTransaction bookingTransaction) {
		bookingTransactionRepository.save(bookingTransaction);
	}
	
}
