<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="<c:url value="review/list"/>">리뷰 목록</a><br>
<a href="<c:url value="inquiry/list"/>">목록</a><br>
<a href="<c:url value="inquiry/insertInquiry"/>">글쓰기</a><br>
</body>
</html>
