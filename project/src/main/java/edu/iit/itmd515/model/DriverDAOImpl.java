package edu.iit.itmd515.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	public DriverDAOImpl () {}
	public static DriverDAOImpl getInstance() {
		if (instance == null)
			instance = new DriverDAOImpl();
		return instance;
	}
	
	public Driver createDriver(String email, String password, String name, String phone, String status,
			String location, double rating, int suspended) {
		EntityManager em = EMFService.get().createEntityManager();
		Driver d = new Driver(email, password, name, phone, status, location, rating, suspended);
		em.persist(d);
		em.close();
		return d;
	}
	public List<Driver> getAllDrivers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT d FROM Driver d");
		List<Driver> ds = q.getResultList();
		em.close();
		return ds;
	}
	public List<Request> getAllRequests() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT r FROM Request r");
		List<Request> rs = q.getResultList();
		em.close();
		return rs;
	}
	public Long getDriverId(Driver d) {
		Long id = 0L;
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT d FROM Driver d WHERE d.email= :email AND d.password= :password");
		q.setParameter("email", d.getEmail());
		q.setParameter("password", d.getPassword());
		try{
			Driver dn = (Driver) q.getSingleResult();
			id = dn.getId();
		}catch (NoResultException e){
			System.out.println("This user does not exist");
		}
		em.close();
		return id;
	}
	public void updateDriver(Driver d) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(d);
		em.close();
	}
	public void deleteAllDrivers() {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("TRUNCATE TABLE Driver").executeUpdate();
		em.close();
	}
	public Object getDriverById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Driver d = em.find(Driver.class, id);
		em.close();
		return d;
	}
	public void deleteDriverById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Driver d = em.find(Driver.class, id);
		em.remove(d);
		em.close();
	}
	
	
}
