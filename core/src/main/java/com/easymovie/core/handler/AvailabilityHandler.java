/**
 * 
 */
package com.easymovie.core.handler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easymovie.data.entity.AudiSchedule;
import com.easymovie.data.entity.Availabilty;
import com.easymovie.data.entity.City;
import com.easymovie.data.repository.AudiScheduleRepository;
import com.easymovie.data.repository.AvailabiltyRepository;
import com.easymovie.data.repository.MovieRepository;

/**
 * @author Manas Grover
 *
 */
@Component
public class AvailabilityHandler {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	AudiScheduleRepository audiScheduleRepository;

	@Autowired
	AvailabiltyRepository availabiltyRepository;

	public List<AudiSchedule> getScheduleByMovieName(String movieName,Date date){

		List<AudiSchedule> scheduleList = audiScheduleRepository.findByDatesBetween(date.getTime());
		scheduleList.stream().filter(t -> t.getMovie().getMovieName().equals(movieName));
		return scheduleList;
	}
	public List<AudiSchedule> getScheduleByLocation(String cityName,Date date){
		List<AudiSchedule> scheduleList = audiScheduleRepository.findByDatesBetween(date.getTime());
		scheduleList.stream().filter(t -> (t.getAudi().getTheatre().getLocation().getCity().equals(City.valueOf(cityName))));
		return scheduleList;
	}
	public List<AudiSchedule> getScheduleByTheatre(String thatreName,Date date){
		List<AudiSchedule> scheduleList = audiScheduleRepository.findByDatesBetween(date.getTime());
		scheduleList.stream().filter(t -> (t.getAudi().getTheatre().getName().equals(thatreName)));
		return scheduleList;
	}
	public List<Availabilty> getTimeSlotScheduleByDateAndTheatreName(String theatreName,Date date){
		return availabiltyRepository.findByDateAndAudiTheatreName(date, theatreName);
	}
	public List<Availabilty> getTimeSlotScheduleByDateAndTheatreNameAndMovieName(String theatreName,Date date,String movieName){
		return availabiltyRepository.findByDateAndAudiTheatreNameAndMovie(date, theatreName, movieName);
	}

}
