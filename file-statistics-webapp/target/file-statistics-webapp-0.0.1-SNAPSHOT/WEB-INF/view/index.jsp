<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- c:url value="/resources/css/hello.css" var="coreCss" /-->
<c:url value="/resources/css/bootstrap.min.css" var="bootStrapProp" />
<c:url value="/resources/js/jquery-2.1.4.min.js" var="jQueryProp" />
<script src="${jQueryProp}"></script>
<title>Insert title here</title>
</head>
<body>
		<form class="form-horizontal" id="search-form">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Statistics</button>
				</div>
			</div>
		</form>
		<div id="feedback"></div>
	<script>
	jQuery(document).ready(function($) {

		$("#search-form").submit(function(event) {

			// Disble the search button
			//enableSearchButton(false);

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			getStatistics();

		});

	});
	
	function getStatistics() {
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/getStatistics",
			dataType : "json",
			success : function(data) {
				alert("Data was get");
				display(data);
			}, error : function(e) {
				console.log(e);
			}
		});
	}
	
	function display(data) {
		var json = JSON.stringify(data, null, 4);
		$('#feedback').html(json);
	}
	</script>
	
		<!-- h1>Общая статистика</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Длинное слово</th>
                    <th>Короткое слово</th>
                    <th>Длина строк</th>
                    <th>Среднее кол-во символов в строке</th>
                    <th>Ссылка на статистику по файлу</th>
                </tr>
            </thead>
            <c:forEach items="${filesStatistic}" var="fileStatistic">
                <tr>
                    <td>${fileStatistic.getId()}</td>
                    <td>${fileStatistic.getLongWord()}</td>
                    <td>${fileStatistic.getShortWord()}</td>
                    <td>${fileStatistic.getRowLength()}</td>
                    <td>${fileStatistic.getAvgRowLength()}</td>
                    <td><a href="http://localhost:8077/test-app/fileId?id=${fileStatistic.getId()}">Ссылка на статистику по файлу</a></td>
                </tr>
            </c:forEach>
        </table-->
</body>
</html>