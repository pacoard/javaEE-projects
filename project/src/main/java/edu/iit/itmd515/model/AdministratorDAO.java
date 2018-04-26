package edu.iit.itmd515.model;

import java.util.List;

/**
 * AdministratorDAO methods 
 * 
 * @author Francisco, Raquel
 *
 */
public interface AdministratorDAO {
	/**
	 * Create method
	 * 
	 * @param email
	 * @param password
	 * @param List<Consumer>
	 * @param List<Driver>
	 * @return created Administrator
	 */
	public Administrator createAdministrator(String email, String password, List<Consumer> consumers,List<Driver> drivers);
	
	/**
	 * Read method
	 * 
	 * @return List of Banned consumers
	 */
	public Long getAdministratorId(Administrator a);
	public Object getAdministratorById(Long id);
	public List<Consumer> getBannedConsumers();
	public List<Consumer> getAllConsumers();
	public List<Driver> getAllDrivers();
	
	/**
	 * Read method
	 * 
	 * @return List of Banned drivers
	 */
	public List<Driver> getBannedDrivers();
	
	/**
	 * Write method to delete a banned consumer
	 * 
	 */
	public void deleteConsumer(Consumer consumer);
	
	/**
	 * Write method to delete a suspended driver
	 * 
	 */
	public void deleteDriver(Driver driver);
	
	/**
	 * Write method to insert new banned consumer
	 * 
	 */
	public void banConsumer(Consumer consumer);
	
	/**
	 * Write method to insert new suspended driver
	 * 
	 */
	public void suspendDriver(Driver driver);
	
}
