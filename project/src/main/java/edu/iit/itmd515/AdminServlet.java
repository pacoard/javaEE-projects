package edu.iit.itmd515;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.json.JSONObject;

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
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		
		if (req.getSession().getAttribute("role") != "Administrator") {
			req.getSession().setAttribute("content", "");
			RequestDispatcher view = req.getRequestDispatcher("forbidden.jsp");
			view.forward(req,res);
		} else {
			req.getSession().setAttribute("content", "admin");
			RequestDispatcher view = req.getRequestDispatcher("admin.jsp");
			view.forward(req,res);
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
