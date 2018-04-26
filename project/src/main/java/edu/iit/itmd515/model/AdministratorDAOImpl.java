package edu.iit.itmd515.model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	public AdministratorDAOImpl () {}
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

	public List<Driver> getAllDrivers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT d FROM Driver d");
		List<Driver> ds = q.getResultList();
		em.close();
		return ds;
	}
	
	public List<Consumer> getAllConsumers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Consumer c");
		List<Consumer> cs = q.getResultList();
		em.close();
		return cs;
	}
	
	public Long getAdministratorId(Administrator a) {
		Long id = 0L;
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT a FROM Administrator a WHERE a.email= :email AND a.password= :password");
		q.setParameter("email", a.getEmail());
		q.setParameter("password", a.getPassword());
		try{
			Administrator ad = (Administrator) q.getSingleResult();
			id = ad.getId();
		}catch (NoResultException e){
			System.out.println("This user does not exist");
		}
		em.close();
		return id;
	}
	
	public List<Consumer> getBannedConsumers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Consumer c WHERE c.banned= :ban");
		q.setParameter("ban", 1);
		List<Consumer> cs = q.getResultList();
		em.close();
		return cs;
	}

	public List<Driver> getBannedDrivers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT d FROM Driver d WHERE d.suspended= :sus");
		q.setParameter("sus", 1);
		List<Driver> ds = q.getResultList();
		em.close();
		return ds;
	}

	public void deleteConsumer(Consumer consumer) {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("UPDATE Consumer c SET banned=0 WHERE id="+consumer.getId()).executeUpdate();
		em.close();
	}

	public void deleteDriver(Driver driver) {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("UPDATE Driver d SET suspended=0 WHERE id="+driver.getId()).executeUpdate();
		em.close();
	}

	public void banConsumer(Consumer consumer) {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("UPDATE Consumer c SET banned=1 WHERE id="+consumer.getId()).executeUpdate();
		em.close();
		
	}

	public Object getAdministratorById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Administrator a = em.find(Administrator.class, id);
		em.close();
		return a;
	}
	
	public void suspendDriver(Driver driver) {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("UPDATE Driver d SET suspended=1 WHERE id="+driver.getId()).executeUpdate();
		em.close();
	}

}
