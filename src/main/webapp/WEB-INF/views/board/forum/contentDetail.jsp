<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../layout/header.jsp"%>
<%@ include file="../../layout/boardLayout.jsp"%>
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
		<div class="form-group ">
			<div>
				글번호:<span id="id"><i>${board.id }</i></span> 작성자:<span id="id"><i>${board.user.username }</i></span>
			</div>

			<h3>${board.title }</h3>
		</div>
		<hr />
		<div class="form-group">
			<div>${board.content }</div>
		</div>
		<hr />
		<br />
		<div class="d-flex justify-content-end">
			<c:if test="${board.user.id == principal.user.id }">
				<button class="btn btn-warning"
					onclick="location.href='/forum/update/${board.id}'">수정</button>
				<button id="btn-board-delete" class="btn btn-danger">삭제</button>
			</c:if>
			<button class="btn btn-dark" onclick="location.href='/board'">목록</button>
		</div>
		<br />
		<div class="card">
			<form>
			<input id="userId" type="hidden" value="${principal.user.id }" />
				<input id="boardId" type="hidden" value="${board.id}" />
				<div class="card-header">댓글</div>
				<div class="card-body">
					<textarea id="reply-content" class="form-control" rows="1"></textarea>
				</div>
				<div class="card-footer">
					<button id="btn-reply-write" type="button" class="btn btn-primary">등록</button>
				</div>
			</form>
		</div>
		<br />
		<div class="card">
			<div class="card-header">댓글 리스트</div>
			<ul id="reply--box" class="list-group">
				<c:forEach var="reply" items="${board.reply }">
					<li id="reply--${reply.id }"
						class="list-group-item d-flex justify-content-between">
						<div>${reply.content }</div>
						<div class="d-flex">
							<div>${principal.user.username }:&nbsp;</div>
							<button class="badge text-dark" onclick="index.replyDelete(${board.id }, ${reply.id })">삭제</button>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<br />
	<br />

	<script>
		$('.summernote').summernote({
			tabsize : 2,
			height : 300
		});
	</script>
	<script src="../js/reply.js"></script>
	<script src="../js/board.js"></script>
	<script src="../js/scripts.js"></script>
	<%@ include file="../../layout/footer.jsp"%>
</body>
</html>