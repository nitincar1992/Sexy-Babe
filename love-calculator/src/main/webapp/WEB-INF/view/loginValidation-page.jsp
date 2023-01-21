<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Validation</title>
</head>
<body>
<h1 align="center">Login Validation Page</h1>
<hr />
<div align="center">
	<h2>Your login data</h2>
	<p>
		${loginInfo.yourName} and ${loginInfo.enemyName} are :
	</p>
	${appResult}
	<br />
	<a href="/love-calculator/sendEmail">Send results to email</a>
</div>
</body>
</html>