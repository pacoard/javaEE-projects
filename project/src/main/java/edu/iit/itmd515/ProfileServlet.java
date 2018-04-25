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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String role;
	private String name;
	private String password; //Password when init the session
	private String email;
	private String phone;
	private String cardNum;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.getSession().setAttribute("content", "profile");
		role = (String) req.getSession().getAttribute("role");
		password = (String) req.getSession().getAttribute("password");
		if (role.equals("admin")){
			Administrator a = new Administrator();
			a.setEmail((String)req.getSession().getAttribute("email"));
			a.setPassword((String)req.getSession().getAttribute("password"));
			getData(a);
		}else if(role.equals("consumer")){
			Consumer c = new Consumer();
			c.setEmail((String)req.getSession().getAttribute("email"));
			c.setPassword((String)req.getSession().getAttribute("password"));
			getData(c);
		}else if(role.equals("driver")){
			Driver d = new Driver();
			d.setEmail((String)req.getSession().getAttribute("email"));
			d.setPassword((String)req.getSession().getAttribute("password"));
			getData(d);
		}
		RequestDispatcher view = req.getRequestDispatcher("profile.jsp");
		req.setAttribute("name", name);
		req.setAttribute("email", email);
		req.setAttribute("phone", phone);
		req.setAttribute("password", password);
		req.setAttribute("cardNumber", cardNum);
		view.forward(req,res);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("New pass introduced:" + request.getParameter("newPassword"));
		if (role.equals("admin")){
			Administrator a = new Administrator();
			a.setEmail(email);
			a.setPassword(password);
			System.out.println("New password introduced:" + request.getParameter("newPassword"));
			changePassword(a, (String)request.getParameter("newPassword"));
			request.getSession().setAttribute("password", (String)request.getParameter("newPassword"));
		}else if(role.equals("consumer")){
			Consumer c = new Consumer();
			c.setEmail(email);
			c.setPassword(password);
			System.out.println("New password introduced:" + request.getParameter("newPassword"));
			changePassword(c, (String)request.getParameter("newPassword"));
			request.getSession().setAttribute("password", (String)request.getParameter("newPassword"));
			System.out.println("Password changed");
		}else if(role.equals("driver")){
			Driver d = new Driver();
			d.setEmail(email);
			d.setPassword(password);
			System.out.println("New password introduced:" + request.getParameter("newPassword"));
			changePassword(d, (String)request.getParameter("newPassword"));
			request.getSession().setAttribute("password", (String)request.getParameter("newPassword"));
		}
		response.sendRedirect("login-signup.jsp");
	}
	
	public void changePassword(Object u,String newPass){
	     Session session = HibernateUtil.openSession();
	     Transaction tx = null;
	     Long id = 0L;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         if (role.equals("consumer")){
	        	 ConsumerDAO d = new ConsumerDAOImpl();
	        	 id = d.getConsumerId((Consumer)u);
	        	 u = d.getConsumerById(id);
	        	 ((Consumer) u).setPassword(newPass);
	        	 Consumer update = (Consumer)session.merge(u);
	        	 System.out.println("User updated");
	         }else if (role.equals("driver")){
	        	 DriverDAO d = new DriverDAOImpl();
	        	 id = d.getDriverId((Driver)u);
	        	 u = d.getDriverById(id);
	        	 ((Driver) u).setPassword(newPass);
	        	 Driver update = (Driver)session.merge(u);
	        	 System.out.println("User updated");
	         }else if (role.equals("admin")){
	        	 AdministratorDAO d = new AdministratorDAOImpl();
	        	 id = d.getAdministratorId((Administrator)u);
	        	 u = d.getAdministratorById(id);
	        	 ((Administrator) u).setPassword(newPass);
	        	 Administrator update = (Administrator)session.merge(u);
	        	 System.out.println("User updated");
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
	}
	
	public void getData(Object u){
	     Session session = HibernateUtil.openSession();
	     Transaction tx = null;
	     Long id = 0L;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         if (u instanceof Consumer){
	        	 ConsumerDAO c = new ConsumerDAOImpl();
	        	 id = c.getConsumerId((Consumer)u);
	        	 u = c.getConsumerById(id);
	        	 name= ((Consumer) u).getName();
	        	 email= ((Consumer) u).getEmail();
	        	 phone = ((Consumer) u).getPhone();
	        	 cardNum = ((Consumer) u).getCardNumber();
	         }else if (role.equals("driver")){
	        	 DriverDAO d = new DriverDAOImpl();
	        	 id = d.getDriverId((Driver)u);
	        	 u = d.getDriverById(id);
	        	 System.out.println(((Driver) u).getName());
	        	 name= ((Driver) u).getName();
	        	 email= ((Driver) u).getEmail();
	        	 phone = ((Driver) u).getPhone();
	        	 cardNum = "none";
	         }else if (role.equals("admin")){
	        	 AdministratorDAO a = new AdministratorDAOImpl();
	        	 id = a.getAdministratorId((Administrator)u);
	        	 u = a.getAdministratorById(id);
	        	 System.out.println(((Driver) u).getName());
	        	 name= ((Driver) u).getName();
	        	 email= ((Driver) u).getEmail();
	        	 phone = "none";
	        	 cardNum = "none";
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
	}
}
