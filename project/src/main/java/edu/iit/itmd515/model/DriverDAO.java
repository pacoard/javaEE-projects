package edu.iit.itmd515.model;

import java.util.List;

/**
 * Interface to Consumer database
 * 
 * @author Francisco, Raquel
 *
*/
	public interface DriverDAO {
		
		/**
		 * Create method
		 * 
		 * @param email
		 * @param password
		 * @param name
		 * @param phone
		 * @param status
		 * @param location
		 * @param rating
		 * @return created Driver
		 */
		public Driver createDriver(String email, String password, String name, String phone, String status, String location, double rating);
		
		/**
		 * Read method
		 * 
		 * @return List of Driver
		 */
		public List<Driver> getAllDrivers();
		
		/**
		 * Update method
		 * 
		 * @param email
		 * @param password
		 * @param name
		 * @param phone
		 * @param status
		 * @param location
		 * @param rating
		 * @return updated Consumer
		 */
		public void updateDriver(Driver v);
		
		/**
		 *  Delete all method
		 */
		public void deleteAllDrivers();
		
		/**
		 * Delete by ID method
		 * 
		 * @param id
		 */
		public void deleteDriverById(Long id);

	}

