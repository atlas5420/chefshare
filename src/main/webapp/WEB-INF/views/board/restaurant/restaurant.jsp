<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<%@ include file="../../layout/header.jsp"%>
<%@include file="../../layout/boardLayout.jsp"%>
<style>
.card {
	width: 400px;
}
</style>
</head>
<body>

	<div class="container">
		<br />
		<div class="d-flex justify-content-between">
			<h2>Restaurants(레스토랑)</h2>
			<c:if test="${principal.user.id ne null}">
				<button type="button" class="btn btn-dark"
					onclick="location.href='/restaurant/write'">업체 등록</button>
			</c:if>
		</div>
		<br /> <br />
		<div class="container d-flex flex-wrap justify-content-center">
			<c:forEach var="restaurant" items="${restaurants }">
				<div>
					<div class="card m-3 ">
					<div style="width:100%; height:300px;">
						<img class="card-img-top" src="/img/${restaurant.image.filename}" style="width:100%; height:100%;">
						</div>
						<div class="card-body">
							<h4 class="card-title">${restaurant.title }</h4>
							<p class="card-text">${restaurant.region} &nbsp;${restaurant.cuisine}</p>
							<a href="/restaurant/${restaurant.id }" class="btn btn-primary">상세정보</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br />
	<%@ include file="../../layout/footer.jsp"%>
</body>