package edu.iit.itmd515.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * TripDAO methods implementation
 * 
 * @author Francisco, Raquel
 *
 */

public class TripDAOImpl implements TripDAO {

	// Singleton 
	private static TripDAOImpl instance;
	private TripDAOImpl () {}
	public static TripDAOImpl getInstance() {
		if (instance == null)
			instance = new TripDAOImpl();
		return instance;
	}
	
	public Trip createTrip(double distance, String dropoffLocation, String pickupLocation,
			double price) {
		EntityManager em = EMFService.get().createEntityManager();
		Trip t = new Trip(distance, dropoffLocation, pickupLocation, price);
		em.persist(t);
		em.close();
		return t;
	}
	public List<Trip> getAllTrips() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT t FROM Trip t");
		List<Trip> ts = q.getResultList();
		em.close();
		return ts;
	}
	public void updateTrip(Trip t) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(t);
		em.close();
	}
	public void deleteAllTrips() {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("TRUNCATE TABLE Trip").executeUpdate();
		em.close();
	}
	public void deleteTripsById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Trip t = em.find(Trip.class, id);
		em.remove(t);
		em.close();
	}

}
