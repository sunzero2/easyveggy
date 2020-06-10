document.querySelector('#backLogin').onclick = function() {
	window.open('/easyveggy/member/goin.do', 'login',
			'width=800, height=1400, left=320px, top=150px');
	location.href = '/easyveggy/index/index.do';
}

function searchId() {
	var nickName = document.querySelector('#idNickname').value;
	var phone = document.querySelector('#idPhone').value;
	$.ajax({
		url : "/easyveggy/member/searchid.do",
		data : {
			"nickname" : nickName,
			"cell" : phone
		},
		type : 'post',
		success : function(v) {
			if (v.length > 0) {
				alert("회원님의 계정은 " + v + "입니다.");
			} else {
				alert("입력하신 정보에 해당하는 계정이 없습니다.");
			}
		}
	})
}

function searchPw() {
	var userEmail = document.querySelector('#pwEmail').value;
	var nickName = document.querySelector('#pwNickName').value;
	$.ajax({
		url : "/easyveggy/member/searchpw.do",
		data : {
			"userEmail" : userEmail,
			"nickname" : nickName
		},
		type : 'post',
		success : function(v) {
			if (v > 0) {
				window.open('/easyveggy/member/changepage.do?user=' + userEmail,
						'pwChange', 'width: 800px, height: 400px');
			} else {
				alert("입력하신 정보와 일치하는 것이 없습니다. 다시 확인해주세요.");
			}
		}
	})
}