<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/boardLayout.jsp"%>
<body>
<div class="container">
	<form
		class="col-xl-5 col-lg-6 col-md-8  col-sm-10 mx-auto text-center form p-4"
		id="form" enctype="multipart/form-data">
		<input type="hidden" id="id" value="${restaurant.id }" />
		<div class="form-group ">
			<label for="title">업체명</label> <input type="text"
				value="${restaurant.title }" class="form-control" id="title">
		</div>
		<br />
		<div class="form-group ">
			<label for="content">소개</label>
			<textarea class="form-control" rows="3" id="content">"${restaurant.content }"</textarea>
		</div>
		<br />

		<div class="form-group ">
			<label for="cuisine">Cuisine :</label> <input type="text"
				class="w-25 text-center" name="cuisine"
				value="${restaurant.cuisine }" id="cuisine" readonly> <br />
			<input type="radio" class="form-check-input" name="cuisineSelect"
				value="한식" onchange="selectCuisine()" />한식&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" class="form-check-input" name="cuisineSelect"
				value="중식" onchange="selectCuisine()" />중식&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" class="form-check-input" name="cuisineSelect"
				value="일식" onchange="selectCuisine()" />일식&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" class="form-check-input" name="cuisineSelect"
				value="양식" onchange="selectCuisine()" />양식&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" class="form-check-input" name="cuisineSelect"
				value="카페" onchange="selectCuisine()" />카페
		</div>
		<!-- radio 선택 값 input에 표시 -->
		<script>
			function selectCuisine() {
				var select = $("input[name='cuisineSelect']:checked").val();
				console.log(select);
				$('input[name=cuisine]').attr('value', select);
			}
		</script>

		<br />
		<div class="form-group ">
			<label for="region">Region :</label> <input type="text"
				value="${restaurant.region }" class="w-25 text-center" name="region"
				id="region" placeholder="도시">
		</div>

		<br />
		<div class="form-group ">
			<label for="address">Address :&nbsp;</label> <input type="text"
				value="${restaurant.address }" class="w-75 " id="address"
				placeholder="주소를 입력해 주세요">
		</div>
		<br />
		<div class="form-group " style="width: 100%;">
			<label for="present-img">이전 이미지</label><br>
			<img id="present-img" class="img-fluid" src="/img/${restaurant.image.filename }" style="max-width:100%;">
		</div>
		<div class="form-group ">
			<label for="file">image :&nbsp;</label> <input type="file" id="file"
				name="file" accept="image/*">
		</div>
		<button id="btn-restaurant-update" class="btn btn-primary">수정</button>
	</form>
</div>
	<script src="../../js/restaurant.js"></script>
	<%@ include file="../../layout/footer.jsp"%>
</body>