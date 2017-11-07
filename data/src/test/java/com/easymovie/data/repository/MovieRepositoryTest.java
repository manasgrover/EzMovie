/**
 * 
 */
package com.easymovie.data.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.easymovie.data.entity.Movie;

/**
 * @author Manas Grover
 *
 */
public class MovieRepositoryTest extends BaseTest {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Test
	public void testForMovieNotNull(){
		Movie movie = new Movie();
		movie.setMovieName("RDB");
		movie.setDescription("Great");
		movieRepository.save(movie);
		System.out.println(movieRepository.findAll());
		Assert.notNull(movieRepository.findByMovieName("RDB"));
		//Assert.notNull(movieRepository.findByMovieName("don"));
		
	}

}
