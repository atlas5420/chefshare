<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<%@ include file="../../layout/header.jsp"%>
<%@include file="../../layout/boardLayout.jsp"%>
</head>
<body>

	<div class="container">
		<br />
		<h2>게시판</h2>
		<table class="table table-striped">
			<thead>
				<tr class="row">
					<th class="d-inline-block col-3">번호</th>
					<th class="d-inline-block col-4">제목</th>
					<th class="d-inline-block col-3">작성자</th>
					<th class="d-inline-block col-2">작성일</th>
				</tr>
			</thead>
			<c:forEach var="board" items="${boards.content }">
				<tbody>
					<tr  class="row">
						<td class="d-inline-block col-3">${board.id }</td>
						<td class="d-inline-block col-4"><a href="/forum/${board.id }">${board.title }</a></td>
						<th class="d-inline-block col-3">${board.user.username }</th>
						<td class="d-inline-block col-2">${board.timestamp }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${boards.first }">
					<li class="page-item disabled"><a class="page-link"
						href="?page=${boards.number-1 }">이전</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="?page=${boards.number-1 }">이전</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${boards.last }">
					<li class="page-item disabled"><a class="page-link"
						href="?page=${boards.number+1 }">다음</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="?page=${boards.number+1 }">다음</a></li>

				</c:otherwise>
			</c:choose>
		</ul>
		<c:if test="${principal.user.id ne null}">
			<div class="container d-flex justify-content-end">
				<button type="button" class="btn btn-outline-dark"
					onclick="location.href='/forum/wirte'">글쓰기</button>
			</div>
		</c:if>
	</div>
	<br />
	<%@ include file="../../layout/footer.jsp"%>
</body>