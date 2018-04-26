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
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		findRides();
	    req.setAttribute("requests", requests);
		if (req.getSession().getAttribute("role") != "driver") {
			req.getSession().setAttribute("content", "");
			RequestDispatcher view = req.getRequestDispatcher("forbidden.jsp");
			view.forward(req,res);
		} else {
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
	
}
