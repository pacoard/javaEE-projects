package edu.iit.itmd515;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;

import edu.iit.itmd515.model.AdministratorDAO;
import edu.iit.itmd515.model.AdministratorDAOImpl;
import edu.iit.itmd515.model.DriverDAO;
import edu.iit.itmd515.model.DriverDAOImpl;

import edu.iit.itmd515.model.Consumer;
import edu.iit.itmd515.model.Driver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geo.google.GeoAddressStandardizer;
import geo.google.GeoException;
import geo.google.datamodel.GeoUsAddress;

import edu.iit.itmd515.model.Request;
import edu.iit.itmd515.model.RequestDAO;
import edu.iit.itmd515.model.RequestDAOImpl;
import edu.iit.itmd515.model.Trip;

/**
 * Servlet that attends to the URL /dispatch-ride
 *
 * @author Raquel, Francisco
 *
 */
@WebServlet("/dispatch-ride")
public class DispatchRideServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private List<Request> requests = new ArrayList<Request>();
	private Driver d;
	private Trip trip;
	private Request request;
	private String id;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		findRides();
	    req.setAttribute("requests", requests);
	    id = (String) req.getParameter("id");
		if (req.getSession().getAttribute("role") != "driver") {
			req.getSession().setAttribute("content", "");
			RequestDispatcher view = req.getRequestDispatcher("forbidden.jsp");
			view.forward(req,res);
		} else {
			if(id !=null){
				Long idDr=(Long)req.getSession().getAttribute("id");
				//findRequest(id);
				//saveTrip(request, idDr);
			}
			req.getSession().setAttribute("content", "dispatch-ride");
			RequestDispatcher view = req.getRequestDispatcher("dispatch-ride.jsp");
			view.forward(req,res);
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	public void findRides(){
	     Session session = HibernateUtil.openSession();
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         DriverDAO d = new DriverDAOImpl();
	         requests = d.getAllRequests();
	         System.out.println(requests.toString());
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	     } finally {
	         session.close();
	     } 

	}
	public void findRequest(String id){
	     Session session = HibernateUtil.openSession();
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         RequestDAO r = new RequestDAOImpl();
	         request = (Request) r.getRequestByid(Long.parseLong(id));
	         r.deleteRequestsById(Long.valueOf(id));
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	     } finally {
	         session.close();
	     } 

	}
	public void saveTrip(Request r,Long idDriver){
	     Session session = HibernateUtil.openSession();
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         //Add to the driver list
	         DriverDAO driver = new DriverDAOImpl();
	         System.out.println(idDriver);
/*	         Driver temp = new Driver();
	         d = (Driver) driver.getDriverById(idDriver);
	         List<Request> requests= d.getRequests();
	         requests.add(r);
	         d.setRequests(requests);
	         Driver update = (Driver)session.merge(d);*/
	         //Create trip
	         Trip t = new Trip();
	         //trip.setDriver(d);
	         trip.setDistance(Double.valueOf(r.getDistance()));
	         trip.setDropoffLocation(r.getDestination());
	         trip.setPrice(Double.valueOf(r.getPrice()));
	         trip.setPickupLocation(r.getOrigin());
	         session.save(t);
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	     } finally {
	         session.close();
	     } 
}}
