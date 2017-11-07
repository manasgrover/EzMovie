package com.easymovie.data.sql.handlers;

import com.easymovie.data.entity.BoookingTransaction;

public interface BookingTransactionHandler {

	public BoookingTransaction getBookingTransaction(String userEmail, Long bookingId);
	
	public void save(BoookingTransaction bookingTransaction);

}
