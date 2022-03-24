<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@ include file="../layout/header.jsp"%>
</head>
<body>
	<div class="container">
		<form>
			<input type="hidden" id="id" value="${principal.user.id }">
			<div class="form-group ">
				<label for="username">Username</label> <input type="text"
					value="${principal.user.username }" class="form-control"
					placeholder="Enter username" id="username" readonly>
			</div>
			<div class="form-group ">
				<label for="email">Email</label> <input type="email"
					value="${principal.user.email }" class="form-control"
					placeholder="Enter email" id="email">
					<div id="email_check"></div>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="password">
					<div id="pwd_check"></div>
			</div>
		</form>
		<button id="btn-update" class="btn btn-primary">회원정보수정</button>
	</div>
	<script src="../js/user.js"></script>
	<%@ include file="../layout/footer.jsp"%>
</body>