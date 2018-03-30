package edu.iit.itmd515.model;

import java.util.List;

import javax.persistence.EntityManager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * RequestDAO methods implementation
 * 
 * @author Francisco, Raquel
 *
 */

public class RequestDAOImpl implements RequestDAO{

	// Singleton 
	private static RequestDAOImpl instance;
	private RequestDAOImpl () {}
	public static RequestDAOImpl getInstance() {
		if (instance == null)
			instance = new RequestDAOImpl();
		return instance;
	}
	
	public Request createRequest(Long id,String location, String requestTime, String requestType) {
		EntityManager em = EMFService.get().createEntityManager();
		Request r = new Request(id,location, requestTime, requestType);
		em.persist(r);
		em.close();
		return r;
	}
	public List<Request> getAllRequests() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM Requests m");
		List<Request> rs = q.getResultList();
		em.close();
		return rs;
	}
	public void updateRequest(Request r) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(r);
		em.close();
	}
	public void deleteAllRequests() {
		EntityManager em = EMFService.get().createEntityManager();
		em.createQuery("DELETE FROM Requests e").executeUpdate();
		em.close();
	}
	public void deleteRequestsById(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		Request r = em.find(Request.class, id);
		em.remove(r);
		em.close();
	}
	
}