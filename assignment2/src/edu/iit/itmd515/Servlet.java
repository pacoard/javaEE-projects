package edu.iit.itmd515;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.iit.itmd515.dao.*;
import edu.iit.itmd515.model.MsTH;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Testing DAO");
		
		MsTHDAO dao = MsTHDAOImpl.getInstance();
		
		dao.createMsth("paco0", "msth_title0", "msth_summary0", "msth_advisor0", "msth_secretary0", "msth_file0", 0);
		
		dao.createMsth("paco1", "msth_title1", "msth_summary1", "msth_advisor1", "msth_secretary1", "msth_file1", 1);
		
		dao.createMsth("paco2", "msth_title2", "msth_summary2", "msth_advisor2", "msth_secretary2", "msth_file2", 2);
		
		for (MsTH msth : dao.readAllMsth()) {
			resp.getWriter().println(msth.toString());
		}
		
		dao.removeMsth(new MsTH("paco0", "msth_title0", "msth_summary0", "msth_advisor0", "msth_secretary0", "msth_file0", 0));
		
		resp.getWriter().println("---------X---------");
		
		for (MsTH msth : dao.readAllMsth()) {
			resp.getWriter().println(msth.toString());
		}
		
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
//		RequestDispatcher view = req . getRequestDispatcher ( "ShowMsTHView.jsp" );
//		view . forward ( req , resp );
	}
}
