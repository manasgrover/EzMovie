/**
 * 
 */
package com.easymovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easymovie.data.entity.BookingTransaction;

/**
 * @author Manas Grover
 *
 */
public interface BookingTransactionRepository extends JpaRepository<BookingTransaction, Long> {

	public BookingTransaction findByUserEmailAndId(String userEmail, Long bookingId);

}
