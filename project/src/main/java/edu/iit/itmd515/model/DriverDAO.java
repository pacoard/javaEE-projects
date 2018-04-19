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
		 * @param suspended
		 * @return created Driver
		 */
		public Driver createDriver(String email, String password, String name, String phone, String status, String location, double rating, int suspended);
		
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
		 * @param suspended
		 * @return updated Driver
		 */
		public void updateDriver(Driver v);
		public Long getDriverId(Driver d);
		
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


