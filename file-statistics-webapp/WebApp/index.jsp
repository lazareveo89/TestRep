<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<title>Statistics</title>
</head>
<body>
		<form class="form-horizontal" id="getStatistic-form">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Statistics</button>
				</div>
			</div>
		</form>
	<table>
      <thead>
        <tr>
          <th>Filename</th>
          <th>LongWord</th>
          <th>ShortWord</th>
          <th>RowLength</th>
          <th>AvgRowLength</th>
        </tr>
      </thead>
      <tbody id="statistic">
      	
      </tbody>
     </table>
	<script>
	jQuery(document).ready(function($) {

		$("#getStatistic-form").submit(function(event) {

			event.preventDefault();
			getStatistics();

		});

	});
	
	function getStatistics() {
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}getStatistics",
			dataType : "json",
			success : function(data) {
				display(data);
			}, error : function(e) {
				console.log(e);
			}
		});
	}
	
	function display(data) {
		var html = "";
		for(var i=0; i<data.length; i++) {
			for(var j=0; j<data[i].listRowStatistics.length; j++) {
				html+="<tr>" +
				"<td>"+data[i].listRowStatistics[j].fileNamePK.fileName+"</td>"+
				"<td>"+data[i].listRowStatistics[j].longWord+"</td>"+
				"<td>"+data[i].listRowStatistics[j].shortWord+"</td>"+
				"<td>"+data[i].listRowStatistics[j].lengthRow+"</td>"+
				"<td>"+data[i].listRowStatistics[j].avgLengthRow+"</td>"+
				"</tr>";
			}
		}
		document.getElementById("statistic").innerHTML = html;
	}
	</script>
</body>
</html>