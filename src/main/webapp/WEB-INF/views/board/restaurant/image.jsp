<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<form name="image" method="post" enctype="multipart/form-data" >
		<div class="form-group ">
			<input type="file" id="file" name="file" accept="image/*" >
		</div>
		<input type="submit"  id="btn-mage" value="이미지등록">
	</form>
	<script src="/js/restaurant.js"></script>
</body>
</html>