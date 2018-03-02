package project;

import edu.iit.itmd515.model.Consumer;
import edu.iit.itmd515.model.ConsumerDAO;
import edu.iit.itmd515.model.ConsumerDAOImpl;

public class PopulateDB {

	public PopulateDB() {}

	public static void main(String[] args) {
		
		ConsumerDAO consumer_dao = ConsumerDAOImpl.getInstance();
		
		Consumer con1 = new Consumer("consumer1", "password1", "name1", "phone1", 99999999, "location1", 4.3);
		System.out.println(con1.toString());
		
		consumer_dao.createConsumer("consumer1", "password1", "name1", "phone1", 99999999, "location1", 4.3);
		
		consumer_dao.getAllConsumers().toString();
	}

}
