<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorization page</title>
<link href="/pages/css/bootstrap.min.css" rel="stylesheet">
<link href="/pages/css/signin.css" rel="stylesheet">
<link rel="stylesheet" href="/pages/styles.css" type="text/css">
</head>
<body>
<div class="container" style="width: 300px;">
        <form method="post" id="data">
        	<h2 class="form-signin-heading">Sign up for page</h2>
        	<label for="username">Login: </label>
        	<input type="text" class="form-control" id="username" name="username">
        	<label for="password">Password: </label>
        	<input type="password" class="form-control" name="password">
        	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    	</form>
        <div id="pswd_info">
         <h4>Password requirements:</h4>
             <ul>
                 <li id="letter">Minimum <strong>8 symbols</strong></li>
                 <li id="capital">Minimum <strong>1 capital character</strong></li>
                <li id="number">Minimum <strong>1 digit</strong></li>
             </ul>
	</div>
</div>
<script type="text/javascript">

		jQuery(document).ready(function($) {
			$("#data").submit(function(event) {
				event.preventDefault();
				checkUser();
			});
		});
                
            function checkRequirements() {
                if ( pswd.length < 8 ) {
                    $('#letter').removeClass('valid').addClass('invalid');
                } else {
                    $('#letter').removeClass('invalid').addClass('valid');
                }
	 
                //validate capital letter
                if ( pswd.match(/[A-Z]/) ) {
                    $('#capital').removeClass('invalid').addClass('valid');
                } else {
                    $('#capital').removeClass('valid').addClass('invalid');
                }
	 
                //validate number
                if ( pswd.match(/[0-9]/) ) {
                    $('#number').removeClass('invalid').addClass('valid');
                } else {
                    $('#number').removeClass('valid').addClass('invalid');
                }
	 
                }).focus(function() {
                    $('#pswd_info').show();
                }).blur(function() {
                    $('#pswd_info').hide();
                });

		function checkUser() {			
			var User = {
				login : document.getElementById("username").value,
				password : document.getElementById("password").value
			};
			
			var urlAccessSuccess = 'http://localhost:8077/protected-page';
			
			$.ajax({

			    url : "/protected-page/addUser",
			    contentType : 'application/json',
			    dataType : 'json',
			    type : 'POST',
			    success : function(data) {
						window.location.replace(urlAccessSuccess);
				},
				error : function(e) {
					$('#jsonMessage').html(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
		}
</script>
</body>
</html>