/**
 * 
 */
package com.easymovie.domain.request;

import java.util.Date;

import com.easymovie.data.entity.TimeSlot;

/**
 * @author Manas Grover
 *
 */
public class SlotAvailaibilityRequest extends BaseRequest {
	
	private Date date;
	private TimeSlot timeSlot;
	private String theatreName;
	private String movie;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
}
