<div class="sidebar" data-color="black" data-image="assets/img/sidebar-5.jpg">

	<div class="sidebar-wrapper">
        <div class="logo">
            <a href="/" class="simple-text">
                u-Move-it
            </a>
        </div>
        <!-- http://themes-pixeden.com/font-demos/7-stroke/ -->
        <ul id="navbarUL" class="nav">

            <li id="welcome">
                <a href="/">
                    <i class="pe-7s-home"></i>
                    <p>Welcome</p>
                    <% if (false) { %>
                        code
                    <% }%>
                </a>
            </li>
            
            <li id="login-signup" >
                <a href="/login-signup">
                    <i class="pe-7s-add-user"></i>
                    <p>Log In/Sign Up</p>
                </a>
            </li>
            <li id="profile" >
                <a href="/profile">
                    <i class="pe-7s-user"></i>
                    <p>Profile</p>
                </a>
            </li>
            <li id="request-ride" >
                <a href="/request-ride">
                    <i class="pe-7s-plane"></i>
                    <p>Request ride</p>
                </a>
            </li>
            <li id="dispatch-ride" >
                <a href="/dispatch-ride">
                    <i class="pe-7s-map-marker"></i>
                    <p>Dispatch ride</p>
                </a>
            </li>
            <li id="admin" >
                <a href="/admin">
                    <i class="pe-7s-tools"></i>
                    <p>Administrator</p>
                </a>
            </li>

        </ul>
	</div>
</div>

<script type="text/javascript">
    $( document ).ready(function() {
        $("#navbarUL>li.active").removeClass("active");
        if ("${content}" == "") {
            $("#welcome").attr("class","active");
        } else {
            $("#${content}").attr("class","active");
        }
    });
</script>