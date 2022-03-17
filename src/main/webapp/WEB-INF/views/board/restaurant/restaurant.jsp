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
<style>
.cardsize {
	width: 40%;
}
</style>
</head>
<body>

	<div class="container">
		<br />
		<div class="d-flex justify-content-between">
			<h2>Restaurants(레스토랑)</h2>
			<button type="button" class="btn btn-dark"
				onclick="location.href='/restaurant/write'">업체 등록</button>
		</div>
		<br /> <br />
		<div class="container ">
		<c:forEach var="restaurant" items="${restaurants }">
				<div>
					<div class="card cardsize m-3 " >
						이미지
						<div class="card-body">
							<h4 class="card-title">${restaurant.title }&nbsp;
								${restaurant.cuisine }</h4>
							<p class="card-text">${restaurant.content}</p>
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
</html>