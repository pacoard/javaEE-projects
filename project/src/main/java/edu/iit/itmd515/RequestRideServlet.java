package edu.iit.itmd515;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;

import edu.iit.itmd515.model.Administrator;
import edu.iit.itmd515.model.AdministratorDAO;
import edu.iit.itmd515.model.AdministratorDAOImpl;
import edu.iit.itmd515.model.Consumer;
import edu.iit.itmd515.model.ConsumerDAO;
import edu.iit.itmd515.model.ConsumerDAOImpl;
import edu.iit.itmd515.model.Driver;
import edu.iit.itmd515.model.DriverDAO;
import edu.iit.itmd515.model.DriverDAOImpl;
import edu.iit.itmd515.model.Request;

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
 * Servlet that attends to the URL /request-ride
 *
 * @author Raquel, Francisco
 *
 */
@WebServlet("/request-ride")
public class RequestRideServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Long idR = 0L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		if (req.getSession().getAttribute("role") != "consumer") {
			req.getSession().setAttribute("content", "");
			RequestDispatcher view = req.getRequestDispatcher("forbidden.jsp");
			view.forward(req,res);
		} else {
			req.getSession().setAttribute("content", "request-ride");
			RequestDispatcher view = req.getRequestDispatcher("request-ride.jsp");
			view.forward(req,res);
		}
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//doGet(request,response);
		req.getSession().setAttribute("content", "request-ride");
		req.getSession().setAttribute("error_message", "");
		
		int distance = 0;
		
		String origin = req.getParameter("origin");
		String destination = req.getParameter("destination");
		try {
			distance = getMetersDistance(origin, destination);
		} catch (Exception e) {
			e.printStackTrace();
			returnError("One of the addresses is not valid", req, res);
		}
		
		if (distance < 0) {
			returnError("One of the addresses is not valid", req, res);
		}
		
		String reqType = req.getParameter("requestType");
		if ("".equals(reqType) || "NONE".equals(reqType)) {
			returnError("Enter ride type", req, res);
		}
		
		// Meter a la base de datos la request: origin, destination, reqType, int distance o cost
		int cost = 2; // base fare
		cost += distance/1000 * 2; // add $2 per km
		
		Request r = new Request();
		r.setOrigin(origin);
		r.setDestination(destination);
		r.setDistance(String.valueOf(distance));
		r.setPrice(String.valueOf(cost));
		r.setType(reqType);
		saveRequest(r);
		RequestDispatcher view = req.getRequestDispatcher("request-ride.jsp");
		req.getSession().setAttribute("ok_message", "Changes saved successfully.The distance is: "+ distance/1000 + "km and the cost is: "+ cost + "$");
		view.forward(req,res);
		
	}
	
	public boolean saveRequest(Request r){
	     Session session = HibernateUtil.openSession();
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         session.save(r);
	         System.out.println("Saved request:" + r.toString());
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	         return false;
	     } finally {
	         session.close();
	     } 
	     return true;
	}
	
	private void returnError(String errorMsg, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getSession().setAttribute("error_message", errorMsg);
		RequestDispatcher view = req.getRequestDispatcher("request-ride.jsp");
		view.forward(req,res);
	}
	
	public static int getMetersDistance(String origin, String destination) throws Exception {
	    // build a URL
	    String s = "https://maps.googleapis.com/maps/api/distancematrix/json?"
	    		+ "origins=" + URLEncoder.encode(origin, "UTF-8")
	    		+ "&destinations=" + URLEncoder.encode(destination, "UTF-8")
	    		+ "&mode=driving";

	    URL url = new URL(s);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
	 
	    // build a JSON object
	    JSONObject obj = new JSONObject(str);
	    if (! obj.getString("status").equals("OK"))
	        return -1;
	 
	    // Find distance in received JSON
	    JSONObject res = obj.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0);
	    
	    
	    return Integer.parseInt(res.getJSONObject("distance").getString("value"));
	}
	
}
