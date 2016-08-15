<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorization page</title>
<link href="/pages/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="/pages/css/signin.css" rel="stylesheet" />
<script type="text/javascript" 
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js" ></script>
<script src="/pages/js/jquery.js" type="text/javascript"></script>
<script src="/pages/js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
        <p class="lead">
            Welcome anonymous to main page
        </p>
<div class="container" style="width: 300px;">
        <form id="data" method="post" name="data">
        	<h2 class="form-signin-heading">Please log in</h2>
        	<label for="username">Login: </label>
        	<input type="text" class="form-control" id="username" name="username" value="login">
        	<label for="password">Password: </label>
        	<input type="password" class="form-control" id="password" name="password" value="password">
        	<button class="btn btn-lg btn-success" type="submit">Log in</button>
    	</form>
    	<div id="jsonMessage"></div>
</div>
<script type="text/javascript">

		jQuery(document).ready(function($) {
			$("#data").submit(function(event) {
				event.preventDefault();
				checkUser();
			});
		});

		function checkUser() {			
			var User = {
				login : document.getElementById("username").value,
				password : document.getElementById("password").value
			};
			
			var urlAccessDenied = 'http://localhost:8077/protected-page/signup.jsp';
			var urlAccessSuccess = 'http://localhost:8077/protected-page/welcome.jsp';
			
			$.ajax({

			    url : "/protected-page/checkUser",
			    contentType : 'application/json',
			    data : JSON.stringify(User),
			    dataType : 'json',
			    type : 'POST',
			    response:'json',
			    success : function(data) {
					console.log("SUCCESS: ", data);
					var mess = JSON.stringify(data, ["errMess"]);
					if(checkFlag(mess)) {
						console.log("MessIsNull: ", mess);
						window.location.replace(urlAccessSuccess);
					} else {
						console.log("MessIsntNull: ", mess);
						window.location.replace(urlAccessDenied);
					}
				},
				error : function(e) {
					$('#jsonMessage').html(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
		}
		function checkFlag(errMess) {
			if(errMess !== undefined) {
				return false;
			} else {
				return true;
			}
		}
</script>
</body>
</html>