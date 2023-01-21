<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator Login page</title>
<script type="text/javascript">
	function onValidation()
	{
		var temp1 = document.getElementById('yn').value;	
		var temp2 = document.getElementById('en').value;	
		if(temp1.length < 3 || temp2.length < 3)
		{
			alert("Invalid input")
			return false;
		}
		else
		{
			return true;	
		}
	}
</script>
<style type="text/css">
.error{

	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
	
}
</style>
</head>
<body>
	<h1 align="center">Love Calculator Login Page</h1>
	<hr />
	<div align="center">
		<form:form action="loginValidation" method="get" modelAttribute="loginInfo" id="enemyForm" onsubmit="onValidation()">
			<p>
				<label>Your Name :</label>
				<form:input path="yourName" id="yn" form="enemyForm"/>
				<form:errors path="yourName" cssClass="error"/>
			</p>
			<br />
			<p>
				<label>Enemy Name :</label>
				<form:input path="enemyName" id="en" form="enemyForm"/>
				<form:errors path="enemyName" cssClass="error"/>
			</p>
			<br />
			<p>
				<form:checkbox path="checkbox" id="check"/>
				<label>Agree it</label>
				<form:errors path="checkbox" cssClass="error"/>
			</p>
			<p>
				<input type="submit" value="Login">
			</p>
		</form:form>
	</div>
</body>
</html>