/**
 * 
 */
package com.easymovie.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

/**
 * @author Manas Grover
 *
 */
@AuditOverride(forClass=BaseEntity.class)
@Audited	
@Entity
public class Audi extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long audiId;
	
	private int audiNumber;
	
	private int capacity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "theatre_id", updatable=true)
	private Theatre theatre;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "audi",cascade = CascadeType.ALL)
	private List<AudiSchedule> scheduleList;
	
	@OneToMany(mappedBy="audi")
	private List<SeatLayout> seatLayout;
	
	public Long getAudiId() {
		return audiId;
	}

	public void setAudiId(Long audiId) {
		this.audiId = audiId;
	}

	public int getAudiNumber() {
		return audiNumber;
	}

	public void setAudiNumber(int audiNumber) {
		this.audiNumber = audiNumber;
	}

	public int getNumberOfSeats() {
		return capacity;
	}

	public void setNumberOfSeats(int capacity) {
		this.capacity = capacity;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<AudiSchedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<AudiSchedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public List<SeatLayout> getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(List<SeatLayout> seatLayout) {
		this.seatLayout = seatLayout;
	}
	
}
