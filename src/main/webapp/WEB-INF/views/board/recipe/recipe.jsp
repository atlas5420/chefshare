<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../layout/header.jsp"%>
<%@include file="../../layout/boardLayout.jsp"%>
</head>
<body>

	<div class="container ">
		<br />
		<div class="d-flex justify-content-between">
			<h2>Recipe(레시피)</h2>
			<button type="button" class="btn btn-dark"
				onclick="location.href='/restaurant/write'">레시피 등록</button>
		</div>
		<p>검색 : <input type="text"></p>
		<br /> <br />
		<div class="container justify-content-center">
			<c:forEach var="restaurant" items="${recipe}">
				<div class="card w-50 m-3">
					<img class="card-img-top" src="img_avatar1.png" alt="Card image">
					<div class="card-body">
						<h4 class="card-title">${recip.title }&nbsp;
							${restaurant.cuisine }</h4>
						<p class="card-text">${restaurant.content}</p>
						<a href="#" " class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br />

	<%@ include file="../../layout/footer.jsp"%>
</body>
</html>