package com.easymovie.data.listeners;


import java.util.Date;

import javax.persistence.PreUpdate;

import com.easymovie.data.config.PersistenceContext;
import com.easymovie.data.entity.BaseEntity;

/**
 * @author Manas Grover
 *
 */
public class BaseEntityListener {
	@PreUpdate
	public void baseEntityPreUpdate(BaseEntity baseEntity){
		baseEntity.setLastModifiedTime((new Date()).getTime());
		baseEntity.setLastModifiedBy("SYSTEM");
	}
}