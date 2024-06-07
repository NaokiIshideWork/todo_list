<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>MyToDoLogin</title>
</head>
<body>
<h1 class="h3 mb-3 fw-normal text-center">Please sign in</h1>
	<form action="ToDoLoginServlet" method="post" id="form">
		<div class="card mx-auto mt-5 border-0" style="width: 55%;">
			<div class="mb-4 row">
				<label for="inputPassword" class="col-sm-2 col-form-label">名前</label>
				<div class="col-sm-9 was-validated">
					<input type="text" id="txt" class="form-control border-primary"
						name="name" placeholder="" required>
				</div>
			</div>

			<div class="mb-4 row">
				<label for="inputPassword" class="col-sm-2 col-form-label">メールアドレス</label>
				<div class="col-sm-9 was-validated">
					<input type="email"name="mail" class="form-control" id="exampleInputEmail1"
					placeholder="abcdefg@hijklmn" required>

				</div>
			</div>

			<div class="mb-4 row">
				<label class="col-sm-2 form-label">パスワード</label>
				<div class="col-sm-9 was-validated">
					<input type="password" class="form-control"
						id="exampleInputPassword1" name="password" placeholder="8～20文字(半角英文字)"
						required>
				</div>
			</div>
			<div class="col-sm-11 d-flex justify-content-end  ">
				<input id="button" type="submit" class="btn btn-success"
					value="ログイン" />
			</div>
		</div>
	</form>
</body>
</html>