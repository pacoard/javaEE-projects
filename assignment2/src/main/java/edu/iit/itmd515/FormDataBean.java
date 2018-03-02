package edu.iit.itmd515;

import java.io.Serializable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * Java Bean class that holds and models the information entered in a form
 * 
 * @author Raquel, Francisco
 *
 */
public class FormDataBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// frontend validation
	private String name; 
	// frontend validation
	private String ssn;
	//@Pattern(regexp = "^\d{5}(?:[-\s]\d{4})?$") //https://stackoverflow.com/questions/2577236/regex-for-zip-code
	@Length(min = 5, max = 5, message = "Zip Code is not valid")	
	private String zipCode; // bean validation
	//@Pattern(regexp = "(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Length(min=7, message = "Email is too short")
	@Email(message = "Email is not valid")
	private String email;
	// frontend validation
	private String address;
	// frontend validation
	private String city;
	// frontend validation
	private String state;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param ssn
	 * @param zipCode
	 * @param email
	 * @param address
	 * @param city
	 * @param state
	 */
	public FormDataBean(String name, String ssn, String zipCode, String email, String address, String city, String state) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.zipCode = zipCode;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entered info: [name=" + name + ", ssn=" + ssn + ", zipCode=" + zipCode + ", email=" + email
				+ ", address=" + address + ", city=" + city + ", state=" + state + "]";
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
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
