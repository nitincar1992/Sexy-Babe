<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Home Page</title>
</head>
<body>
	<h1 align="center">BILL</h1>
		<h2 align="center">BILL AGAINST THE CREDIT CARD NUMBER</h2>
	<div align="center">
		<p>
			${billInfo.creditCard} for an amount of ${billInfo.amount} has been generated.
		</p> 
	</div>
</body>
</html>