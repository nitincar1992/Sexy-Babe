<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit Card Login page</title>
</head>
<body>
	<form:form action="billResult" method="get" modelAttribute="billInfo">
		<h1 align="center">Bill</h1>
		<div align="center">
			<p>
				<label>Card Number :</label>
				<form:input path="creditCard" id="card"/>
			</p>
			<p>
				<label>Amount :</label>
				<form:input path="amount" id="amt"/>
			</p>
			<p>
				<input type="submit" value="Pay Bill">
			</p>
		</div>
	</form:form>
</body>
</html>