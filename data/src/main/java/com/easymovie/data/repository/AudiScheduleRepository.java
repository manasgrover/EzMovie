/**
 * 
 */
package com.easymovie.data.repository;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.easymovie.data.entity.AudiSchedule;

/**
 * @author Manas Grover
 *
 */
@Repository
public interface AudiScheduleRepository extends JpaRepository<AudiSchedule, Long> {
	//public List<AudiSchedule> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(Long date);
	//AndEndDateLessThanEqual
	 @Query("select b from AudiSchedule b " +
	         "where b.endDate >= ?1 and b.startDate <= ?1")
	  List<AudiSchedule> findByDatesBetween(Long date);
}
