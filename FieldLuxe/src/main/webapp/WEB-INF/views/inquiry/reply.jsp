<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<title>reply</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<style>
	table { 	width : 100%;}
	
	textarea { 	width : 100%;
			   	height: 300px;		
				margin: 10px;
				display : inline-block;
			}
			
	#outter {
				display: block;
				width: 80%;
				margin: auto;
			}
</style>
<body>
<div id="outter" class="container">
    <form id="commentForm" name="commentForm" method="post">
    <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            
          </div>
          <%-- <%-- <sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal" var="user"/> --%>
            <input type="hidden" id="inquiryId" name="inquiryId" value="${inquiry.inquiryId}" />
            <input type="hidden" id="replyWriter" name="replyWriter" value="scall24" />
            <%-- </sec:authorize> --%>
      </form>
</div>
<div class="container">
	<form id="list" name="list" method="post">
		<div id="list">
		</div>
	</form>
</div>


<script>

	let flag = 0;
	var html = "";
	$(function() {
		getCommentList();
	});

	function update_reply2(){

		flag = 1;
		console.log("hi");
		getCommentList();
		
	}
	
	function update_reply(replyId) {
		var replyId = replyId;
		var inquiryId = "${inquiry.inquiryId}";
		var replyContent = $("#updateContent").val();
		var replyWriter = $("#replyWriter").val();
		console.log(replyId);
		console.log(inquiryId);
		console.log(replyContent);
		console.log(replyWriter);
		
		var allData = {
						"replyId" : replyId,
						"inquiryId" : inquiryId,
						"replyContent" : replyContent,
						"replyWriter" : replyWriter
					};
		
		if (confirm("really?")) {
			flag = 2;
			
			$.ajax({
					async : true,
					type : 'POST',
					url  : "<c:url value='/reply/updateReply'/>",
					data : JSON.stringify(allData),
					dataType : "json",
					cache : false,
					contentType : "application/json; charset=UTF8",
					success : function(data){
						if (data == "success") {
							getCommentList();
						};
						location.reload();
					},
					error : function(request, status, error) {
						//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
			});
		};
	}

	function delete_reply(code) {
		var replyId = code;
		var replyWriter = $("#replyWriter").val();
		var inquiryId = "${inquiry.inquiryId}";
		var replyContent = $("#updateContent").val();
			var allData = {
					"replyId" : replyId,
					"inquiryId" : inquiryId,
					"replyContent" : replyContent,
					"replyWriter" : replyWriter
							};
			
		if (confirm("삭제 하시겠습니까?")) {
			console.log(replyId);
			console.log(allData);
			$.ajax({
						async : true,
						type : 'POST',
						url : "<c:url value='/reply/deleteReply'/>",
						data : JSON.stringify(allData),
						dataType : "json",
						cache : false,
						contentType : "application/json; charset=UTF8",
						success : function(data) {
							if (data == "success") {
								getCommentList();
							};
							location.reload();
						},
						error : function(request, status, error) {
							//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						}
					});
		};
	}

	function add_comment(inquiryId) {
		// 여기다가 data 만들어서 넣기!
		var inquiryId = inquiryId;
		var replyContent = $("#replyContent").val();
		var replyWriter = $("#replyWriter").val();
		var allData = {
				"inquiryId" : inquiryId,
				"replyContent" : replyContent,
				"replyWriter" : replyWriter
			};
		$.ajax({
			type : 'POST',
			url : "<c:url value='/reply/insertReply'/>",
			data : JSON.stringify(allData),
			cache : false,
			contentType : "application/json; charset=UTF8",
			success : function(data) {
				if (data == "success") {
					getCommentList();
					$("#content").val("");
				};
				location.reload();
			},
			error : function(request, status, error) {
				//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}

	function getCommentList() {

		$.ajax({
					type : 'get',
					url : "<c:url value='/reply/list'/>",
					dataType : "json",
					data : $("#commentForm").serialize(),
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					success : function(data) {

						var html = "";
						var cCnt = data.length;

						if (data.length > 0) {

							for (i = 0; i < data.length; i++) {
								
								html += "<div style= 'text-align:center; margin: 0 auto;>";
								html += "<div><table class='table'><h6><strong>"+ data[i].writer+ "</strong></h6><a href='#' onClick='update_reply2()'>수정</a>&nbsp; &nbsp; <a href='#' onClick='delete_reply("+data[i].rno+")'>삭제</a><h6><strong>"+ data[i].date + "</strong></h6>";
								html += data[i].content + "<tr><td></td></tr>";
								if (flag == 1) {
									html += "<div><textarea style='width: 700px' rows='3' cols='20' id='updateContent' name='updateContent' placeholder="+data[i].content+"></textarea></div><br><div><a href='#' onClick='update_reply("+data[i].rno+")' class='btn pull-right btn-success'>등록</a></div>";
								}
								html += "</table></div>";
								html += "</div>";

							}
						} else {
							html += "<div><table class='table'><tr><td><textarea id='replyContent' name='replyContent' placeholder='답글을 입력하세요'></textarea><br><div><a href='#' onClick='add_comment("+${inquiry.inquiryId}+")' class='btn pull-right btn-success'>등록</a></div> </td></tr></table></div>";
							html += "<div>";
							html += "<div><table class='table'><h6><strong>등록된 답글이 없습니다.</strong></h6>";
							html += "</table></div>";
							html += "</div>";
						}
						$("#cCnt").html(cCnt);
						$("#list").html(html);

					},
					error : function(request, status, error) {

					}
				});
	}
</script>
</body>
</html>