package edu.iit.itmd515;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
    private Long id = 0L;
	
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
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				admin.setEmail(email);
				admin.setPassword(password);
				result = register(admin); 
			     if(result){
			    	 //Setting session values
			    	 request.getSession().setAttribute("id", id);
			    	 request.getSession().setAttribute("role", "admin");   
			    	 request.getSession().setAttribute("email", email);
			    	 request.getSession().setAttribute("password", password);
			    	 RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
			    	 view.forward(request,response);
			    	 System.out.println("Login/Registration correct!");
			     }
			     else{
					 RequestDispatcher view = request.getRequestDispatcher("login-signup.jsp");
					 request.getSession().setAttribute("notification_msg", "The parameters introduced are not correct");
					 view.forward(request,response);
			    	 System.out.println("Login/Registration error!");
			     }
			}else if (role.equals("Driver")){
				Driver driver = new Driver();
				driver.setName(request.getParameter("name"));
				driver.setEmail(request.getParameter("email"));
				driver.setPhone(request.getParameter("phone"));
				driver.setPassword(request.getParameter("password"));
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				result = register(driver); 
			     if(result){
			    	 //Setting session values
			    	 request.getSession().setAttribute("id", id);
			    	 request.getSession().setAttribute("role", "driver");   
			    	 request.getSession().setAttribute("email", email);
			    	 request.getSession().setAttribute("password", password);
			    	 RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
			    	 view.forward(request,response);
			    	 System.out.println("Login/Registration correct!");
			     }
			     else{
					 RequestDispatcher view = request.getRequestDispatcher("login-signup.jsp");
					 request.getSession().setAttribute("notification_msg", "The parameters introduced are not correct");
					 view.forward(request,response);
			    	 System.out.println("Login/Registration error!");
			     }
			}else if (role.equals("Consumer")){
				Consumer consumer = new Consumer();
				consumer.setName(request.getParameter("name"));
				consumer.setEmail(request.getParameter("email"));
				consumer.setPhone(request.getParameter("phone"));
				consumer.setCardNumber(request.getParameter("card_number"));
				consumer.setPassword(request.getParameter("password"));
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				result = register(consumer); 
			     if(result){
			    	 //Setting session values
			    	 request.getSession().setAttribute("role", "consumer"); 
			    	 request.getSession().setAttribute("id", id);
			    	 request.getSession().setAttribute("email", email);
			    	 request.getSession().setAttribute("password", password);
			    	 RequestDispatcher view = request.getRequestDispatcher("request-ride.jsp");
			    	 view.forward(request,response);
			    	 System.out.println("Login/Registration correct!");
			     }
			     else{
					 RequestDispatcher view = request.getRequestDispatcher("login-signup.jsp");
					 request.getSession().setAttribute("notification_msg", "The parameters introduced are not correct");
					 view.forward(request,response);
			    	 System.out.println("Login/Registration error!");
			     }
			}else{
				 RequestDispatcher view = request.getRequestDispatcher("login-signup.jsp");
				 request.getSession().setAttribute("notification_msg", "You have to select a role");
				 view.forward(request,response);
		    	 System.out.println("Login/Registration error!");
			}
			
		}else if (request.getParameter("login") != null){
			//Get parameters from log in form (we will have to check at DB
		 	String role = request.getParameter("roleLI");
		 	result = false;
			if (role.equals("Administrator")){
				Administrator admin = new Administrator();
				String email = request.getParameter("emailLI");
				String password = request.getParameter("passwordLI");
				admin.setEmail(email);
				admin.setPassword(password);
				result = login(admin); 
			     if(result){
			    	 request.getSession().setAttribute("role", "admin");
			    	 request.getSession().setAttribute("id", id);
			    	 request.getSession().setAttribute("email", email);
			    	 request.getSession().setAttribute("password", password);
			    	 response.sendRedirect("welcome.jsp");
			    	 System.out.println("Login/Registration correct!");
			     }
			     else{
					 RequestDispatcher view = request.getRequestDispatcher("login-signup.jsp");
					 request.getSession().setAttribute("notification_msg", "Login incorrect");
					 view.forward(request,response);
			    	 System.out.println("Login/Registration error!");
			     }
			}else if (role.equals("Consumer")){
				Consumer consumer = new Consumer();
				String email = request.getParameter("emailLI");
				String password = request.getParameter("passwordLI");
				consumer.setEmail(email);
				consumer.setPassword(password);
				result = login(consumer); 
			     if(result){
			    	 request.getSession().setAttribute("role", "consumer");  
			    	 request.getSession().setAttribute("id", id);
			    	 request.getSession().setAttribute("email", email);
			    	 request.getSession().setAttribute("password", password);
			    	 response.sendRedirect("request-ride.jsp");
			    	 System.out.println("Login/Registration correct!");
			     }
			     else{
					 RequestDispatcher view = request.getRequestDispatcher("login-signup.jsp");
					 request.getSession().setAttribute("notification_msg", "Login incorrect");
					 view.forward(request,response);
			    	 System.out.println("Login/Registration error!");
			     }
			}else if (role.equals("Driver")){
				Driver driver = new Driver();
				String email = request.getParameter("emailLI");
				String password = request.getParameter("passwordLI");
				driver.setEmail(email);
				driver.setPassword(password);
				result = login(driver); 
			     if(result){
			    	 request.getSession().setAttribute("role", "driver");
			    	 request.getSession().setAttribute("id", id);
			    	 request.getSession().setAttribute("email", email);
			    	 request.getSession().setAttribute("password", password);
			    	 response.sendRedirect("welcome.jsp");
			    	 System.out.println("Login/Registration correct!");
			     }
			     else{ 
					 RequestDispatcher view = request.getRequestDispatcher("login-signup.jsp");
					 request.getSession().setAttribute("notification_msg", "Login incorrect");
					 view.forward(request,response);
			    	 System.out.println("Login/Registration error!");
			     }
			}else{
				 RequestDispatcher view = request.getRequestDispatcher("login-signup.jsp");
				 request.getSession().setAttribute("notification_msg", "You have to select a role");
				 view.forward(request,response);
		    	 System.out.println("Login/Registration error!");
			}
		}
	}
	
	
	public boolean register(Object user){
	     Session session = HibernateUtil.openSession();
	     System.out.println("Session init for registration");
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         id = (Long)session.save(user);
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
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         if (user instanceof Consumer){
	        	 ConsumerDAO c = new ConsumerDAOImpl();
	        	 id = c.getConsumerId((Consumer)user);
	         }else if (user instanceof Driver){
	        	 DriverDAO c = new DriverDAOImpl();
	        	 id = c.getDriverId((Driver)user);
	         }else if (user instanceof Administrator){
	        	 AdministratorDAO c = new AdministratorDAOImpl();
	        	 id = c.getAdministratorId((Administrator)user);
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
