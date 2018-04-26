<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>


<!doctype html>
<html lang="en">

<%@include  file="head.html" %>

<body>


<div class="wrapper">

<%@include  file="sidebar.jsp" %>


    <div class="main-panel">
        

        <%@include  file="navbar.jsp" %>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-10">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title">Enter the details of your ride</h4>
                                    <%if (session.getAttribute("error_message") != null) { %>
                                    	<p style="color:red;"><%=session.getAttribute("error_message")%></p>
					                <% } %>
					                <%if (session.getAttribute("ok_message") != null) { %>
                                    	<p style="color:green;"><%=session.getAttribute("ok_message")%></p>
					                <% } %>
                                </div>
                                <div class="content">
                                    <form id="requestRideForm" action="/request-ride" method="post">
                                        <div class="row">
                                            <div class="col-md-11">
                                                <div class="form-group">
                                                    <label>Origin</label>
                                                    <input type="text" class="form-control" name="origin"><p id="origin_msg"></p>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-11">
                                                <div class="form-group">
                                                    <label>Destination</label>
                                                    <input type="text" class="form-control" name="destination"><p id="destination_msg"></p>
                                                </div>
                                            </div>
                                        </div>
                                        
										<div class="row">
                                            <div class="col-md-6">
				        						 <div class="form-group">
				                                 	<label>Ride type</label>
				                                        <select type="text" class="form-control" name="requestType">
				                                        	<option value="NONE">---</option>
				                                            <option value="Person">Person</option>
				                                            <option value="Object">Object</option>
				                                            <option value="Both">Both</option>
				                                        </select>
				                                 </div>
				                             </div>
				                         </div>           
                                        <button type="submit" name="signup" class="btn btn-info btn-fill pull-right">Request ride</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                            </div>
                    </div>
                 </div>
                 </div>
                 </div>


    </div>
</div>


</body>

        <!--   Core JS Files   -->
    <script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
    <script src="assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

    <!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>
    

</html>
