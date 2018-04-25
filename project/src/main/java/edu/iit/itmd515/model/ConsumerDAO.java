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
	 * @param banned
	 * @return created Consumer
	 */
	public Consumer createConsumer(String email, String password, String name, String phone, String cardNumber, String location, double rating, int banned);
	
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
	public void updateConsumer(Consumer c);
	public Long getConsumerId(Consumer c);
	
	/**
	 *  Delete all method
	 */
	public void deleteAllConsumers();
	
	/**
	 * Delete by ID method
	 * 
	 * @param id
	 */
	
	public Object getConsumerById(Long id) ;
	public void deleteConsumerById(Long id);

}
