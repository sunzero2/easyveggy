// top.jsp 오른쪽 상단 버튼 부분 스크립트
document.querySelectorAll('.nav-item').forEach(function(el) {
	el.addEventListener('click', function(v) {
		if(v.target.text == 'Login' || v.target.text == 'Join') {
			window.open('http://localhost:8787/vgan/member/goin','login', 'width=800, height=1400, left=320px, top=150px');
		}
	})
})

출처: https://cofs.tistory.com/372 [CofS]

// topLogo를 클릭하면 무조건 메인페이지로 이동
document.querySelector('.topLogo').addEventListener('click', function() {
	location.href='http://localhost:8787/vgan/welcome';
})