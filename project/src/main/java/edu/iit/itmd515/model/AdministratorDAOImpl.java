package edu.iit.itmd515.model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * AdministratorDAO methods implementation
 * 
 * @author Francisco, Raquel
 *
 */
public class AdministratorDAOImpl implements AdministratorDAO{
	
	// Singleton 
	private static AdministratorDAOImpl instance;
	private AdministratorDAOImpl () {}
	public static AdministratorDAOImpl getInstance() {
		if (instance == null)
			instance = new AdministratorDAOImpl();
		return instance;
	}
	public Administrator createAdministrator(String email, String password, List<Consumer> consumers,
			List<Driver> drivers) {
		EntityManager em = EMFService.get().createEntityManager();
		Administrator a = new Administrator(email,password,consumers,drivers);
		em.persist(a);
		em.close();
		return a;
	}

	public List<Consumer> getBannedConsumers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT * FROM Consumers WHERE banned=1");
		List<Consumer> cs = q.getResultList();
		em.close();
		return cs;
	}

	public List<Driver> getBannedDrivers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT * FROM Drivers WHERE suspended=1");
		List<Driver> ds = q.getResultList();
		em.close();
		return ds;
	}

	public void deleteConsumer(Consumer consumer) {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("UPDATE Consumers SET banned=0 WHERE id="+consumer.getId()).executeUpdate();
		em.close();
	}

	public void deleteDriver(Driver driver) {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("UPDATE Drivers SET suspended=0 WHERE id="+driver.getId()).executeUpdate();
		em.close();
	}

	public void banConsumer(Consumer consumer) {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("UPDATE Consumer SET banned=1 WHERE id="+consumer.getId()).executeUpdate();
		em.close();
		
	}

	public void suspendDriver(Driver driver) {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("UPDATE Drivers SET suspended=1 WHERE id="+driver.getId()).executeUpdate();
		em.close();
	}

}
