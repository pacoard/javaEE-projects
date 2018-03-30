package edu.iit.itmd515.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	@OneToOne
	private Consumer consumer;
	private String Location;
	private String time;
	private String type;
	
	// Constructor (cannot have parameters)
	public Request() {}
	
	/**
	 * Pseudo-constructor
	 * 
	 * @param id
	 * @param location
	 * @param time
	 * @param type
	 */
	public Request(Long id,String location, String time, String type) {
		super();
		this.id = id;
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
	 * @return the consumer
	 */
	public Consumer getConsumer() {
		return consumer;
	}

	/**
	 * @param consumer the consumer to set
	 */
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
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
		return "Request [id=" + id + ", Location=" + Location + ", time=" + time
				+ ", type=" + type + "]";
	}
	
}
