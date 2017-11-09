package com.easymovie.data.sql.handlers;

import com.easymovie.data.entity.BookingTransaction;

public interface BookingTransactionHandler {

	public BookingTransaction getBookingTransaction(String userEmail, Long bookingId);
	
	public void save(BookingTransaction bookingTransaction);

}
