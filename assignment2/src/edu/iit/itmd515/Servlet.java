package edu.iit.itmd515;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

//import edu.iit.itmd515.dao.*;
//import edu.iit.itmd515.model.MsTH;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Testing DAO");
		
		
//		UserService userService = UserServiceFactory . getUserService ();
//		String url = userService . createLoginURL ( req . getRequestURI ());
//		String urlLinktext = "Login" ;
//		String user = "" ;
//		if ( req . getUserPrincipal () != null ){
//			user = req . getUserPrincipal (). getName ();
//			url = userService . createLogoutURL ( req . getRequestURI ());
//			urlLinktext = "Logout" ;
//		}
//		req . getSession (). setAttribute ( "user" , user );
//		req . getSession (). setAttribute ( "url" , url );
//		req . getSession (). setAttribute ( "urlLinktext" , urlLinktext );
//		
		/*RequestDispatcher view = req.getRequestDispatcher ( "GetFormData.jsp" );
		view.forward ( req , resp );*/
	}
}
