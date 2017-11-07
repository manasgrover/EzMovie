/**
 * 
 */
package com.easymovie.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

/**
 * @author Manas Grover
 *
 */
@AuditOverride(forClass=BaseEntity.class)
@Audited
@Entity
public class AudiSchedule extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "audi_id", updatable=false)
	private Audi audi;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id", updatable=false)
	private Movie movie;
	
	private Long startDate;
	
	private Long endDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "time_slot_id", updatable=false)
	private List<TimeSlot> timeSlots;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Audi getAudi() {
		return audi;
	}

	public void setAudi(Audi audi) {
		this.audi = audi;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}
	
}
