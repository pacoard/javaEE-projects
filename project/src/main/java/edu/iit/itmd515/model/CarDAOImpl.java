package edu.iit.itmd515.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * CarDAO methods implementation
 * 
 * @author Francisco, Raquel
 *
 */

public class CarDAOImpl implements CarDAO{
	// Singleton 
		private static CarDAOImpl instance;
		private CarDAOImpl () {}
		public static CarDAOImpl getInstance() {
			if (instance == null)
				instance = new CarDAOImpl();
			return instance;
		}
		
		public Car createCar(String brand, int nSeats, String color, String plate) {
			EntityManager em = EMFService.get().createEntityManager();
			Car c = new Car(brand, nSeats, color, plate);
			em.persist(c);
			em.close();
			return c;
		}
		public List<Car> getAllCars() {
			EntityManager em = EMFService.get().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Car c");
			List<Car> cs = q.getResultList();
			em.close();
			return cs;
		}
		public void updateCar(Car c) {
			EntityManager em = EMFService.get().createEntityManager();
			em.merge(c);
			em.close();
		}
		public void deleteAllCars() {
			EntityManager em = EMFService.get().createEntityManager();
			em.createQuery("TRUNCATE TABLE Car").executeUpdate();
			em.close();
		}
		public void deleteCarById(Long id) {
			EntityManager em = EMFService.get().createEntityManager();
			Car c = em.find(Car.class, id);
			em.remove(c);
			em.close();
		}
		
}
