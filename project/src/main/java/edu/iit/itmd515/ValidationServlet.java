package edu.iit.itmd515;

import edu.iit.itmd515.FormDataBean;
import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;


/**
 * Servlet that attends to the URL /ValidateFormData
 *
 * @author Raquel, Francisco
 *
 */
@WebServlet("/ValidateFormData")
public class ValidationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String name = req.getParameter("name");
		String ssn = req.getParameter("ssn");
		String zipCode = req.getParameter("zipcode");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		
		FormDataBean dataBean = new FormDataBean(name, ssn, zipCode, email, address, city, state);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = (Validator) factory.getValidator();
		Set<ConstraintViolation<FormDataBean>> violations = validator.validate(dataBean);
		
		String errorMsg = "";
		for (ConstraintViolation<FormDataBean> violation : violations) {
		    errorMsg += violation.getMessage() + ". "; 
		}
		
		if (!"".equals(errorMsg)) {
			req.getSession().setAttribute("errorMsg" , errorMsg);
			RequestDispatcher view = req.getRequestDispatcher("GetFormData.jsp");
			view.forward(req, res);
		} else {
			req.getSession().setAttribute( "bean" , dataBean );
			res.sendRedirect(req.getContextPath() + "/ProcessFormData");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
