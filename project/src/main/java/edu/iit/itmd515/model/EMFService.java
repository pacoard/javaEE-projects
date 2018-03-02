package edu.iit.itmd515.model;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Database transactions manager
 * 
 * @author Francisco, Raquel
 *
 */
public class EMFService {
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EMFService() {
	}
	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
