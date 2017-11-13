/**
 * 
 */
package com.easymovie.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

/**
 * @author Manas Grover
 *
 */
@AuditOverride(forClass = BaseEntity.class)
@Audited
@Entity
public class BookingTransaction extends BaseEntity {

	private String userEmail;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "bookingTransaction", fetch = FetchType.EAGER)
	// @JoinColumn(name = "availability_id", updatable=false)
	private List<Availabilty> availabilty;

	@ManyToOne
	private Movie movie;

	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Availabilty> getAvailabilty() {
		return availabilty;
	}

	public void setAvailabilty(List<Availabilty> availabilty) {
		this.availabilty = availabilty;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
