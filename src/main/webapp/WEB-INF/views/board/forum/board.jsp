<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../layout/header.jsp"%>
<%@include file="../../layout/boardLayout.jsp"%>
</head>
<body>

	<div class="container">
		<br />
		<h2>게시판</h2>
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
				<button type="button" class="btn btn-outline-dark">Dark</button>
			</div>
		</c:if>
	</div>


	<%@ include file="../../layout/footer.jsp"%>
</body>
</html>