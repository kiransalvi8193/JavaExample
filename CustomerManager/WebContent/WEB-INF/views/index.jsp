<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Manager</title>
</head>
<body>
	<div align="center">
		<h1>Customer Manager</h1>
		<form action="get" action="search">
			<input type="text" name="keyword" /> <input type="submit"
				value="Search" />
				
				<h3><a href="new">New Customer</a></h3>
			<table border="1" padding="5">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>E-mail</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${listcustomer}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
				
				</tr>
				
				</c:forEach>
			</table>

		</form>

	</div>

</body>
</html>