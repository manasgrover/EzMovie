/**
 * 
 */
package com.easymovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easymovie.data.entity.BoookingTransaction;

/**
 * @author Manas Grover
 *
 */
public interface BookingTransactionRepository extends JpaRepository<BoookingTransaction, Long> {

	public BoookingTransaction findByUserEmailAndId(String userEmail, Long bookingId);

}
