/**
 * 
 */
package com.easymovie.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

/**
 * @author Manas Grover
 *
 */

@AuditOverride(forClass = BaseEntity.class)
@Audited
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "audi_id", "time_slot_id", "date", "seat_number" }) })
public class Availabilty extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long availabilityId;

	private int seatNumber;

	@ManyToOne
	@JoinColumn(name = "audi_id", updatable = false)
	private Audi audi;

	private Long date;

	@ManyToOne
	@JoinColumn(name = "time_slot_id", updatable = false)
	private TimeSlot timeSlot;

	private Boolean available;

	@ManyToOne(optional = true)
	@JoinColumn(name = "booking_id")
	private BoookingTransaction bookingTransaction;

	public Long getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(Long availabilityId) {
		this.availabilityId = availabilityId;
	}

	public Audi getAudi() {
		return audi;
	}

	public void setAudi(Audi audi) {
		this.audi = audi;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public BoookingTransaction getBookingTransaction() {
		return bookingTransaction;
	}

	public void setBookingTransaction(BoookingTransaction bookingTransaction) {
		this.bookingTransaction = bookingTransaction;
	}

}
