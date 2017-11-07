/**
 * 
 */
package com.easymovie.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easymovie.core.handler.AvailabilityHandler;
import com.easymovie.core.handler.MovieHandler;
import com.easymovie.core.service.AvailabiltyService;
import com.easymovie.data.entity.AudiSchedule;
import com.easymovie.data.entity.Availabilty;
import com.easymovie.data.entity.Movie;
import com.easymovie.data.entity.Theatre;
import com.easymovie.data.entity.TimeSlot;
import com.easymovie.domain.request.AvailabiltyRequest;
import com.easymovie.domain.request.AvailabiltyRequestTypeEnum;
import com.easymovie.domain.request.SlotAvailaibilityRequest;
import com.easymovie.domain.response.AvailabilityResponse;
import com.easymovie.domain.response.SlotAvailaibilityResponse;

/**
 * @author Manas Grover
 *
 */
@Service
public class AvailabilityServiceImpl implements AvailabiltyService{
	
	@Autowired
	AvailabilityHandler availabilityHandler;
	
	@Autowired
	MovieHandler movieHandler;
	

	/* (non-Javadoc)
	 * @see com.easymovie.core.service.AvailabiltyService#getAvailability(com.easymovie.domain.request.AvailabiltyRequest)
	 */
	public AvailabilityResponse getAvailability(AvailabiltyRequest availabiltyRequest) {
		
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		Map<Movie, Map<Theatre,List<TimeSlot>>> availabilityMap = new HashMap<Movie, Map<Theatre,List<TimeSlot>>>();
		List<AudiSchedule> scheduleList = null;
		if(availabiltyRequest.getAvailabiltyRequestTypeEnum() == AvailabiltyRequestTypeEnum.MOVIE){
			scheduleList = availabilityHandler.getScheduleByMovieName(availabiltyRequest.getMovieName(),availabiltyRequest.getDate());
			populateMapforResponse(availabilityResponse, availabilityMap, scheduleList);
		}else if(availabiltyRequest.getAvailabiltyRequestTypeEnum() == AvailabiltyRequestTypeEnum.LOCATION){
			scheduleList = availabilityHandler.getScheduleByLocation(availabiltyRequest.getCityName(),availabiltyRequest.getDate());
			populateMapforResponse(availabilityResponse, availabilityMap, scheduleList);
		}else if(availabiltyRequest.getAvailabiltyRequestTypeEnum() == AvailabiltyRequestTypeEnum.THEATRE){
			scheduleList = availabilityHandler.getScheduleByLocation(availabiltyRequest.getTheatreName(),availabiltyRequest.getDate());
			populateMapforResponse(availabilityResponse, availabilityMap, scheduleList);
		}
		return availabilityResponse;
	}
	
	public SlotAvailaibilityResponse getSlotAvailability(SlotAvailaibilityRequest availabiltyRequest) {
		List<Availabilty> availability = availabilityHandler.getTimeSlotScheduleByDateAndTheatreName(availabiltyRequest.getTheatreName(),availabiltyRequest.getDate());
		List<Integer> seatNumbers = availability.stream().filter(t -> t.getAvailable()).map(t -> t.getSeatNumber()).collect(Collectors.toList());
		SlotAvailaibilityResponse response = new SlotAvailaibilityResponse();
		response.setSeatNumbers(seatNumbers);
		return response;
	}


	/**
	 * @param availabilityResponse
	 * @param availabilityMap
	 * @param scheduleList
	 */
	private void populateMapforResponse(AvailabilityResponse availabilityResponse,
			Map<Movie, Map<Theatre, List<TimeSlot>>> availabilityMap, List<AudiSchedule> scheduleList) {
		for(AudiSchedule schedule:scheduleList){
			Map<Theatre,List<TimeSlot>> theatreMap = new HashMap<Theatre, List<TimeSlot>>(); 
			if(availabilityMap.containsKey(schedule.getMovie())){
				theatreMap = availabilityMap.get(schedule.getMovie());
			}
			theatreMap.put(schedule.getAudi().getTheatre(), schedule.getTimeSlots());
			availabilityMap.put(schedule.getMovie(), theatreMap);
		}
		availabilityResponse.setAvailabilityMap(availabilityMap);
	}
	
	

}
