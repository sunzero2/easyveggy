var nickname = document.querySelector('.changeNickname');
var password = document.querySelector('.changePw');
var cell = document.querySelector('.changeCell');
var span = document.querySelector('#pwdSpan');
var check = document.querySelector('#checkSpan');
var isSuccess = true;
var userPw = document.querySelector('#userPw');
		
document.querySelectorAll('.privacyBtn').forEach(function(el) {
	el.addEventListener('click', function(v) {
		if (v.target.id == 'nickname') {
					
			if(nickname.style.display == 'block') {
				nickname.style.display = 'none';
			} else {
				nickname.style.display = 'block';
			}
			password.style.display = 'none';
			cell.style.display = 'none';
		} else if (v.target.id == 'password') {
			pwdCheck();
		} else {
			if(cell.style.display == 'block') {
				cell.style.display = 'none';
			} else {
				cell.style.display = 'block';
			}
			nickname.style.display = 'none';
			password.style.display = 'none';
		}
	})
})
		
function pwdCheck() {
	var current = document.querySelector('#pwdCheck');
	if(current.value == userPw.value) {
		if(password.style.display == 'block') {
			password.style.display = 'none';
		} else {
			password.style.display = 'block';
		}
		nickname.style.display = 'none';
		cell.style.display = 'none';
	} else {
		alert("현재 비밀번호와 일치하지 않습니다. 다시 확인해주세요.");
	}
}
		
		
function validate() {
	var changePw = document.querySelector("#userPwd");
			
	if(changePw.value == userPw.value) {
		alert("같은 비밀번호로 변경할 수 없습니다.");
		isSuccess = false;
	}
			
	return isSuccess;
}
		
document.querySelector('#userPwd').onkeydown = function(v) {
	var pw = document.querySelector('#userPwd');
	var regExpPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$/;
	var testStr = pw.value + v.key;
			
	function chk(re, e, msg) {
		if(re.test(e)) {
			span.style.display = 'none';
			isSuccess = true;
		} else {
			span.style.display = 'block';
			span.style.color = 'red';
			span.textContent = msg;
			isSuccess = false;
		}
	}

	if(chk(regExpPw, testStr, '비밀번호를 확인하세요.')) {
		isSuccess = false;
	}
}

document.querySelector('#userPwdCheck').onkeydown = function(v) {
	var pw = document.querySelector('#userPwd');
	var ch = document.querySelector('#userPwdCheck');
	var testStr = ch.value + v.key;
			
	if(testStr == pw.value) {
		check.style.display = 'block';
		check.style.color = 'blue';
		check.textContent = "비밀번호가 일치합니다.";
		isSuccess = true;
	} else {
		check.style.display = 'block';
		check.style.color = 'red';
		check.textContent = "비밀번호가 일치하지 않습니다.";
		isSuccess = false;
	}
}

function secession() {
	if(confirm("정말로 탈퇴하시겠습니까?")) {
		$.ajax({
			url: '/easyveggy/member/secession.do',
			success: function(rgx) {
				if(rgx > 0) {
					alert("정상적으로 처리되었습니다. 그동안 저희 서비스를 이용해주셔서 감사합니다.");
					location.href = "/easyveggy/index/index.do";
				} else {
					alert("회원 탈퇴 중 에러가 발생하였습니다. 다시 시도해주십시오.");
				}
			}
		})
	}
}