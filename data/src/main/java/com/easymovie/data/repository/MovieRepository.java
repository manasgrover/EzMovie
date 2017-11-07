/**
 * 
 */
package com.easymovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easymovie.data.entity.Movie;

/**
 * @author Manas Grover
 *
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	public Movie findByMovieName(String movieName);
}
