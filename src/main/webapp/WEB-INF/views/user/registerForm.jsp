<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@ include file="../layout/header.jsp"%>
</head>
<body>
	<div class="container">
	<br/>
		<form>
			<div class="form-group col-lg-5">
			<label for="username">Username(6-12자)</label> <input type="text"
					class="form-control" placeholder="Enter username" id="username">
				<div id="id_check"></div>
			</div>
			<div class="form-group col-lg-5">
				<label for="email">Email</label> <input type="email"
					class="form-control" placeholder="Enter email" id="email">
				<div id="email_check"></div>
			</div>
			<div class="form-group col-lg-5">
				<label for="password">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="password">
				<div id="pwd_check"></div>
			</div>
		</form>
		<button id="btn-save" class="btn btn-primary">회원가입</button>
	</div>
	<br/>
	<script src="../js/user.js"></script>
	<%@ include file="../layout/footer.jsp"%>
</body>