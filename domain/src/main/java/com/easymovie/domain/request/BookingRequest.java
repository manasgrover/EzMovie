package com.easymovie.domain.request;

import java.util.Date;
import java.util.List;

public class BookingRequest extends BaseRequest {

	private String userEmail;
	private Long timeSlotId;
	private List<Integer> seatNumbers;
	private Long audiId;
	private Date date;
	private String movie;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(Long timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public List<Integer> getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(List<Integer> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public Long getAudiId() {
		return audiId;
	}

	public void setAudiId(Long audiId) {
		this.audiId = audiId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "BookingRequest [userEmail=" + userEmail + ", timeSlotId=" + timeSlotId + ", seatNumbers=" + seatNumbers
				+ ", audiId=" + audiId + ", date=" + date + ", movie=" + movie + "]";
	}

}
