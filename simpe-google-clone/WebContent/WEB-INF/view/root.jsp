<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Root page</title>
</head>
<body>
	<form action="home" method="post">
	<label for="searchValue">Search word:</label>
		<input name="searchValue" id="searchValue" type="text" size="15"> 
		<input value="Search" type="submit">
	</form>
</body>
</html>