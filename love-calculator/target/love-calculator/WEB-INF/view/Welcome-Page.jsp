<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rowdy Home Page</title>
</head>
<body>
	<h1 align="center">Rowdy Registration</h1>
	<hr />
	<form:form action="Result-Page" method="get" modelAttribute="rowdyInfo"
		id="rowdyForm">
		<div align="center">
			<p>
				<label for="name">Name :</label>
				<form:input id="name" path="name" />
			</p>
			<a href="http://www.seleniumexpress.com">Sign in</a>
			<p>
				<label for="username">Username :</label>
				<form:input id="username" path="username" />
			</p>
			<p>
				<label for="password">Password :</label>
				<form:password id="password" path="password" />
			</p>
			<p>
				<label for="country">Country :</label>
				<form:select id="country" path="country" form="rowdyForm">
					<form:option value="Pakistan">Pakistan</form:option>
					<form:option value="Afghanistan">Afghanistan</form:option>
					<form:option value="Burundi">Burundi</form:option>
					<form:option value="North Korea">North Korea</form:option>
				</form:select>
			</p>
			<p>
				<label>Hobby :</label> Cricket
				<form:checkbox path="hobby" value="cricket" />
				Reading
				<form:checkbox path="hobby" value="reading" />
				Travel
				<form:checkbox path="hobby" value="travel" />
				Programming
				<form:checkbox path="hobby" value="programming" />
			</p>
			<p>
				<label>Gender :</label> Male
				<form:radiobutton path="gender" value="male" />
				Female
				<form:radiobutton path="gender" value="female" />
			</p>
			<p>
				<input type="button" value="Register" />
			</p>
		</div>
	</form:form>
</body>
</html>
