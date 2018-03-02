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
 * Servlet that attends to the URL /ProcessFormData
 *
 * @author Raquel, Francisco
 *
 */
@WebServlet("/ProcessFormData")
public class ProcessCustomerDataServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		FormDataBean bean = (FormDataBean) req.getSession().getAttribute("bean");
		req.getSession().setAttribute( "data" , bean.toString() );
		
		String coordinates = "Coordinates: ";
		try {
			String address = bean.getAddress() + " " + bean.getCity() + " " + bean.getZipCode() + " " + bean.getState();
			/*GeoAddressStandardizer st = new GeoAddressStandardizer("AABBCC");
			@SuppressWarnings("deprecation")
			GeoUsAddress geoAddr = st.standardizeToGeoUsAddress(address);
			coordinates += "Latitude: " + geoAddr.getCoordinate().getLatitude() + ", Longitude: " + geoAddr.getCoordinate().getLongitude();
			*/
			coordinates += geocoding(address);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			coordinates += "N/A";
		}
		req.getSession().setAttribute("coordinates", coordinates);
		RequestDispatcher view = req.getRequestDispatcher("ProcessCustomerDataRequest.jsp");
		view.forward(req,res);
	}
	
	// Code from: http://theoryapp.com/parse-json-in-java/
	
	public static String geocoding(String addr) throws Exception {
	    // build a URL
	    String s = "http://maps.google.com/maps/api/geocode/json?" +
	                    "sensor=false&address=";
	    s += URLEncoder.encode(addr, "UTF-8");
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
	        return "N/A";
	 
	    // get the first result
	    JSONObject res = obj.getJSONArray("results").getJSONObject(0);
	    System.out.println(res.getString("formatted_address"));
	    JSONObject loc = res.getJSONObject("geometry").getJSONObject("location");

	    return ("Latitude: " + loc.getDouble("lat") + ", Longitude: " + loc.getDouble("lng"));
	}
}
