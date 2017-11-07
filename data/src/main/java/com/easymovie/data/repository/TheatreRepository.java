/**
 * 
 */
package com.easymovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easymovie.data.entity.Theatre;

/**
 * @author Manas Grover
 *
 */
public interface TheatreRepository extends JpaRepository<Theatre, Long>{
	
	public Theatre findByName(String name);
}
