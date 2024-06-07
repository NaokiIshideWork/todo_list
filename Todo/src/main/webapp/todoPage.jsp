<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>MyToDoページ</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="ToDoServlet">すべて</a>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="ToDoDelayServlet">遅延中</a></li>
					<li class="nav-item"><a class="nav-link"
						href="ToDoDoneServlet">完了済み</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
<div class="container">
	<div class="d-flex justify-content-end mt-1 mb-1">
		<a href="ToDoAddServlet"><button type="button"
				class="btn btn-success">+追加</button></a>
	</div>
	</form>
</div>

<div class="container text-center">
	<table class="table table-hover">
		<thead>
			<tr>

				<th scope="col" class="col-md-2"><a href="ToDoServlet"
					class="text-decoration-none link-body-emphasis">期限</a></th>
				<th scope="col" class="col-md-1">優先度</th>
				<th scope="col" class="col-md-2">タイトル</th>
				<th scope="col" class="col-md-4">内容</th>
				<th scope="col" class="col-md-1">未完了</th>
				<th scope="col" class="col-md-1">編集</th>
				<th scope="col" class="col-md-1">削除</th>
			</tr>
		</thead>
		<c:forEach var="obj" items="${list}">
			<form action="ToDoServlet" method="post">
				<tr>
					<td class="col-md-2"><c:out value="${obj.getDate()}" /></td>
					<td class="col-md-1"><c:out value="${obj.getPriority()}" /></td>
					<td class="col-md-1"><c:out value="${obj.getTitle()}" /></td>
					<td class="col-md-3"><c:out value="${obj.getContents()}" /></td>
					<td class="col-md-3"><c:choose>
							<c:when test="${obj.getDone() == '未完了'}">
								<button type="submit" class="btn btn-outline-danger text-nowrap"
									name="done_id" value="${obj.getId()}" role="button"
									onclick="return confirm('完了でよろしいでしょうか?')" />
								<c:out value="${obj.getDone()}" />
								</button>
							</c:when>
							<c:otherwise>
								<div class="btn btn-outline-info ">
									<c:out value="${obj.getDone()}" />
								</div>
							</c:otherwise>
						</c:choose></td>
			</form>
			<form action="ToDoEditServlet" method="get">
				<td class="col-md-1">
					<button type="submit" class="btn btn-outline-warning text-nowrap"
						name="edit_id" value="${obj.getId()}" role="button"
						/> 編集
					</button>
				</td>
			</form>
			<form action="ToDoDeleteServlet" method="post">
				<td class="col-md-1">
					<button type="submit" class="btn btn-outline-dark text-nowrap"
						name="delete_id" value="${obj.getId()}" role="button"
						onclick="return confirm('削除してよろしいでしょうか?')" /> 削除
					</button>
				</td>
			</form>
			</tr>

		</c:forEach>
		
			
		
	</table>
</div>

</html>