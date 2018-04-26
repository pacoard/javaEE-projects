<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>


<!doctype html>
<html lang="en">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
     content="----- your google client id here -----------">
<%@include  file="head.html" %>

<body>


<div class="wrapper">

<%@include  file="sidebar.jsp" %>


    <div class="main-panel">
        

        <%@include  file="navbar.jsp" %>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-7">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title">New member? Sign Up</h4>
                                    <%if (session.getAttribute("notification_msg") != null && session.getAttribute("notification_msg").equals("The parameters introduced are not correct")) { %>
                                    	<p style="color:red;"><%=session.getAttribute("notification_msg")%></p>
					                <% } %>
                                </div>
                                <div class="content">
                                    <form action="/login-signup" method="post">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Name</label>
                                                    <input type="text" class="form-control" name="name">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Email</label>
                                                    <input type="text" class="form-control" name="email">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Phone</label>
                                                    <input type="text" class="form-control" name="phone">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Card Number</label>
                                                    <input type="text" class="form-control" name="card_number">
                                                </div>
                                            </div>
                                            
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Password</label>
                                                    <input type="password" class="form-control" name="password">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Repeat Password</label>
                                                    <input type="password" class="form-control" name="password">
                                                </div>
                                            </div>
                                        </div>
										<div class="row">
                                            <div class="col-md-6">
				        						 <div class="form-group">
				                                 	<label>User type</label>
				                                        <select type="text" class="form-control" name="role">
				                                        	<option value="NONE">---</option>
				                                            <option value="Administrator">Administrator</option>
				                                            <option value="Consumer">Consumer</option>
				                                            <option value="Driver">Driver</option>
				                                        </select>
				                                 </div>
				                             </div>
				                         </div>           
                                        <button type="submit" name="signup" class="btn btn-info btn-fill pull-right">Sign Up</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                            </div>
                    </div>
                    <div class="col-md-5">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title">Already a member? Log In</h4>
                                    <%if (session.getAttribute("notification_msg") != null && session.getAttribute("notification_msg").equals("Login incorrect")) { %>
                                    	<p style="color:red;"><%=session.getAttribute("notification_msg")%></p>
					                <% } %>
                                </div>
                                <div class="content">
                                    <form action="/login-signup" method="post">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Email</label>
                                                    <input type="text" class="form-control" name="emailLI" >
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Password</label>
                                                    <input type="password" name="passwordLI" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
				        						 <div class="form-group">
				                                 	<label>User type</label>
				                                        <select type="text" class="form-control" name="roleLI">
				                                        	<option value="NONE">---</option>
				                                            <option value="Administrator">Administrator</option>
				                                            <option value="Consumer">Consumer</option>
				                                            <option value="Driver">Driver</option>
				                                        </select>
				                                 </div>
				                             </div>
				                         </div>  

                                        <button type="submit" name="login" class="btn btn-info btn-fill pull-right">Log In</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include  file="footer.html" %>

    </div>
</div>

</body>
    <!--   Core JS Files   -->
    <script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>
	
	<!-- Google API autorization -->
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	

</html>
