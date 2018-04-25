package edu.iit.itmd515.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 

// TODO import constraints


/**
 * Definition of table Consumers
 * 
 * @author Francisco, Raquel
 *
 */
@Entity
@Table(name = "Consumers")
public class Consumer implements java.io.Serializable {
	
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String password;
	private String name;
	@Column(unique = true)
	private String phone;
	@Column(unique = true)
	private String cardNumber;
	private String location;
	private Double rating;
	@OneToOne
	private Request request;
	@OneToOne
	private Trip trip;
	private int banned;
	
	// Constructor (cannot have parameters)
	public Consumer() {}
	
	/**
	 * Pseudo-constructor Consumer
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param phone
	 * @param cardNumber
	 * @param location
	 * @param banned
	 * @param rating
	 */
	public Consumer(String email, String password, String name, String phone, String cardNumber, String location,
			Double rating, int banned) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.cardNumber = cardNumber;
		this.location = location;
		this.rating = rating;
		this.banned = banned;
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
	 * @return the request
	 */

	public Request getRequest() {
		return request;
	}
	
	/**
	 * @param request the request to set
	 */
	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}



	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}



	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}



	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}



	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}



	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}



	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}



	/**
	 * @param rating the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}

	/**
	 * @return the trip
	 */
	public Trip getTrip() {
		return trip;
	}

	/**
	 * @param trip the trip to set
	 */
	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	/**
	 * @return the banned
	 */
	public int getBanned() {
		return banned;
	}

	/**
	 * @param banned the banned to set
	 */
	public void setBanned(int banned) {
		this.banned = banned;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Consumer [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", cardNumber=" + cardNumber + ", location=" + location + ", rating=" + rating + ", request="
				+ request + ", trip=" + trip + ", banned=" + banned + "]";
	}


}
