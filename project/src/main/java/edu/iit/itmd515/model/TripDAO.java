package edu.iit.itmd515.model;

import java.util.List;

/**
 * Interface to Trips database
 * 
 * @author Francisco, Raquel
 *
 */
public interface TripDAO {

	/**
	 * Create method
	 * 
	 * @param consumerId
	 * @param driverId
	 * @param distance
	 * @param dropoffLocation
	 * @param pickupLocation
	 * @param price
	 * @return created Trip
	 */
	public Trip createTrip(double distance, String dropoffLocation, String pickupLocation,
			double price);
	
	/**
	 * Read method
	 * 
	 * @return List of Trips
	 */
	public List<Trip> getAllTrips();
	
	/**
	 * Update method
	 * 
	 * @param consumerId
	 * @param driverId
	 * @param distance
	 * @param dropoffLocation
	 * @param pickupLocation
	 * @param price
	 * @return updated Trip
	 */
	public void updateTrip(Trip t);
	
	/**
	 *  Delete all method
	 */
	public void deleteAllTrips();
	
	/**
	 * Delete by ID method
	 * 
	 * @param id
	 */
	public void deleteTripsById(Long id);
}

