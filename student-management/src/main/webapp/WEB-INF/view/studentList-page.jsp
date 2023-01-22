<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Data List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourceFolder/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourceFolder/css/mybackgroundimage.css">
</head>
<body class="myFonts">
	<div class="container">
	<h1 align="center">Selenium Express</h1>
		<table border="1" class="table table-hover">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>mobile</th>
				<th>country</th>
			</tr>
			<c:forEach var="listOf" items="${listOfMany}">
				<tr>
					<td>${listOf.id}</td>
					<td>${listOf.name}</td>
					<td>${listOf.mobile}</td>
					<td>${listOf.country}</td>
					<td><a href="/student-management/updateStudentList?userId=${listOf.id}">Update</a></td>
					<td><a href="/student-management/deleteStudentList?userId=${listOf.id}" onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<!--  <img alt="sexy bitch" src="/student-management/URLToReachResourceFolder/images/sexybitch.jpg"> -->
		<form action="addStudentToList" method="get">
			<input type="submit" value="ADD" class="btn btn-outline-primary">
		</form>
	</div>
</body>
</html>