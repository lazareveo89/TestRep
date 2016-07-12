<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Общая статистика</h1>
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
        </table>
</body>
</html>