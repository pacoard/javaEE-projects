package edu.iit.itmd515.model;

import java.util.List;

/**
 * Interface to Request database
 * 
 * @author Francisco, Raquel
 *
 */
public interface RequestDAO {

	/**
	 * Create method
	 * 
	 * @param id
	 * @param consumerId
	 * @param location
	 * @param requestTime
	 * @param requestType
	 * @return created Request
	 */
	public Request createRequest(Long id,String origin, String destination, String price, String distance, String type);
	
	/**
	 * Read method
	 * 
	 * @return List of Requests
	 */
	public List<Request> getAllRequests();
	
	/**
	 * Update method
	 * 
	 * @param location
	 * @param requestTime
	 * @param requestType
	 * @return updated Request
	 */
	public void updateRequest(Request r);
	
	/**
	 *  Delete all method
	 */
	public void deleteAllRequests();
	
	/**
	 * Delete by ID method
	 * 
	 * @param id
	 */
	public void deleteRequestsById(Long id);
	public Object getRequestByid(Long id);
}
