/**
 * 
 */
package com.easymovie.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easymovie.data.entity.Availabilty;

/**
 * @author Manas Grover
 *
 */
public interface AvailabiltyRepository extends JpaRepository<Availabilty, Long>{
	
	public List<Availabilty> findByDateAndAudiTheatreName(Long date,String audiTheatreName);
	
	public List<Availabilty> findByDateAndAudiTheatreNameAndMovie(Long date,String audiTheatreName,String movie);

}
