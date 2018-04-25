package edu.iit.itmd515;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.fasterxml.classmate.AnnotationConfiguration;

import edu.iit.itmd515.model.Administrator;
import edu.iit.itmd515.model.AdministratorDAO;
import edu.iit.itmd515.model.AdministratorDAOImpl;
import edu.iit.itmd515.model.Consumer;
import edu.iit.itmd515.model.ConsumerDAO;
import edu.iit.itmd515.model.ConsumerDAOImpl;
import edu.iit.itmd515.model.Driver;
import edu.iit.itmd515.model.DriverDAO;
import edu.iit.itmd515.model.DriverDAOImpl;
/**
 * Java Bean class for managing hibernate sessions and change the DB content
 * 
 * @author Raquel, Francisco
 *
 */

public class HibernateUtil {
	
/*	public static void main(String[] args)
		
		//Set values for an entity
		Car car1 = new Car();
		car1.setBrand("Toyota");
		car1.setColor("black");
		car1.setPlate("ABC345234");
		car1.setSeats(4);
		
		Driver driver1 = new Driver();
		driver1.setEmail("pepe@gmail.com");
		driver1.setLocation("kkkkkkk");
		driver1.setName("Pepe Gonzalez");
		driver1.setPassword("pepe1234");
		driver1.setPhone("3334567898");
		driver1.setRating(4.5);
		driver1.setStatus("available");
		
		//Relationship between objects
		car1.setDriver(driver1);
		driver1.setCar(car1);*/
		
		
/*		try{
			//Init session with the DB at localhost
			Configuration con = new Configuration().configure();
			SessionFactory sf= con.buildSessionFactory();
			Session session = sf.openSession();
			System.out.println("Connection made to the DB");
			
			//create transaction
			Transaction tx =session.beginTransaction();
			
			session.save(car1);
			session.save(driver1);
	
			//end the transaction
			tx.commit();
	
			//Closing the session
			session.close();
			
		
		}catch(Exception e){
			e.printStackTrace();
		}

	}*/
	static Configuration con;
	static SessionFactory sf;
	static Session session;
	static ServiceRegistry serviceRegistry;
    //private static final SessionFactory sessionFactory;
static{
    try {
		con = new Configuration().configure();
    	//serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		//sf= con.buildSessionFactory(serviceRegistry);
		sf = new Configuration().configure().buildSessionFactory();
		System.out.println("SESSION factory");

    } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}
    public static Session openSession() {
        return session = sf.openSession();
    }

}
