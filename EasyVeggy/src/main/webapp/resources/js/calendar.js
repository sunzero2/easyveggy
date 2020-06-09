// 오늘 날짜 받을 변수
var today = new Date();

// 이전 달 값을 today에 저장하는 함수
function beforeMonth() {
	// getMonth()는 0부터 11까지
	today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
	getIcon();
	build();
}

// 다음 달 값을 today에 저장하는 함수
function nextMonth() {
	today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
	getIcon();
	build();
}

function getIcon() {
	var todayM = today.getMonth()+1;
	
	$.ajax({
		url: "http://localhost:8787/vgan/calendar/callist",
		data: {
			"month": todayM
		},
		type: "get"
	})
}

// 달력 만드는 함수
function build() {
	var firstDate = new Date(today.getFullYear(), today.getMonth(), 1); //현재 달의 첫째 날
	var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0); //현재 달의 마지막 날
	var tbcal = document.getElementById("calendar"); // 달력 만들 테이블
	var yearmonth = document.getElementById("yearmonth"); // 년도와 월 출력할곳
	yearmonth.innerHTML = today.getFullYear() + "년 " + (today.getMonth() + 1) + "월"; //년도와 월 출력

	// getMonth는 0~11까지 출력하므로 1 더해야함.
	// getMonth+1이 12월이면 해당 년도의 마지막 월이니까 before에는 11월을 넣기 위해 getMonth를 하고, next에는 1월을 직접 넣어줌
	if (today.getMonth() + 1 == 12) {
		// label이라서 document.querySelector 필요없음
		before.innerHTML = today.getMonth() + "월";
		next.innerHTML = "1월";
	} else if (today.getMonth() + 1 == 1) {
		// getMonth+1이 1월이면 해당 년도의 첫 월이니까 before에 12월을 직접 넣어주고, next에는 +2 해줌(0부터 시작하니까)
		before.innerHTML = "12월";
		next.innerHTML = (today.getMonth() + 2) + "월";
	} else {
		// 12월도 1월도 아닐 경우에 아래 쿼리 실행
		before.innerHTML = today.getMonth() + "월";
		next.innerHTML = (today.getMonth() + 2) + "월";
	}

	// 처음에 달력을 실행할 때는 tbcal.rows의 값이 2다. (0000년 00월을 넣은 row 1개, 요일 넣은 row 1개)
	// 그럼 while문에 안걸리는데, 만약 이전 달이나 다음 달 label을 눌러서 build 함수를 실행하면 row의 수는 무조건 2를 넘는다.
	// 이전에 있던 값을 지우고 새로 만들기 위해서 while문이 있어야한다. 없애면 밑에 계속 추가된다.
	while (tbcal.rows.length > 2) {
		// deleteRow 함수는 매개변수로 테이블의 행번호를 받아서 그 행을 삭제한다.
		tbcal.deleteRow(tbcal.rows.length - 1);
	}

	// insertRow는 tr을 table 안에 삽입하는 함수
	// 그럼 row에는 tr 태그가 들어있음.
	var row = null;
	row = tbcal.insertRow();
	var cnt = 0;

	// getDay는 해당 날의 요일을 찾아주는데, nMonth는 해당 월의 1일을 나타냄.
	// 1일이 목요일이면 getDay의 값은 4고, 일요일이면 0임
	for (i = 0; i < firstDate.getDay(); i++) {
		// 빈칸 들어감. tr 안에 td 넣어줌
		cell = row.insertCell();
		cell.className = "calendarTd";
		cnt = cnt + 1;
	}
	
	// 날짜만큼 cell 만들기
	for (i = 1; i <= lastDate.getDate(); i++) {
		cell = row.insertCell();
		cell.innerHTML = i;
		cell.className = "calendarTd";
		cell.id = i;
		
		
		// cell 안에 div 넣기(icon 담을 박스임)
		var div = document.createElement('div');
		div.className = "calInnerDiv";
		cell.appendChild(div);
		cnt = cnt + 1;
		
		// 일요일
		if (cnt % 7 == 1) {
			cell.style.color = "#FF9090";
		}
		// 토요일
		if (cnt % 7 == 0) { 
			cell.style.color = "#7ED5E4";
			// tr 하나 새로 만들어줌
			if(i != (firstDate.getDay() - i)) {
				row = calendar.insertRow();
			}
		}
	}
	
	// 마지막 날이 토요일 전이면 빈 칸을 더 만듦.
	if(lastDate.getDay() < 6) {
		for(i = 0; i < (6 - lastDate.getDay()); i++) {
			cell = row.insertCell();
			cell.className = "calendarTd";
		}
	}
	addIcon();
	callIframe();
}