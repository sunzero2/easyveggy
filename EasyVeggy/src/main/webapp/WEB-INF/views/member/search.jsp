<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css/styles.css" rel="stylesheet" />
<title>Easy Veggy's Healthy Choice</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/member/search.css"/>
<script>
	opener.location.href  = '/easyveggy/member/searchmem.do';
	window.close();
</script>
<body>
	<img class="modal-header-logo" src="/easyveggy/resources/image/after/vganlogo-1w.png">
	<div class="modal-dialog modal-login">	
		<div class="modal-content">
			<div class="findWrapper">
				<div class="modal-body">
				<div class="modal-header">
					<h4 class="modal-title">Find My ID</h4>
				</div><br>
				<h2 class="modal-title">아이디 찾기</h2>
					<div class="form-group">
						<input type="text" class="form-control" id="idNickname" placeholder="Username" required="required">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="idPhone" placeholder="PhoneNumber" required="required">
					</div>
					<div class="form-group">
						<button onclick="searchId();" class="btn btn-primary btn-block btn-lg">Search</button>
					</div>
				</div>
				
				<div class="modal-body">
					<div class="modal-header">
						<h4 class="modal-title">Find My PW</h4>
					</div><br>
					<h2 class="modal-title">비밀번호 찾기</h2>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Username" id="pwNickName" required="required">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="UserEmail" id="pwEmail" required="required">
					</div>
					<div class="form-group">
						<button onclick="searchPw();" class="btn btn-primary btn-block btn-lg">Search</button>
					</div>
					<p class="hint-text small">
						<a id="backLogin" href="#"> LOGIN 페이지로 이동</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
	<script src="../resources/js/member/search.js"></script>
</body>
</html>