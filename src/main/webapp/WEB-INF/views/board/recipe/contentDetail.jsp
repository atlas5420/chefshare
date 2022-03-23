<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/boardLayout.jsp"%>
<body>
<input type="hidden" id="id" value="${restaurant.id }" />
	<form
		class="col-xl-5 col-lg-6 col-md-8  col-sm-10 mx-auto text-center form p-4">
		<div class="form-group ">
			<label for="title">업체명</label>
			<p>${restaurant.title }</p>
		</div>
		<br />
		<div class="form-group ">
			<label for="content">소개</label>
			<p>${restaurant.content }</p>
		</div>
		<br />

		<div class="form-group ">
			<label for="cuisine">Cuisine :</label> <input type="text"
				class="w-25 text-center" name="cuisine"
				value="${restaurant.cuisine }" id="cuisine" readonly> <br />
		</div>

		<br />
		<div class="form-group ">
			<label for="region">Region :</label> <input type="text"
				class="w-25 text-center" name="region" value="${restaurant.region }"
				id="region" placeholder="도시" readonly>
		</div>

		<br />
		<div class="form-group ">
			<label for="address">Address :&nbsp;</label> <input type="text"
				class="w-75 " id="address" value="${restaurant.address }">
		</div>
		<br />
	</form>

	<form action="/restaurant/writeProc" method="post"
		enctype="multipart/form=data">
		<div class="form-group ">
			<label for="image">Image :&nbsp;</label> <input type="file"
				id="image">
		</div>
	</form>
	<div class="d-flex justify-content-end">
		<button class="btn btn-primary"
			onclick="location.href='/restaurant/update/${restaurant.id}'">수정</button>
		<button id="btn-restaurant-delete" class="btn btn-primary">삭제</button>
	</div>
	<script src="../../js/restaurant.js"></script>
	<%@ include file="../../layout/footer.jsp"%>
</body>
</html>