/**
 * 
 */
package com.easymovie.core.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easymovie.data.entity.Movie;
import com.easymovie.data.repository.MovieRepository;

/**
 * @author Manas Grover
 *
 */
@Component
public class MovieHandler {
	
	@Autowired
	MovieRepository movieRepository;
	
	public Movie findMovieByMovieName(String movieName){
		return movieRepository.findByMovieName(movieName);
	}

}
