package edu.iit.itmd515.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ForeignKey;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CascadeType;
 

// TODO import constraints


/**
 * Definition of table Cars
 * 
 * @author Francisco, Raquel
 *
 */
@Entity
@Table(name = "Cars")
public class Car implements java.io.Serializable {
	
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//One car belongs to one driver
	@OneToOne
	private Driver driver;
	private String brand;
	private int seats;
	private String color;
	@Column(unique = true)
	private String plate;
	
	// Constructor (cannot have parameters)
	public Car() {}

	/**
	 * Pseudo-constructor
	 * 
	 * @param driverId
	 * @param brand
	 * @param seats
	 * @param color
	 * @param plate
	 */
	public Car(String brand, int seats, String color, String plate) {
		super();
		this.brand = brand;
		this.seats = seats;
		this.color = color;
		this.plate = plate;
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


	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", seats=" + seats + ", color=" + color
				+ ", plate=" + plate + "]";
	}
}
