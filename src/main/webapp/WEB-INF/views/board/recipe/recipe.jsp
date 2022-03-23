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
			<c:forEach var="recipe" items="${recipe}">
				<div class="card">
  <div class="card-header"></div>
  <div class="card-body">Content</div>
  <div class="card-footer">Footer</div>
</div>
			</c:forEach>
		</div>
	</div>
	<br />
	<%@ include file="../../layout/footer.jsp"%>
</body>
</html>