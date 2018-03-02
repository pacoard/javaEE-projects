package edu.iit.itmd515.model;

import java.util.List;

/**
 * Interface to Consumer database
 * 
 * @author Francisco, Raquel
 *
 */
public interface ConsumerDAO {
	
	/**
	 * Create method
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param phone
	 * @param cardNumber
	 * @param location
	 * @param rating
	 * @return created Consumer
	 */
	public Consumer createConsumer(String email, String password, String name, String phone, int cardNumber, String location, int rating);
	
	/**
	 * Read method
	 * 
	 * @return List of Consumer
	 */
	public List<Consumer> getAllConsumers();
	
	/**
	 * Update method
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param phone
	 * @param cardNumber
	 * @param location
	 * @param rating
	 * @return updated Consumer
	 */
	public Consumer updateConsumer(String email, String password, String name, String phone, int cardNumber, String location, int rating);
	
	/**
	 *  Delete all method
	 */
	public void deleteAllConsumers();
	
	/**
	 * Delete by ID method
	 * 
	 * @param id
	 */
	public void deleteConsumerById(Long id);

}
