package com.easymovie.domain.request;

public class CancelBookingRequest extends BaseRequest {

	private Long bookingId;
	private String userEmail;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "CancelBookingRequest [bookingId=" + bookingId + ", userEmail=" + userEmail + "]";
	}

}
