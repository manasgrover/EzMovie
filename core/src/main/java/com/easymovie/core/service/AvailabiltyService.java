/**
 * 
 */
package com.easymovie.core.service;

import com.easymovie.domain.request.AvailabiltyRequest;
import com.easymovie.domain.response.AvailabilityResponse;

/**
 * @author Manas Grover
 *
 */
public interface AvailabiltyService {
	
	AvailabilityResponse getAvailability(AvailabiltyRequest availabiltyRequest);

}
