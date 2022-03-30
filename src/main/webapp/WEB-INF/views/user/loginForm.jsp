<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@ include file="../layout/header.jsp"%>
</head>
<body>
	<div class="container ">
		<br>
		<form action="/login/loginProc" method="post">
			<div class="form-group   col-lg-5">
				<label for="username">Username</label> <input type="text"
					name="username" class="form-control" placeholder="Enter username"
					id="username">
			</div>
			<div class="form-group  col-lg-5">
				<label for="password">Password:</label> <input type="password"
					name="password" class="form-control" placeholder="Enter password"
					id="password">
			</div>
			<button id="btn-login" class="btn btn-primary">로그인</button>
		</form>
	</div>
	<br>
	<%@ include file="../layout/footer.jsp"%>
</body>