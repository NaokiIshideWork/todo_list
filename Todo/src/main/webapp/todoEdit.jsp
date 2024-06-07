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
<title>MyToDo</title>

</head>
<body>
	<%@include file="header.jsp" %>
	<form action="/Todo/ToDoEditServlet" method="post" id="form">
		<div class="card mx-auto mt-5 border-0" style="width: 55%;">
			<div class="mb-4 row">
				<label for="inputPassword" class="col-sm-2 col-form-label">タイトル</label>
				<div class="col-sm-9 was-validated">
					<input type="text" id="txt" class="form-control border-primary"
						required maxlength="20" name="title" placeholder="タイトルは20文字以内です"
						value="${lists.getTitle()}">

				</div>
			</div>
			<div class="mb-4 row">
				<label for="inputPassword" class="col-sm-2 col-form-label">優先度</label>
				<div class="col-sm-9 was-validated">
					<select class="form-control border-primary " name="priority"
						id="txt" required>
						<option ${lists.getPriority()=='高'? 'selected':''}>高</option>
						<option ${lists.getPriority()=='中'? 'selected':''}>中</option>
						<option ${lists.getPriority()=='低'? 'selected':''}>低</option>
					</select>
				</div>
			</div>
			<div class="mb-4 row">
				<label for="inputPassword" class="col-sm-2 col-form-label">期限</label>
				<div class="col-sm-9 was-validated">
					<input class="form-control border-primary" required type="text"
						name="term" placeholder="年/月/日" id="date_term"
						value="${lists.getDate()}">
				</div>
			</div>
			<div class="mb-4 row">
				<label class="col-sm-2 form-label">内容</label>
				<div class="col-sm-9 was-validated">
					<textarea class="form-control border-primary" name="contents"
						rows="2" id="txt" maxlength="100" required
						placeholder="100文字以内で入力してください">${lists.getContents()}</textarea>
				</div>
			</div>
			<div class="col-sm-11 d-flex justify-content-end  ">
				<div class="mx-3">
					<a href="ToDoServlet"><button type="button" class="btn ">戻る</button></a>
				</div>
				<button type="submit" class="btn btn-outline-warning text-nowrap"
					name="afterEdit_id" value="${lists.getId()}" role="button" id="button"/>
				編集
				</button>

			</div>
		</div>
	</form>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>


</body>
<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.ja.min.js"></script>
<script type="text/javascript" src="js/todoPage.js"></script>
</html>