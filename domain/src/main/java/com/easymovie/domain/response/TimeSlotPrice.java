/**
 * 
 */
package com.easymovie.domain.response;

import com.easymovie.data.entity.TimeSlot;

/**
 * @author Manas Grover
 *
 */
public class TimeSlotPrice {
	
	TimeSlot timeSlot;
	Double price;
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
