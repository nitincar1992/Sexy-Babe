<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Data to List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourceFolder/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourceFolder/css/mybackgroundimage2.css">
</head>
<body class="myFonts">
<h3 align="right">Enter Student details</h3>
	<form:form action="saveStudentToList" method="post" modelAttribute="studentDTO">
		<div align="right">
			<form:hidden path="id"/>
			<label>Name :</label>
			<form:input path="name" id="name" />
			<br />
			<label>Mobile :</label>
			<form:input path="mobile" id="mobile" />
			<br />
			<label>Country :</label>
			<form:input path="country" id="country" />
			<br /> 
			<input type="submit" value="Submit" class="btn btn-outline-primary">
		</div>
	</form:form>
</body>
</html>