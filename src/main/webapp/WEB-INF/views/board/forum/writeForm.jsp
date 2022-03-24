<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/boardLayout.jsp"%>

<!-- summernote libraries -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

</head>

<body>
	<br />
	<div class="container">
	<form>
		<div class="form-group ">
			<label for="title"></label> <input type="text" class="form-control"
				placeholder="Enter title" id="title">
		</div>
		<div class="form-group">
			<label for="content">content</label>
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
	</form>
	<div class="d-flex justify-content-end">
	<button id="btn-board-write" class="btn btn-primary">등록</button>
	</div>
	<script>
		$('.summernote').summernote({
			tabsize : 2,
			height : 300
		});
	</script>
</div>
	<script src="../js/board.js"></script>
		<br />
	<%@ include file="../../layout/footer.jsp"%>
</body>