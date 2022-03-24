<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@ include file="layout/header.jsp"%>
<%@include file="layout/boardLayout.jsp"%>
</head>
<body>
	<!-- Page Content-->
	<div class="container" >
		<!-- Heading Row-->
		<div class="row gx-4 gx-lg-5 align-items-center my-5" >
			<%@ include file="layout/carousel.jsp"%>
			<div class="col-lg-5" style="text-align:center;">
				<h1 class="font-weight-light">모든 쉐프들의 공간</h1>
				<p>요리는 새로운 세상을 창조하는 일<br/>여러분의 경험과 지식을 공유해주세요<br /></p>
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
	<%@ include file="layout/footer.jsp"%>
</body>