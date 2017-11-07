/**
 * 
 */
package com.easymovie.domain.response;

import java.util.List;

/**
 * @author Manas Grover
 *
 */
public class SlotAvailaibilityResponse extends BaseResponse {
	
	private List<Integer> seatNumbers;

	public List<Integer> getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(List<Integer> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
}
