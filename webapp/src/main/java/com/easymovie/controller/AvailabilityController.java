/**
 * 
 */
package com.easymovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easymovie.core.service.AvailabiltyService;
import com.easymovie.domain.request.AvailabiltyRequest;
import com.easymovie.domain.request.SlotAvailaibilityRequest;
import com.easymovie.domain.response.AvailabilityResponse;
import com.easymovie.domain.response.SlotAvailaibilityResponse;

/**
 * @author Manas Grover
 *
 */
@Controller
public class AvailabilityController {
	
	@Autowired
	AvailabiltyService availabiltyService;
	
	@PostMapping(value = "/availability", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody AvailabilityResponse executeAvailabiltyRequest(@RequestBody AvailabiltyRequest availabiltyRequest) {
		return availabiltyService.getAvailability(availabiltyRequest);
	}
	
	@PostMapping(value = "/slotAvailability", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody SlotAvailaibilityResponse executeSlotAvailabiltyRequest(@RequestBody SlotAvailaibilityRequest availabiltyRequest) {
		return availabiltyService.getSlotAvailability(availabiltyRequest);
	}

}
