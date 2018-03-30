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
@Table(name = "Trips")
public class Trip {
	
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Consumer consumer;
	@OneToOne
	private Driver driver;
	private double distance;
	private String dropoffLocation;
	private String pickupLocation;
	private double price;
	
	// Constructor (cannot have parameters)
	public Trip() {}
	
	
	/**
	 * Pseudo-constructor
	 * 
	 * @param consumerId
	 * @param driverId
	 * @param distance
	 * @param dropoffLocation
	 * @param pickupLocation
	 * @param price
	 */
	public Trip(double distance, String dropoffLocation, String pickupLocation,
			double price) {
		super();
		this.distance = distance;
		this.dropoffLocation = dropoffLocation;
		this.pickupLocation = pickupLocation;
		this.price = price;
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


	public Consumer getConsumer() {
		return consumer;
	}


	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}


	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}


	/**
	 * @return the dropoffLocation
	 */
	public String getDropoffLocation() {
		return dropoffLocation;
	}


	/**
	 * @param dropoffLocation the dropoffLocation to set
	 */
	public void setDropoffLocation(String dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}


	/**
	 * @return the pickupLocation
	 */
	public String getPickupLocation() {
		return pickupLocation;
	}


	/**
	 * @param pickupLocation the pickupLocation to set
	 */
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trip [id=" + id + ", distance=" + distance
				+ ", dropoffLocation=" + dropoffLocation + ", pickupLocation=" + pickupLocation + ", price=" + price
				+ "]";
	}

}
