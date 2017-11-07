/**
 * 
 */
package com.easymovie.core.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easymovie.data.entity.Theatre;
import com.easymovie.data.repository.TheatreRepository;

/**
 * @author Manas Grover
 *
 */
@Component
public class TheatreHandler {

	
	@Autowired
	TheatreRepository theatreRepository;
	
	public Theatre getTheatreById(Long id){
		
		return  theatreRepository.findOne(id);
	}
}
