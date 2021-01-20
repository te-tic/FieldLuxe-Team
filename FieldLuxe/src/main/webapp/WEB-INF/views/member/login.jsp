<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/custom/user.css" />
<style type="text/css">
.parent {
	display: flex;
}
.child {
	flex: 1;
	margin: 5px;
}
.child input {
	width: -webkit-fill-available;
}
</style>
</head>
<body>

<c:choose>
	<c:when test="${ sessionScope.user != null }">
		<script type="text/javascript">
			history.back();
		</script>
	</c:when>
	<c:when test="${ param.error == 1 }">
		<script type="text/javascript">
			alert("존재하지 않는 ID 혹은 맞지 않는 비밀번호입니다.");
		</script>		
	</c:when>
</c:choose>


<div class="outer">
	<div class="middle">
		<div class="inner">
 			<form action="login.do" method="post" id="loginForm">
				<div align="center" style="width: 300px;">
					<h1>로그인</h1>
					<table class="padding-table">
						<tr>
							<td>
								<input type="email" name="userEmail" id="userEmail" class="form-control" required placeholder="이메일">
							</td>
						</tr>
						<tr>
							<td>
								<span id="idCheck" style="color: red;"></span>								
							</td>
						</tr>
						<tr>
							<td>
								<input type="password" name="userPw" id="userPw" class="form-control" required placeholder="비밀번호">								
							</td>
						</tr>
						<tr>
							<td>
								<span id="pwCheck" style="color: red;"></span>
							</td>
						</tr>
						<tr>
							<td>
								<div class="parent">
									<div class="child">
										<input type="submit" value="확인" id="submit" class="btn btn-primary">
									</div>

									<div class="child">
										<input type="button" value="회원가입" class="btn btn-info" id="register">
									</div>
								</div>
							</td>
						</tr>
					</table>
					
				</div>
			</form>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	
	$('#loginForm').bind('submit', function() {
		
		
		$.ajax({
			url: "/login.do",
			type: "post",
			data: {
				"email" : $('#userEmail').val(),
				"password" : $('#userPw').val()
				},
			dataType: "text",
			success: function(value) {
				if (value == '0') {
					location.href="/home.jsp";
				} else {
					alert('아이디가 존재하지 않거나 비밀번호가 틀렸습니다.');
				}
			},
			error: function(request, status, error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
		return false;
	});
});

$('#register').click(function() {
	location.href="register.login";
});

$( function(){
	$( '#userEmail' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
	});
});
</script>



</body>
</html>