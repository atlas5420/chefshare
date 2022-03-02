<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../layout/header.jsp"%>
</head>
<body>
	<div class="container">
		<form>
			<div class="form-group ">
				<label for="username">Username</label> <input type="text"
					class="form-control" placeholder="Enter username" id="username">
			</div>
			<div class="form-group ">
				<label for="email">Email</label> <input type="email"
					class="form-control" placeholder="Enter email" id="email">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="password">
			</div>
		</form>
		<button id="btn-save" class="btn btn-primary">회원가입</button>
	</div>
	<script src="../js/user.js"></script>
	<script src="../js/scripts.js"></script>
	<%@ include file="../layout/footer.jsp"%>
</body>
</html>