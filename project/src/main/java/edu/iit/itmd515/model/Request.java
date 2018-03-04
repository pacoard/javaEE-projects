package edu.iit.itmd515.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 

// TODO import constraints


/**
 * Definition of table Trips
 * 
 * @author Francisco, Raquel
 *
 */
@Entity
@Table(name = "Requests")
public class Request {
	
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@ForeignKey
	private Long consumerId;
	private String Location;
	private String time;
	private String type;
	
	// Constructor (cannot have parameters)
	public Request() {}
	
	/**
	 * Pseudo-constructor
	 * 
	 * @param id
	 * @param consumerId
	 * @param location
	 * @param time
	 * @param type
	 */
	public Request(Long id, Long consumerId, String location, String time, String type) {
		super();
		this.id = id;
		this.consumerId = consumerId;
		Location = location;
		this.time = time;
		this.type = type;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the consumerId
	 */
	public Long getConsumerId() {
		return consumerId;
	}


	/**
	 * @param consumerId the consumerId to set
	 */
	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return Location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		Location = location;
	}


	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Request [id=" + id + ", consumerId=" + consumerId + ", Location=" + Location + ", time=" + time
				+ ", type=" + type + "]";
	}
	
}
