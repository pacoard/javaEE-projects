package edu.iit.itmd515.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Definition of table Administrator
 * 
 * @author Francisco, Raquel
 *
 */

@Entity
@Table(name = "Administrator")
public class Administrator implements java.io.Serializable {
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String password;
	
	//The administrator can ban many consumers
	@OneToMany
	private List<Consumer> consumers = new ArrayList<Consumer>();
	//The administrator can suspend many drivers
	@OneToMany
	private List<Driver> drivers = new ArrayList<Driver>();
	
	// Constructor (cannot have parameters)
	public Administrator() {}

	/**
	 * Pseudo-constructor
	 * 
	 * @param email
	 * @param password
	 * @param consumers
	 * @param drivers
	 */
	public Administrator(String email, String password, List<Consumer> consumers, List<Driver> drivers) {
		super();
		this.email = email;
		this.password = password;
		this.consumers = consumers;
		this.drivers = drivers;
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
	 * @return the consumers
	 */
	public List<Consumer> getConsumers() {
		return consumers;
	}
	/**
	 * @param consumers the consumers to set
	 */
	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}
	/**
	 * @return the drivers
	 */
	public List<Driver> getDrivers() {
		return drivers;
	}
	/**
	 * @param drivers the drivers to set
	 */
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", email=" + email + ", password=" + password + ", consumers=" + consumers
				+ ", drivers=" + drivers + "]";
	}
	
	
}
