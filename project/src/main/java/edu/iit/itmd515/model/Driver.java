package edu.iit.itmd515.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 

// TODO import constraints


/**
 * Definition of table Drivers
 * 
 * @author Francisco, Raquel
 *
 */
@Entity
@Table(name = "Drivers")
public class Driver implements java.io.Serializable {
	
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String status;
	private String location;
	private Double rating;
	
	// Constructor (cannot have parameters)
	public Driver() {}
	
	/**
	 * Pseudo-constructor Driver
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param phone
	 * @param status
	 * @param location
	 * @param rating
	 */
	public Driver(String email, String password, String name, String phone, String status, String location,
			Double rating) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.status = status;
		this.location = location;
		this.rating = rating;
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
	public String getStatus() {
		return status;
	}



	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Consumer [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", status=" + status + ", location=" + location + ", rating=" + rating + "]";
	}
}

