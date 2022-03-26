<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/test/file" method="post" enctype="multipart/form=data">
		<div class="form-group ">
			<label for="image">Image :&nbsp;</label> <input type="file"
				id="image" name="uploadfile">
		</div>
		<button type="submit"></button>
	</form>

</body>
</html>