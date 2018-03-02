package edu.iit.itmd515.model;

import java.util.ArrayList;
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
			String location, int rating) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Consumer> getAllConsumers() {
		// TODO Auto-generated method stub
		return null;
	}
	public Consumer updateConsumer(String email, String password, String name, String phone, int cardNumber,
			String location, int rating) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteAllConsumers() {
		// TODO Auto-generated method stub
		
	}
	public void deleteConsumerById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
