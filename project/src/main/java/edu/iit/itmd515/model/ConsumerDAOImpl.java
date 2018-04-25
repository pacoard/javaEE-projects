package edu.iit.itmd515.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * ConsumerDAO methods implementation
 * 
 * @author Francisco, Raquel
 *
 */
public class ConsumerDAOImpl implements ConsumerDAO {
	
	// Singleton 
	private static ConsumerDAOImpl instance;
	public ConsumerDAOImpl () {}
	public static ConsumerDAOImpl getInstance() {
		if (instance == null)
			instance = new ConsumerDAOImpl();
		return instance;
	}
	
	public Consumer createConsumer(String email, String password, String name, String phone, String cardNumber,
			String location, double rating, int banned) {
		EntityManager em = EMFService.get().createEntityManager();
		Consumer c = new Consumer(email, password, name, phone, cardNumber, location, rating,banned);
		em.persist(c);
		em.close();
		return c;
	}
	public List<Consumer> getAllConsumers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Consumer c");
		List<Consumer> cs = q.getResultList();
		System.out.println(cs.toString());
		em.close();
		return cs;
	}
	public Long getConsumerId(Consumer c) {
		Long id = 0L;
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Consumer c WHERE c.email= :email AND c.password= :password");
		q.setParameter("email", c.getEmail());
		q.setParameter("password", c.getPassword());
		try{
			Consumer cn = (Consumer) q.getSingleResult();
			id = cn.getId();
		}catch (NoResultException e){
			System.out.println("This user does not exist");
		}
		em.close();
		return id;
	}
	public void updateConsumer(Consumer c) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(c);
		em.close();
	}
	public void deleteAllConsumers() {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("TRUNCATE TABLE Consumer").executeUpdate();
		em.close();
	}
	public Object getConsumerById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Consumer c = em.find(Consumer.class, id);
		em.close();
		return c;
	}
	public void deleteConsumerById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Consumer c = em.find(Consumer.class, id);
		em.remove(c);
		em.close();
	}
	
	
}
