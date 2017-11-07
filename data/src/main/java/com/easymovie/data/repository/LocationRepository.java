/**
 * 
 */
package com.easymovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easymovie.data.entity.Location;

/**
 * @author Manas Grover
 *
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

}
