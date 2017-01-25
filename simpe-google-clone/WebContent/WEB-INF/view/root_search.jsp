<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body>
	<table border="1">
	<thead>
	<tr>
		<th>URL</th>
		<th>Description</th>
	</tr>
	</thead>
	<tbody>
	<c:choose>
	<c:when test="${information != null && !information.isEmpty()}">
		<c:forEach items="${information}" var="r">
		<tr>
			<td><c:out value="${r.getUrl()}"></c:out></td>
			<td><c:out value="${r.getKeywords()}"></c:out></td>
		</tr>
	</c:forEach>
	</c:when>
	<c:otherwise>
		<tr>
			<td>Data not found</td>
			<td>Data not found</td>
		</tr>
	</c:otherwise>
	</c:choose>
	</tbody>
	</table>
</body>
</html>