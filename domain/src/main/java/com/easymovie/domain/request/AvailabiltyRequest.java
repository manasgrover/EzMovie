/**
 * 
 */
package com.easymovie.domain.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * @author Manas Grover
 *
 */
public class AvailabiltyRequest extends BaseRequest{
	
	@NotNull(message="1")
	private AvailabiltyRequestTypeEnum availabiltyRequestTypeEnum;
	@NotNull(message="1")
	private Date date;
	private String movieName;
	private String cityName;
	private String theatreName;
	public AvailabiltyRequestTypeEnum getAvailabiltyRequestTypeEnum() {
		return availabiltyRequestTypeEnum;
	}
	public void setAvailabiltyRequestTypeEnum(AvailabiltyRequestTypeEnum availabiltyRequestTypeEnum) {
		this.availabiltyRequestTypeEnum = availabiltyRequestTypeEnum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
}
