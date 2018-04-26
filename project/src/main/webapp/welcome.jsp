<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>

<!-- Template file for the rest of the pages -->

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
					<div class="col-md-12">
						<div class="card">
							<div class="header">
								<h2 style="text-align:center;">U-MOVE-IT</h2>
	                            <h3 class="title">ITMD 515 Advanced Software Programming</h4>
	                            <p class="category">Spring 2018 final project</p>
	                        </div>
	                        <div class="content">
	                        	<p>This is the final project of the course ITMD 515.</p>
	                        	<p>Group members:</p>
	                        	<ul>
	                        		<li>Francisco de Paula García de la Corte</li>
	                        		<li>Raquel Noblejas Sampedro</li>
	                        	</ul>
	                        	<p>We have developed a package delivery and private transportation platform, in which it is possible to create an account, login and request a ride. Administrators can ban any users and drivers can dispatch rides. The website uses Bootstrap to power the design and Java EE as its backend technology.</p>
		                        <div class="footer">
	                                <hr>
	                                <div class="stats">
	                                    <i class="fa fa-file-code-o"></i> Developed with Bootstrap and Java EE
	                                </div>
	                            </div>
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
