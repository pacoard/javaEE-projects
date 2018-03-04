package edu.iit.itmd515.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * DriverDAO methods implementation
 * 
 * @author Francisco, Raquel
 *
 */
public class DriverDAOImpl implements DriverDAO {
	
	// Singleton 
	private static DriverDAOImpl instance;
	private DriverDAOImpl () {}
	public static DriverDAOImpl getInstance() {
		if (instance == null)
			instance = new DriverDAOImpl();
		return instance;
	}
	
	public Driver createDriver(String email, String password, String name, String phone, String status,
			String location, double rating) {
		EntityManager em = EMFService.get().createEntityManager();
		Driver d = new Driver(email, password, name, phone, status, location, rating);
		em.persist(d);
		em.close();
		return d;
	}
	public List<Driver> getAllDrivers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM Drivers m");
		List<Driver> ds = q.getResultList();
		em.close();
		return ds;
	}
	public void updateDriver(Driver d) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(d);
		em.close();
	}
	public void deleteAllDrivers() {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("DELETE FROM Drivers e").executeUpdate();
		em.close();
	}
	public void deleteDriverById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Driver d = em.find(Driver.class, id);
		em.remove(d);
		em.close();
	}
	
	
}
