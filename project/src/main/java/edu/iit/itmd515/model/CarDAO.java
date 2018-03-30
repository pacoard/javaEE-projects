package edu.iit.itmd515.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * CarDAO methods 
 * 
 * @author Francisco, Raquel
 *
 */

public interface CarDAO {
	/**
	 * Create method
	 * 
	 * @param brand
	 * @param nSeats
	 * @param color
	 * @param plate
	 * @return created Car
	 */
	public Car createCar(String brand, int nSeats, String color, String plate);
	
	/**
	 * Read method
	 * 
	 * @return List of Cars
	 */
	public List<Car> getAllCars();
	
	/**
	 * Update method
	 * 
	 * @param brand
	 * @param nSeats
	 * @param color
	 * @param plate
	 * @return updated Car
	 */
	public void updateCar(Car c);
	
	/**
	 *  Delete all method
	 */
	public void deleteAllCars();
	
	/**
	 * Delete by ID method
	 * 
	 * @param id
	 */
	public void deleteCarById(Long id);

}
