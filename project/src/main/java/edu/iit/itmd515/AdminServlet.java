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


/**
 * Servlet that attends to the URL /profile
 *
 * @author Raquel, Francisco
 *
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private List<Consumer> consumers = new ArrayList<Consumer>();
	private List<Driver> drivers = new ArrayList<Driver>();
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		 findDrivers();
		 findConsumers();
	     req.setAttribute("drivers", drivers);
	     req.setAttribute("consumers", consumers);
		if (req.getSession().getAttribute("role") != "admin") {
			req.getSession().setAttribute("content", "");
			RequestDispatcher view = req.getRequestDispatcher("forbidden.jsp");
			view.forward(req,res);
		} else {
			req.getSession().setAttribute("content", "admin");
			RequestDispatcher view = req.getRequestDispatcher("admin.jsp");
			view.forward(req,res);
		}
	}
	
	public void findDrivers(){
	     Session session = HibernateUtil.openSession();
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         AdministratorDAO a = new AdministratorDAOImpl();
	         drivers = a.getAllDrivers();
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
	public void findConsumers(){
	     Session session = HibernateUtil.openSession();
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         AdministratorDAO a = new AdministratorDAOImpl();
	         consumers = a.getAllConsumers();
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
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
