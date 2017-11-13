/**
 * 
 */
package com.easymovie.core.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<Availabilty> getTimeSlotScheduleByDateAndTheatreNameAndMovieName(String theatreName,Long date,String movieName){
		return availabiltyRepository.findByDateAndAudiTheatreNameAndMovie(date, theatreName, movieName);
	}
	
	public List<Availabilty> getAvailabilityByDateAndAudiAudiIdAndTimeSlotIdAndMovie(Long date, Long audiId, Long timeSlotId, String movieName){
		return availabiltyRepository.findByDateAndAudiAudiIdAndTimeSlotIdAndMovieAndAvailableIsTrue(date, audiId, timeSlotId, movieName);
	}
	
	public int saveIfAvailable(List<Availabilty> availabilityList){
		List<Long> availIds = availabilityList.stream().map(Availabilty::getAvailabilityId).collect(Collectors.toList());
		return availabiltyRepository.updateAvailabilityOnlyIfAvailableIsTrue(availabilityList.get(0).getBookingTransaction(), availIds);
	}
	
	public int save(List<Availabilty> availabilityList){
		return availabiltyRepository.save(availabilityList).size();
	}

}
