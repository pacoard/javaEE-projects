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
	private String origin;
	private String destination;
	private String price;
	private String distance;
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
	public Request(Long id,String origin, String destination, String price, String distance, String type) {
		super();
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.price = price;
		this.distance = distance;
		this.type = type;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
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

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Request [id=" + id + ", consumer=" + consumer + ", origin=" + origin + ", destination=" + destination
				+ ", price=" + price + ", distance=" + distance + ", type=" + type + "]";
	}


	
}
