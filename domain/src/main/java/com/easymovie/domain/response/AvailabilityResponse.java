/**
 * 
 */
package com.easymovie.domain.response;

import java.util.List;
import java.util.Map;

import com.easymovie.data.entity.Movie;
import com.easymovie.data.entity.Theatre;
import com.easymovie.data.entity.TimeSlot;

/**
 * @author Manas Grover
 *
 */
public class AvailabilityResponse extends BaseResponse {

	private Map<Movie, Map<Theatre, List<TimeSlot>>> availabilityMap;

	public Map<Movie, Map<Theatre, List<TimeSlot>>> getAvailabilityMap() {
		return availabilityMap;
	}

	public void setAvailabilityMap(Map<Movie, Map<Theatre, List<TimeSlot>>> availabilityMap) {
		this.availabilityMap = availabilityMap;
	}

}
