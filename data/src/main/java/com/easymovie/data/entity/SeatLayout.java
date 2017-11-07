/**
 * 
 */
package com.easymovie.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

/**
 * @author Manas Grover
 *
 */
@AuditOverride(forClass=BaseEntity.class)
@Audited
@Entity
public class SeatLayout extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "audi_id", updatable=false)
	private Audi audi;
	
	private Integer rowIdentifier;
	
	private Integer SeatNumber;

	public Audi getAudi() {
		return audi;
	}

	public void setAudi(Audi audi) {
		this.audi = audi;
	}

	public Integer getRowIdentifier() {
		return rowIdentifier;
	}

	public void setRowIdentifier(Integer rowIdentifier) {
		this.rowIdentifier = rowIdentifier;
	}

	public Integer getSeatNumber() {
		return SeatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		SeatNumber = seatNumber;
	}
	
	
	
	
}
