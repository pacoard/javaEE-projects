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
                    <div class="col-md-6">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title">Ban drivers</h4>
                                </div>
                                <div class="content table-responsive table-full-width">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Rating</th>
                                                <th>Ban</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- For loop to inyect values -->
                                            <tr>
                                                <td>Mike</td>
                                                <td>5</td>
                                                <td>
                                                    <a  class="btn btn-simple btn-danger btn-icon remove"
                                                        href="/admin/ban/ID">
                                                        <i class="fa fa-ban"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                    </div>
                    <div class="col-md-6">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title">Ban consumers</h4>
                                </div>
                                <div class="content table-responsive table-full-width">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Rating</th>
                                                <th>Ban</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- For loop to inyect values -->
                                            <tr>
                                                <td>Mike</td>
                                                <td>5</td>
                                                <td>
                                                    <a  class="btn btn-simple btn-danger btn-icon remove"
                                                        href="/admin/ban/ID">
                                                        <i class="fa fa-ban"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
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
