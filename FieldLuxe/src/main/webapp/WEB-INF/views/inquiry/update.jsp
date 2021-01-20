<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<title>Q&A UPDATE</title>

<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	  // Summernote에 글 내용 추가하는 코드
	  $("#summernote").summernote('code', '${inquiry.inquiryContent}');
	});
</script>
</head>
<body>
<h2 style="text-align: center;">글 수정</h2><br><br><br>

<div style="width: 60%; margin: auto;">
	<form method="post" action="update" >
		<input type="hidden" name="inquiryId" value="${inquiry.inquiryId}">
		<input type="text" name="inquiryEmail" style="width: 20%;" placeholder="작성자" value="scall24" readonly/><br>
		<input type="text" name="inquiryTitle" style="width: 40%;" placeholder="제목" value="${inquiry.inquiryTitle}"/>
		<br><br> 
		<textarea id="summernote" name="inquiryContent"></textarea>
		<input id="subBtn" type="button" value="글 수정" style="float: right;" onclick="goUpdate(this.form)"/>
	</form>
</div>
<script>
function goUpdate(form) {
	var title = form.inquiryTitle.value;
	var userId = form.inquiryEmail.value;
	var content = form.inquiryContent.value;
	
	if (title.trim() == ''){
		alert("제목을 입력하지 않았습니다!");
		return false;
	}
	if (content.trim() == ''){
		alert("내용을 입력하지 않았습니다!");
		return false;
	}
	form.submit();
}
</script>
</body>
</html>