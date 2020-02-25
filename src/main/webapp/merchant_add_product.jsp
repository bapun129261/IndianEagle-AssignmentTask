<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.pd {
	font-size: 20px;
	text-align: center;
	border-style: solid;
}

.bt {
	background-color: #1c87c9;
	border: none;
	color: white;
	padding: 2px 3px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	margin: 4px 2px;
	cursor: pointer;
}

.bt:hover {
	background-color: gray;
	color: orange;
}
</style>


</head>
<body>

	<h1 style="font-size: 80px;">Get All Product</h1>

	<table class="pd">
		<tr>
			<th style="border-style: solid;">Product Name</th>
			<th style="border-style: solid;">Quantity</th>
			<th style="border-style: solid;">Price</th>
		</tr>


		<c:forEach items="${product}" var="u">
			<tr>
				<td style="border-style: solid;">${u.getName()}</td>
				<td style="border-style: solid;">${u.getQuantity()}</td>
				<td style="border-style: solid;">${u.getPrice()}</td>
			</tr>

		</c:forEach>

		<tr>
			<td><a href="/additems" class="bt">Add items</a></td>
		</tr>
	</table>

</body>
</html>