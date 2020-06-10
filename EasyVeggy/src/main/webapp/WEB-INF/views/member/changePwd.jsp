<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/member/changePwd.css"/>
</head>
<body>
<div class="modal-dialog modal-login">
	<div class="modal-content">
		<div class="modal-header">
			<img class="modal-header-logo" src="/easyveggy/resources/image/after/vganlogo-1w.png">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
				<h4 class="modal-title">비밀번호 재입력</h4>
				<p>변경하실 비밀번호를 입력해주세요 </p>
		</div>
		<div class="modal-body-pw">
			<div class="form-group">
				<input type="password" class="form-control" id="password" placeholder="Password" required="required">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" id="pwdcheck"placeholder="Confirm Password" required="required">
			</div>
			<div class="form-group">
				<button class="btn btn-success btn-lg btn-block signup-btn" onclick="change();">Change</button>
			</div>
			<p>(영소문자 숫자 특수문자를 포함하는 8~15자)</p>
			<p class="hint-text small">
				<a id="backLogin" href="#">LOGIN 페이지로 이동</a>
			</p>
		</div>
	</div>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script>
	document.querySelector('#backLogin').onclick = function() {
		window.open('/easyveggy/member/goin.do','login', 'width=800, height=1400, left=320px, top=150px');
		location.href = '/easyveggy/index/index.do';
	}
	
	var user = "${user}";
	
	function change() {
		var pw = document.querySelector('#password').value;
		var pwcheck = document.querySelector('#pwdcheck').value;
		if(pw == pwcheck) {
			$.ajax({
				url: "/easyveggy/member/changepw.do",
				data: {
					"userEmail": user,
					"userPw": pw,
				},
				type: 'post',
				success: function(v) {
					if(v > 0) {
						alert("비밀번호 변경에 성공했습니다. 메인페이지로 이동합니다.");
						opener.location.href = '/easyveggy/index/index.do';
						window.close();
					} else {
						alert("비밀번호 변경에 실패했습니다. 다시 시도해주세요.");
					}
					
				}
			})
		} else {
			alert('비밀번호가 일지하지 않습니다.');
		}
	}
</script>
</body>
</html>