<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="ToDoServlet">MyToDo</a>
		<div class="dropdown">
			<button class="btn btn-dark dropdown-toggle btn-lg" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">
				<c:out value="${person.getName()}"></c:out>
			</button>
			<div class="dropdown-menu " aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="ToDoUserInfoServlet">ユーザー</a> <a
					class="dropdown-item" href="ToDoLoginServlet">ログアウト</a>
			</div>
		</div>
	</div>
</nav>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
