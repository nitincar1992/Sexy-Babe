<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Data to List</title>
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourceFolder/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourceFolder/css/mybackgroundimage2.css">
</head>
<body>
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
			<input type="submit" value="Submit">
		</div>
	</form:form>
</body>
</html>