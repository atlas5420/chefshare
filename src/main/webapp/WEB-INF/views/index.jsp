<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="layout/header.jsp"%>
</head>
<body>
	<!-- Page Content-->
	<div class="container px-4 px-lg-5">
		<!-- Heading Row-->
		<div class="row gx-4 gx-lg-5 align-items-center my-5">
			<%@ include file="layout/carousel.jsp"%>
			<div class="col-lg-5">
				<h1 class="font-weight-light">Business Name or Tagline</h1>
				<p>This is a template that is great for small businesses. It
					doesn't have too much fancy flare to it, but it makes a great use
					of the standard Bootstrap core components. Feel free to use this
					template for any project you want!</p>
				<a class="btn btn-primary" href="#!">Call to Action!</a>
			</div>
		</div>

		<!-- Content Row-->
		<h2>Restaurant</h2>
		<div class="d-flex justify-content-between">
			<c:forEach var="restaurant" items="${restaurant.content }">
				<div class="card" style="width: 30%">
					<div class="card-body">
						<h2 class="card-title">${restaurant.title }</h2>
						<p class="card-text">${restaurant.content }</p>
					</div>
					<div class="card-footer">
						<a class="btn btn-primary btn-sm"
							href="/restaurant/${restaurant.id }">상세정보</a>
					</div>
				</div>
			</c:forEach>
		</div>
		<br /> <br />
		<h2>Forum</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
		<c:forEach var="board" items="${boards.content }">
			<tbody>
				<tr>
					<td>${board.id }</td>
					<td><a href="/forum/${board.id }">${board.title }</a></td>
					<th>${board.user.username }</th>
					<td>${board.timestamp }</td>
				</tr>
			</tbody>
		</c:forEach>
		</table>
	</div>
	<br/><br/>
	<script src="js/scripts.js"></script>
	<%@ include file="layout/footer.jsp"%>
</body>
</html>