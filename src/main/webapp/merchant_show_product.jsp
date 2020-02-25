<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoping</title>
<style type="text/css">
.head {
	width: 800px;
	height: 150px;
	background-color: gray;
	/* 	margin-left: 150px; */
	padding-left: 200px;

	/* border-style: dashed; */
}

.lbody {
	width: 800px;
	height: 500px;
	background-color: maroon;
	/* 	margin-left: 150px; */
	padding-left: 200px;
	border-style: solid;
	border-color: maroon;
}

.footer {
	width: 1000px;
	height: 70px;
	background-color: olive;
}

.img {
	width: 1200px;
	height: 1000px;
	background-image: url('background.jpg');

	background-repeat: no-repeat;
	background-size: cover;
	
}
</style>
</head>
<body>
	<div class="img">

		<div class="head">
			<%@include file="header.html"%></div>
		<div class="lbody">
			<%@include file="merchant_add_product.jsp"%></div>
		<div class="footer">
			<%@include file="footer.html"%></div>
	</div>
</body>
</html>