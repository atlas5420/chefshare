<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>ChefShare</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>

<body>
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark  ">
		<div class="container">
			<a class="navbar-brand" href="/">셰프세요</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="collapsibleNavbar">

				<c:choose>
					<c:when test="${empty principal}">
						<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link hover"
								aria-current="page" href="/">Home</a></li>
							<!-- <li class="nav-item"><a class="nav-link hover"
								href="/recipe">recipe</a></li>  -->
							<li class="nav-item"><a class="nav-link hover"
								href="/restaurant">레스토랑</a></li>
							<li class="nav-item"><a class="nav-link hover"
								href="/recipe">레시피</a></li>
							<li class="nav-item"><a class="nav-link hover" href="/forum">포럼</a></li>
							<li class="nav-item"><a class="nav-link hover" href="/login">Login</a></li>
							<li class="nav-item"><a class="nav-link hover"
								href="/register">Join</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="navbar-nav ms-auto mb-2 mb-lg-0 ">
							<li class="nav-item"><a class="nav-link hover"
								aria-current="page" href="/">Home</a></li>
							<!-- <li class="nav-item"><a class="nav-link hover"
								href="/recipe">recipe</a></li>  -->
							<li class="nav-item"><a class="nav-link hover"
								href="/restaurant">레스토랑</a></li>
							<li class="nav-item"><a class="nav-link hover"
								href="/recipe">레시피</a></li>
							<li class="nav-item"><a class="nav-link hover" href="/forum">포럼</a></li>
							<li class="nav-item"><a class="nav-link hover"
								href="/profile">회원정보</a></li>
							<li class="nav-item"><a class="nav-link hover"
								href="/logout">Logout</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</div>


	</nav>
</body>
</html>