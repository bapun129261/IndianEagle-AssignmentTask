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
</style>
<script type="text/javascript">
	function addItems() {
		var items = document.getElementById("book").value;

		alert("add items name")
		alert(items)
	}
</script>
</head>
<body>

	<h1 style="font-size: 80px;">Get All Product</h1>
	<form action="/purchage" method="post">
		<table class="pd">
			<tr>
				<th style="border-style: solid;">Product Name</th>
				<th style="border-style: solid;">Quantity</th>
				<th style="border-style: solid;">Price</th>
				<th style="border-style: solid;">Select Item</th>
				<th style="border-style: solid;">Enter Quantity you want</th>
			</tr>


			<c:forEach items="${product}" var="u">
				<tr>
					<td style="border-style: solid;" id="${u.getName()}">${u.getName()}</td>
					<td style="border-style: solid;">${u.getQuantity()}</td>
					<td style="border-style: solid;">${u.getPrice()}</td>
					<td style="border-style: solid;"><input type="checkbox"
						name="items"></td>
					<td style="border-style: solid;"><input type="text"
						name="quantity" placeholder="Enter Quantity you want"></td>
				</tr>

			</c:forEach>

			<tr>
				<td><input type="submit" value="Payment" onclick="addItems()"></td>
			</tr>
		</table>
	</form>
</body>
</html>