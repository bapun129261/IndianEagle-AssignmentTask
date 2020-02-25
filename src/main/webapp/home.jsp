<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
.head {
	width: 900px;
	height: 150px;
	background-color: gray;
	/* 	margin-left: 150px; */
	padding-left: 200px;

	/* border-style: dashed; */
}

.lbody {
	width: 900px;
	height: 500px;
	background-color: maroon;
	/* 	margin-left: 150px; */
	padding-left: 200px;
	border-style: solid;
	border-color: maroon;
}

.footer {
	width: 1100px;
	height: 70px;
	background-color: olive;
}

.img {
	padding-top: 100px;
	background-image: url('background.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body class="img">
	<div>
		<div class="head">
			<div><%@include file="header.html"%></div>
		</div>
		<div class="lbody">
			<div><%@include file="login.html"%></div>
		</div>
		<div class="footer">
			<div><%@include file="footer.html"%></div>
		</div>
	</div>
</body>
</html>