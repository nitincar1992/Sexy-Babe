<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator Resultpage</title>
</head>
<body>
	<h1 align="center">Love Calculator Results</h1>
	<hr />
	<h2>The details entered by you are</h2>
	<p>Name is : ${regInfo.name}</p>
	<p>Username is : ${regInfo.username}</p>
	<p>Password is : ${regInfo.password}</p>
	<p>Country is : ${regInfo.country}</p>
	<p>
		Hobby is :

		<c:forEach var="temp" items="${regInfo.hobby}"> 
	
	${temp}
	
	</c:forEach>
	</p>
	<p>Gender is : ${regInfo.gender}</p>
	<br /> Age is : ${regInfo.age}
	<br> Date is : ${regInfo.date}
	<br /> Credit card is : ${regInfo.creditCard}
	<br /> Amount is : ${regInfo.amount}
	<br /> Money is : ${regInfo.money}
	<br /> Currency is: ${regInfo.currencyFormat.displayName}
	<br /> Email is : ${regInfo.comDto.email}
	<br /> Phone is : ${regInfo.comDto.phone}
</body>
</html>