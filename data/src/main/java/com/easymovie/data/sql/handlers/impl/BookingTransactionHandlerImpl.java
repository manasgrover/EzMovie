package com.easymovie.data.sql.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easymovie.data.entity.BookingTransaction;
import com.easymovie.data.repository.BookingTransactionRepository;
import com.easymovie.data.sql.handlers.BookingTransactionHandler;

@Component
public class BookingTransactionHandlerImpl implements BookingTransactionHandler {

	@Autowired
	private BookingTransactionRepository bookingTransactionRepository;
	
	public BookingTransaction getBookingTransaction(String userEmail, Long bookingId) {
		return bookingTransactionRepository.findByUserEmailAndId(userEmail, bookingId);
	}

	public void save(BookingTransaction bookingTransaction) {
		bookingTransactionRepository.save(bookingTransaction);
	}

	@Override
	public BookingTransaction getBookingTransaction(Long bookingId) {
		return bookingTransactionRepository.findOne(bookingId);
	}
	
}
