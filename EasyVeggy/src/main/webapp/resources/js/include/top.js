// top.jsp 오른쪽 상단 버튼 부분 스크립트
document.querySelectorAll('.nav-item').forEach(function(el) {
	el.addEventListener('click', function(v) {
		if(v.target.text == 'Login' || v.target.text == 'Join') {
			window.open('/easyveggy/member/goin.do','login', 'width=800, height=1400, left=320px, top=150px');
		}
	})
})