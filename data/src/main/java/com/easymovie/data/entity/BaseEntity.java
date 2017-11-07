package com.easymovie.data.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.easymovie.data.listeners.BaseEntityListener;

/**
 * @author Manas Grover
 *
 */
@EntityListeners(BaseEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {
	

	private static final long serialVersionUID = -7704895955336655472L;

	private String createdBy;

	private String lastModifiedBy;

	private Long createdTime;

	private Long lastModifiedTime;
	
	public BaseEntity() {
		super();
		createdBy = "SYSTEM";
		lastModifiedBy = "SYSTEM";
		createdTime = new Date().getTime();
		lastModifiedTime = new Date().getTime();
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Long getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}
	public Long getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}