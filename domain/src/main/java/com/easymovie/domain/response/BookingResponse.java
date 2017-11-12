package com.easymovie.domain.response;

import java.util.List;

import com.easymovie.data.entity.Audi;
import com.easymovie.data.entity.Movie;
import com.easymovie.data.entity.TimeSlot;

public class BookingResponse extends BaseResponse {

	private List<Integer> seatNumbers;
	private Audi audi;
	private TimeSlot timeslot;
	private Movie movie;

	public List<Integer> getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(List<Integer> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public Audi getAudi() {
		return audi;
	}

	public void setAudi(Audi audi) {
		this.audi = audi;
	}

	public TimeSlot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(TimeSlot timeslot) {
		this.timeslot = timeslot;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "BookingResponse [seatNumbers=" + seatNumbers + ", audi=" + audi + ", timeslot=" + timeslot + ", movie="
				+ movie + "]";
	}

}
