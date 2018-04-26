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
                                    <h4 class="title">Profile</h4>
                                    <%if (session.getAttribute("notification_msg") != null && session.getAttribute("notification_msg").equals("Changes saved successfully")) { %>
                                    	<p style="color:green;"><%=session.getAttribute("notification_msg")%></p>
					                <% } %>
                                </div>
                                <div class="content">
                                    <form action="/profile" method="post">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Name</label>
                                                    <input type="text" class="form-control" name="name" value='<%=request.getAttribute("name")%>' >
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Email</label>
                                                    <input type="text" class="form-control" name="email" value='<%=request.getAttribute("email")%>'>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Phone</label>
                                                    <input type="text" class="form-control" name="phone" value='<%=request.getAttribute("phone")%>'>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Card Number</label>
                                                    <input type="text" class="form-control" name="cardNumber" value='<%=request.getAttribute("cardNumber")%>'>
                                                </div>
                                            </div>
                                            
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>New password</label>
                                                    <input type="password" class="form-control" name="newPassword" >
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Repeat new password</label>
                                                    <input type="password" class="form-control" >
                                                </div>
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-info btn-fill pull-right">Update</button>
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


</html>
