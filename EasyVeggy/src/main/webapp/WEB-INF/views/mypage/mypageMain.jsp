<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<title>Easy Veggy's Healthy Choice</title>
<link rel="stylesheet" href="../resources/css/include/top.css" />
<link rel="stylesheet" href="../resources/css/mypage/myPageMain.css"/>
<link rel="stylesheet" href="../resources/css/main.css"/>
</head>
<body onload="getReview();">
	<%@ include file="../include/top.jsp" %>
	<%@ include file="mypageNavi.jsp" %>
	
	<div class="mypageConWrapper">
		<div class="mypageTitle">나의 리뷰</div>
		<div class="myReviewBody">
			<ul class="media-list">
			</ul>  
		</div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
	<script src="../resources/js/include/top.js"></script>
	<script>
		var myId = ${loginInfo.userId};
	</script>
	<script src="../resources/js/mypage/myReview.js"></script>
</body>
</html>