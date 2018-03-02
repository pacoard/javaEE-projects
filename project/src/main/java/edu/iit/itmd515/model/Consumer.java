package edu.iit.itmd515.model;

/*import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;*/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO import constraints


/**
 * Definition of table CONSUMERS
 * 
 * @author Francisco, Raquel
 *
 */
@Entity
public class Consumer {
	
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private int cardNumber;
	private String location;
	private int rating;
	
	/**
	 * Constructor Consumer
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param phone
	 * @param cardNumber
	 * @param location
	 * @param rating
	 */
	public Consumer(String email, String password, String name, String phone, int cardNumber, String location,
			int rating) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.cardNumber = cardNumber;
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
	public int getCardNumber() {
		return cardNumber;
	}



	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(int cardNumber) {
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
	public int getRating() {
		return rating;
	}



	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Consumer [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", cardNumber=" + cardNumber + ", location=" + location + ", rating=" + rating + "]";
	}
}
