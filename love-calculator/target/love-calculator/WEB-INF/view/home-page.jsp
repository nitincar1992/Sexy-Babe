<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator Hompage</title>
</head>
<body>
	<h1 align="center">Love Calculator Registration</h1>
	<hr />
	<form:form action="result-page" method="get" modelAttribute="userInfo" id="loveForm">
		<a href="http://www.google.com">Sign in</a>
		<div align="center">
			<p>
				<label for="name">Name :</label>
				<form:input id="name" path="name" form="loveForm"/>
			</p>
			<p>
				<label for="username">Username :</label>
				<form:input id="username" path="username" form="loveForm"/>
			</p>
			<p>
				<label for="password">Password :</label>
				<form:password id="password" path="password" form="loveForm"/>
			</p>
			<p>
				<label for="country">Country :</label>
				<form:select id="country" path="country" form="loveForm">
					<form:option path = "country" value="India">India</form:option>
					<form:option path = "country" value="USA">USA</form:option>
					<form:option path = "country" value="England">England</form:option>
					<form:option path = "country" value="Australia">Australia</form:option>
				</form:select>
			</p>
			<p>
				<label>Hobby :</label> 
				Cricket <form:checkbox path="hobby" value="Cricket"/>
				Reading <form:checkbox path="hobby" value="Reading"/>
				Travel <form:checkbox path="hobby" value="Travel"/>
				Programming <form:checkbox path="hobby" value="Programming"/>
			</p>
			<p>
				<label>Gender :</label> 
				Male <form:radiobutton path="gender" value="Male"/>
				Female <form:radiobutton path="gender" value="Female"/>
				Other <form:radiobutton path="gender" value="Other"/>
			</p>
			<p>
				<input type="submit" value="Register"/>
			</p>
		</div>
	</form:form>
</body>
</html>