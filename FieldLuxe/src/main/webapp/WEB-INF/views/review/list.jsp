<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>review list</title>
</head>

<style>
	h2 {
			text-align: center;
	}
	table {
			width: 100%;
	}
	#outter {
			display: block;
			width: 80%;
			margin: auto;
	}
</style>
<body>
<h1>review LIST</h1>
<div id="outter">
	<table border="1">
		<tr>
				<td>No.</td>
				<td width="50%">제품명</td>
				<td>작성자</td>
				<td>대상자</td>
				<td>리뷰내용</td>
				<td>점수</td>
				<td>등록일</td>
		</tr>
		<c:forEach var="list" items="${list}" varStatus="status">
			<tr>
					<td>${list.reviewId}</td>
					<td>${list.productName}</td>
					<td>${list.reviewWriter}</td>
					<td>${list.reviewTarget}</td>
					<td>${list.reviewContent}</td>
					<td><c:forEach var="rating" items="${starRating}" varStatus="status" begin="1" end="${list.reviewScore}">★</c:forEach></td>
					<td><fmt:formatDate value="${list.reviewDate}" pattern="yyyy.MM.dd"/></td>
			</tr>
		</c:forEach>
	</table>

		<input type="button" value="글쓰기" style="float: right;"
			onclick="location.href='insertInquiry'"> [<a href="list?page=1">처음</a>]
		<c:if test="${pageManager.nowBlock gt 1}">
			[<a href="list?page=${pageManager.startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${pageManager.startPage}"
			end="${pageManager.endPage}">
			[<a href="list?page=${i}">${i}</a>]
		</c:forEach>
		<c:if test="${pageManager.nowBlock < pageManager.totalBlock}">
			[<a href="list?page=${pageManager.endPage+1}">다음</a>]
		</c:if>
	</div>
</body>
</html>