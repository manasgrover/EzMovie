/**
 * 
 */
package com.easymovie.core.service;

import com.easymovie.domain.request.AvailabiltyRequest;
import com.easymovie.domain.request.SlotAvailaibilityRequest;
import com.easymovie.domain.response.AvailabilityResponse;
import com.easymovie.domain.response.SlotAvailaibilityResponse;

/**
 * @author Manas Grover
 *
 */
public interface AvailabiltyService {
	
	AvailabilityResponse getAvailability(AvailabiltyRequest availabiltyRequest);
	public SlotAvailaibilityResponse getSlotAvailability(SlotAvailaibilityRequest availabiltyRequest);

}
