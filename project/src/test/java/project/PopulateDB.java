package project;

import javax.persistence.EntityManager;

import edu.iit.itmd515.model.Consumer;
import edu.iit.itmd515.model.ConsumerDAO;
import edu.iit.itmd515.model.ConsumerDAOImpl;
import edu.iit.itmd515.model.EMFService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.mapping.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * PopulateDB implementation for parsing XML file into DB
 * 
 * @author Francisco, Raquel
 *
 */

public class PopulateDB {

//
//	public static void main(String[] args) {
//		
//		ConsumerDAO consumer_dao = ConsumerDAOImpl.getInstance();
//		
//		Consumer con1 = new Consumer("consumer1", "password1", "name1", "phone1", 99999999, "location1", 4.3);
//		System.out.println(con1.toString());
//		
//		consumer_dao.createConsumer("consumer1", "password1", "name1", "phone1", 99999999, "location1", 4.3);
//		
//		consumer_dao.getAllConsumers().toString();
//	}

	
	 public static void main(String argv[]) {

		    try {

		        //Connection conn = stablishConnection(); //Stablish connection with JDBC
		        //conn.createStatement().execute(....); //Creation of the DB tables
		 
		        File fXmlFile = new File("src/test/java/project/data.xml");

		        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		        Document doc = dBuilder.parse(fXmlFile);
		        
		        doc.getDocumentElement().normalize();

		        Node rootElement = doc.getFirstChild(); //We get the root element of the tree
		        System.out.println("Root element: "+ doc.getDocumentElement());
		        
		        
		        //
		        NodeList consList = doc.getElementsByTagName("consumer");
		        NodeList drivList = doc.getElementsByTagName("driver");
		        NodeList carList = doc.getElementsByTagName("car");
		        NodeList reqList = doc.getElementsByTagName("request");
		        NodeList tripList = doc.getElementsByTagName("trip");

		        
		        //Loop through consumer elements
		        for (int i = 0 ; i < consList.getLength() ; i++) {
		            Element driver = (Element)consList.item(i);
					System.out.println("email: " + driver.getElementsByTagName("email").item(0).getTextContent());
					System.out.println("password: " + driver.getElementsByTagName("password").item(0).getTextContent());
					System.out.println("name : " + driver.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("phone_number : " + driver.getElementsByTagName("phoneNumber").item(0).getTextContent());
					System.out.println("card_number : " + driver.getElementsByTagName("cardNumber").item(0).getTextContent());
					System.out.println("location : " + driver.getElementsByTagName("location").item(0).getTextContent());
					System.out.println("rating : " + driver.getElementsByTagName("rating").item(0).getTextContent());
					
			        //Prepare the insertion into SQL statement for each table
			       /* PreparedStatement stmt = conn.prepareStatement("INSERT INTO consumer(\n" +
			                  "  email, password, name, phone_num, card_num,\n" +
			                  "  location, rating)\n" +
			                  "  VALUES(?, ?, ?, ?, ?,?, ?)");
					*/
					// List to insert in the statement
		            java.util.List<String> columns = Arrays.asList(driver.getElementsByTagName("email").item(0).getTextContent(),
		            		driver.getElementsByTagName("password").item(0).getTextContent(),
		            		driver.getElementsByTagName("name").item(0).getTextContent(),
		            		driver.getElementsByTagName("phoneNumber").item(0).getTextContent(),
		            		driver.getElementsByTagName("cardNumber").item(0).getTextContent(),
		            		driver.getElementsByTagName("location").item(0).getTextContent(),
		            		driver.getElementsByTagName("rating").item(0).getTextContent());
		            
		            //Insert values in the prepared statement
		            for (int n = 0 ; n < columns.size() ; n++) {
		                //stmt.setString(n+1, columns.get(n));
		            }
		            //stmt.execute();
					//stm.close();
		        }
		        
		        //Loop through driver elements
		        for (int i = 0 ; i < drivList.getLength() ; i++) {
		            Element driver = (Element)consList.item(i);
					System.out.println("email: " + driver.getElementsByTagName("email").item(0).getTextContent());
					System.out.println("password: " + driver.getElementsByTagName("password").item(0).getTextContent());
					System.out.println("name : " + driver.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("phone_number : " + driver.getElementsByTagName("phoneNumber").item(0).getTextContent());
					System.out.println("status : " + driver.getElementsByTagName("status").item(0).getTextContent());
					System.out.println("location : " + driver.getElementsByTagName("location").item(0).getTextContent());
					System.out.println("rating : " + driver.getElementsByTagName("rating").item(0).getTextContent());
			        
					//Prepare the insertion into SQL statement for each table
			        //PreparedStatement stmt = conn.prepareStatement("INSERT INTO driver(\n" +
			                  //"  email, password, name, phone_num, status,\n" +
			                  //"  location, rating)\n" +
			                  //"  VALUES(?, ?, ?, ?, ?,?, ?)");
					
					// List to insert in the statement
/*		            java.util.List<String> columns = Arrays.asList(driver.getElementsByTagName("email").item(0).getTextContent(),
		            		driver.getElementsByTagName("password").item(0).getTextContent(),
		            		driver.getElementsByTagName("name").item(0).getTextContent(),
		            		driver.getElementsByTagName("phoneNumber").item(0).getTextContent(),
		            		driver.getElementsByTagName("status").item(0).getTextContent(),
		            		driver.getElementsByTagName("location").item(0).getTextContent(),
		            		driver.getElementsByTagName("rating").item(0).getTextContent());*/
					//Insert values in the prepared statement
//		            for (int n = 0 ; n < columns.size() ; n++) {
//		                stmt.setString(n+1, columns.get(n));
//		            }
//		            stmt.execute();
//					stmt.close();
		        }
		        
		        //Loop through car elements --> It has attributes!!
		        for (int i = 0 ; i < carList.getLength() ; i++) {
		            Element car = (Element)consList.item(i);
					System.out.println("driverId: " + car.getElementsByTagName("driverId").item(0).getTextContent());
					System.out.println("brand: " + car.getElementsByTagName("brand").item(0).getTextContent());
					System.out.println("seats : " + car.getElementsByTagName("seats").item(0).getTextContent());
					System.out.println("color : " + car.getElementsByTagName("color").item(0).getTextContent());
					System.out.println("plate : " + car.getElementsByTagName("plate").item(0).getTextContent());
					
			        //Prepare the insertion into SQL statement for each table
			        //PreparedStatement stmt = conn.prepareStatement("INSERT INTO car(\n" +
			                  //"  driverId, brand, seats, color, plate)\n" +
			                  //"  VALUES(?, ?, ?, ?, ?)");
					
					// List to insert in the statement
/*		            java.util.List<String> columns = Arrays.asList(driver.getElementsByTagName("driverId").item(0).getTextContent(),
		            		driver.getElementsByTagName("brand").item(0).getTextContent(),
		            		driver.getElementsByTagName("seats").item(0).getTextContent(),
		            		driver.getElementsByTagName("color").item(0).getTextContent(),
		            		driver.getElementsByTagName("plate").item(0).getTextContent());*/
//		            for (int n = 0 ; n < columns.size() ; n++) {
//		                stmt.setString(n+1, columns.get(n));
//		            }
//		            stmt.execute();
//					stmt.close();
		        }
		        
		        //Loop through request elements
		        for (int i = 0 ; i < reqList.getLength() ; i++) {
		            Element request = (Element)consList.item(i);
					System.out.println("consumerId: " + request.getElementsByTagName("consumerId").item(0).getTextContent());
					System.out.println("location: " + request.getElementsByTagName("location").item(0).getTextContent());
					System.out.println("time : " + request.getElementsByTagName("time").item(0).getTextContent());
					System.out.println("type : " + request.getElementsByTagName("type").item(0).getTextContent());
					
			        //Prepare the insertion into SQL statement for each table
			        //PreparedStatement stmt = conn.prepareStatement("INSERT INTO request(\n" +
			                  //"  consumerId, location, time, type)\n" +
			                  //"  VALUES(?, ?, ?, ?)");
					
					// List to insert in the statement
/*		            java.util.List<String> columns = Arrays.asList(driver.getElementsByTagName("consumerId").item(0).getTextContent(),
		            		driver.getElementsByTagName("location").item(0).getTextContent(),
		            		driver.getElementsByTagName("time").item(0).getTextContent(),
		            		driver.getElementsByTagName("type").item(0).getTextContent());*/
//		            for (int n = 0 ; n < columns.size() ; n++) {
//		                stmt.setString(n+1, columns.get(n));
//		            }
//		            stmt.execute();
//					stmt.close();
		        }
		        
		        //Loop through request elements
		        for (int i = 0 ; i < tripList.getLength() ; i++) {
		            Element trip = (Element)consList.item(i);
					System.out.println("consumerId: " + trip.getElementsByTagName("consumerId").item(0).getTextContent());
					System.out.println("driverId: " + trip.getElementsByTagName("driverId").item(0).getTextContent());
					System.out.println("distance : " + trip.getElementsByTagName("distance").item(0).getTextContent());
					System.out.println("pickupLocation : " + trip.getElementsByTagName("pickupLocation").item(0).getTextContent());
					System.out.println("dropoffLocation : " + trip.getElementsByTagName("dropoffLocation").item(0).getTextContent());
					System.out.println("price : " + trip.getElementsByTagName("price").item(0).getTextContent());
					
			        //Prepare the insertion into SQL statement for each table
			        //PreparedStatement stmt = conn.prepareStatement("INSERT INTO trip(\n" +
			                  //"  consumerId, driverId, distance, pickupLocation,\n" +
							  //"  dropoffLocation, price)\n" +
			                  //"  VALUES(?, ?, ?, ?,?,?)");
					
					// List to insert in the statement
/*		            java.util.List<String> columns = Arrays.asList(driver.getElementsByTagName("consumerId").item(0).getTextContent(),
		            		driver.getElementsByTagName("driverId").item(0).getTextContent(),
		            		driver.getElementsByTagName("distance").item(0).getTextContent(),
		            		driver.getElementsByTagName("pickupLocation").item(0).getTextContent(),
		            		driver.getElementsByTagName("dropoffLocation").item(0).getTextContent(),
		            		driver.getElementsByTagName("price").item(0).getTextContent());*/
//		            for (int n = 0 ; n < columns.size() ; n++) {
//		                stmt.setString(n+1, columns.get(n));
//		            }
//		            stmt.execute();
//					stmt.close();
		        }
		        
			  } catch (IOException io) {
					System.out.println(io.getMessage());
			  }catch (Exception e){
				  System.out.println(e.getStackTrace());
			  }
	 }
	 
	  public static Connection stablishConnection(){
		  Connection conn = null;
		    try{
		        String dbUrl = "jdbc:mysql://localhost/testing";
		        String uname = "..";
		        String pwd = "..";
		        conn = DriverManager.getConnection(dbUrl, uname, pwd);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			return conn;
	  }
}
