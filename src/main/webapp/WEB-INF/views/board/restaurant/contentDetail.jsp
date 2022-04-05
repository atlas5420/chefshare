<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/boardLayout.jsp"%>
<body>
	<input type="hidden" id="id" value="${restaurant.id }" />
	<form class="col-xl-5 col-lg-6 col-md-8  col-sm-10 mx-auto  form p-4">
		<div class="form-group text-center"
			style="width: 100%; height: 300px;">
			<img class="card-img-top" src="/img/${restaurant.image.filename}"
				style="width: 50%; height: 100%;">
		</div>

		<div class="form-group ">
			<label for="content">업체명</label>
			<p>${restaurant.title }</p>
		</div>
		<br />
		<div class="form-group ">
			<label for="content">업체 소개</label>
			<p class="border">${restaurant.content }</p>
		</div>
		<br />

		<div class="form-group ">
			<label for="content">cuisine</label>
			<p>${restaurant.cuisine }</p>

		</div>
		<br /> <br />
		<div class="form-group ">
			<label for="content">지역</label>
			<p>${restaurant.region }</p>
		</div>

		<br />
		<div class="form-group ">
			<label for="content">주소</label>
			<p>${restaurant.address }</p>
		</div>
		<br />
	</form>

	<div class="d-flex justify-content-end">
		<button class="btn btn-primary"
			onclick="location.href='/restaurant/update/${restaurant.id}'">수정</button>
		<button id="btn-restaurant-delete" class="btn btn-primary">삭제</button>
	</div>
	<script src="../../js/restaurant.js"></script>
	<%@ include file="../../layout/footer.jsp"%>
</body>