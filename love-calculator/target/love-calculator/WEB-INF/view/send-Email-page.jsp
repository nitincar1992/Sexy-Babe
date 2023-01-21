<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Email Page</title>
</head>
<body>
	<form:form action="validateEmail" method="get" modelAttribute="sendEmail">
		<h1 align="center">Hi ${loginInfo.yourName}</h1>
		<h2 align="center">Enter your email id</h2>	
		<div align="center">
			<label>Send results to :</label>
			<form:input path="emailBox" id="eBox"/>
			<input type="submit" value="Submit">
		</div>
	</form:form>
</body>
</html>