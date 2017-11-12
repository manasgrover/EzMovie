/**
 * 
 */
package com.easymovie.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.easymovie.data.entity.Availabilty;
import com.easymovie.data.entity.BookingTransaction;

/**
 * @author Manas Grover
 *
 */
public interface AvailabiltyRepository extends JpaRepository<Availabilty, Long>{
	
	public List<Availabilty> findByDateAndAudiTheatreName(Long date,String audiTheatreName);
	
	public List<Availabilty> findByDateAndAudiTheatreNameAndMovie(Long date,String audiTheatreName,String movie);
	
public List<Availabilty> findByDateAndAudiAudiIdAndTimeSlotIdAndMovieAndAvailableIsTrue(Long date,Long audiId, Long timeSlotId, String movie);
	
	@Modifying(clearAutomatically=true)
	@Query("update Availabilty c set c.available = false, c.bookingTransaction = :bookingTransaction where c.available = true and  c.availabilityId in (:availabiltyIds)")
	@Transactional
	public List<Availabilty> updateAvailabilityIfAvailable(@Param("bookingTransaction") BookingTransaction bookingTransaction, @Param("availabiltyIds") List<Long> availabilityIds);


}
