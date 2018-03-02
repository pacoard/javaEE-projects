package edu.iit.itmd515.model;

import java.util.List;
import javax.persistence.EntityManager;
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
	private ConsumerDAOImpl () {}
	public static ConsumerDAOImpl getInstance() {
		if (instance == null)
			instance = new ConsumerDAOImpl();
		return instance;
	}
	public Consumer createConsumer(String email, String password, String name, String phone, int cardNumber,
			String location, double rating) {
		EntityManager em = EMFService.get().createEntityManager();
		Consumer c = new Consumer(email,password,name,phone,cardNumber,location,rating);
		em.persist(c);
		em.close();
		return c;
	}
	public List<Consumer> getAllConsumers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM Consumers m");
		List<Consumer> cs = q.getResultList();
		em.close();
		return cs;
	}
	public void updateConsumer(Consumer c) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(c);
		em.close();
	}
	public void deleteAllConsumers() {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("DELETE FROM Consumers e").executeUpdate();
		em.close();
	}
	public void deleteConsumerById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Consumer c = em.find(Consumer.class, id);
		em.remove(c);
		em.close();
	}
	
	
}