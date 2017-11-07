package com.easymovie.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

/**
 * @author Manas Grover
 *
 */
@AuditOverride(forClass=BaseEntity.class)
@Audited
@Entity
public class Theatre extends BaseEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theatreId;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", updatable=false)
	private Location location;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "theatre",cascade = CascadeType.ALL)
	private List<Audi> audiList;

	public Long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Audi> getAudiList() {
		return audiList;
	}

	public void setAudiList(List<Audi> audiList) {
		this.audiList = audiList;
	}
	
}
