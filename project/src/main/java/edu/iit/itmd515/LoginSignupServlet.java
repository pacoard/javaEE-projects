package edu.iit.itmd515;


import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geo.google.GeoAddressStandardizer;
import geo.google.GeoException;
import geo.google.datamodel.GeoUsAddress;

import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Servlet that attends to the URL /login-signup
 *
 * @author Raquel, Francisco
 *
 */
@WebServlet(name = "LoginSignupServlet",urlPatterns = {"/login-signup"})
public class LoginSignupServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.getSession().setAttribute("content", "login-signup");
		RequestDispatcher view = req.getRequestDispatcher("login-signup.jsp");
		view.forward(req,res);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		//Get parameters from sign up form
		if(request.getParameter("signup") != null){
			String role = request.getParameter("role");
			System.out.println(role);
			if (role.equals("Administrator")){
				Administrator admin = new Administrator();
				admin.setEmail(request.getParameter("email"));
				admin.setPassword(request.getParameter("password"));
				
				result = register(admin); 
			}else if (role.equals("Driver")){
				Driver driver = new Driver();
				driver.setName(request.getParameter("name"));
				driver.setEmail(request.getParameter("email"));
				driver.setPhone(request.getParameter("phone"));
				driver.setPassword(request.getParameter("password"));
				
				result = register(driver); 
			}else if (role.equals("Consumer")){
				Consumer consumer = new Consumer();
				consumer.setName(request.getParameter("name"));
				consumer.setEmail(request.getParameter("email"));
				consumer.setPhone(request.getParameter("phone"));
				consumer.setCardNumber(request.getParameter("card_number"));
				consumer.setPassword(request.getParameter("password"));
				
				result = register(consumer); 
			}else{
				//Pop up message
			}
			
		}else if (request.getParameter("login") != null){
			//Get parameters from log in form (we will have to check at DB
		 	String role = request.getParameter("roleLI");
		 	result = false;
			if (role.equals("Administrator")){
				Administrator admin = new Administrator();
				admin.setEmail(request.getParameter("emailLI"));
				admin.setPassword(request.getParameter("passwordLI"));
				
				result = login(admin); 
			}else if (role.equals("Consumer")){
				Consumer consumer = new Consumer();
				consumer.setEmail(request.getParameter("emailLI"));
				consumer.setPassword(request.getParameter("passwordLI"));
				
				result = login(consumer); 
			}else if (role.equals("Driver")){
				Driver driver = new Driver();
				driver.setEmail(request.getParameter("emailLI"));
				driver.setPassword(request.getParameter("passwordLI"));
				
				result = login(driver); 
			}
		}
	     if(result == true){
	         //request.getSession().setAttribute("user", user);      
	    	 response.sendRedirect("welcome.jsp");
	    	 System.out.println("Login/Registration correct!");
	     }
	     else{
	    	 response.sendRedirect("login-signup.jsp");
	    	 System.out.println("Login/Registration error!");
	     }
		//doGet(request,response);
	}
	
	
	public boolean register(Object user){
	     Session session = HibernateUtil.openSession();
	     System.out.println("Session init for registration");
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         session.save(user);
	         System.out.println("Saved user:" + user.toString());
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
	
	public boolean login(Object user){
	     Session session = HibernateUtil.openSession();
	     System.out.println("Session init for login");
	     Transaction tx = null;
	     Long id = 0L;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         if (user instanceof Consumer){
	        	 ConsumerDAO c = new ConsumerDAOImpl();
	        	 id = c.getConsumerId((Consumer)user);
	        	 System.out.println("El id del user es "+id);
	         }else if (user instanceof Driver){
	        	 DriverDAO c = new DriverDAOImpl();
	        	 //id = c.getDriverId((Driver)user);
	        	 System.out.println("El id del user es "+id);
	         }else if (user instanceof Administrator){
	        	 AdministratorDAO c = new AdministratorDAOImpl();
	        	 //id = c.getAdministratorId((Administrator)user);
	        	 System.out.println("El id del user es "+id);
	         }
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	     } finally {
	         session.close();
	     } 
	     if (id != 0){
	    	 return true;
	     }
	     return false;
	}
}
