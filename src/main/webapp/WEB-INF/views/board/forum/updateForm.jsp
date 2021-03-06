<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@ include file="../../layout/header.jsp"%>
<%@include file="../../layout/boardLayout.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
<div class="container">
<br />
	<form>
	<input type="hidden" id="id" value="${board.id }" />
		<div class="form-group ">
			<input value="${board.title }" type="text" class="form-control"
				placeholder="Enter title" id="title">
		</div>
		<div class="form-group">
			<textarea class="form-control summernote" rows="5" id="content">"${board.content }"</textarea>
		</div>
	</form>
	<div class="d-flex justify-content-end">
	<button id="btn-board-update"  class="btn btn-primary">수정</button>
	</div>
	
	</div>
	<br />
	<script>
		$('.summernote').summernote({
			tabsize : 2,
			height : 300
		});
	</script>
	<script src="../../js/board.js"></script>
	<%@ include file="../../layout/footer.jsp"%>
</body>