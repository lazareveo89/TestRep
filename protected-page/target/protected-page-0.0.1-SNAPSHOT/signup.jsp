<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorization page</title>
<link href="/pages/css/bootstrap.min.css" rel="stylesheet">
<link href="/pages/css/signin.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width: 300px;">
        <form method="post">
        	<h2 class="form-signin-heading">Sign up for page</h2>
        	<input type="text" class="form-control" name="username">
        	<input type="password" class="form-control" name="password">
        	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    	</form>
</div>
</body>
</html>