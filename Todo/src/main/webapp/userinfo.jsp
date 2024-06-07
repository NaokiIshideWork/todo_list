<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-datepicker.min.css">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container d-flex justify-content-center mt-5">
		<div class="card " style="width: 18rem;">
			<div class="card-header">ユーザー情報</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">名前：<c:out
						value="${person.getName()}"></c:out></li>
				<li class="list-group-item">メール:<c:out
						value="${person.getMail()}"></c:out></li>
			</ul>
		</div>
	</div>
</body>
</html>