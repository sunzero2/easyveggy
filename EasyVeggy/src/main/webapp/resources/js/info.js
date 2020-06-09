var table = document.querySelector('.reviewTable');
var arr = null;

function getReview() {
	arr = new Array;
	
	if (index < 0) {
		alert('첫 페이지입니다.');
		index = 0;
	} else {
		$.ajax({
			url : 'http://localhost:8787/vgan/info/getreview',
			data : {
				"menuId" : menuId,
				"index" : index
			},
			type : "post",
			success : function(v) {
				var jObj = JSON.parse(v);
				if(jObj.length > 0) {
					for(i = 0; i < jObj.length; i++) {
						arr.push(jObj[i]);
					}
				}
			}
		})

		.done(function() {
			var revNo = 1;
			if(arr.length > 0) {
				table.innerHTML = "";
				for (i = 0; i < arr.length; i++) {
					reviewNo = document.createElement('div');
					reviewNo.className = "reviewNo";
					reviewNo.textContent = "No." + ((index * 5) + revNo++);
	
					userName = document.createElement('div');
					userName.className = "userName";
					userName.textContent = arr[i].nickName;
	
					reviewCont = document.createElement('div');
					reviewCont.className = "reviewCont";
					reviewCont.textContent = arr[i].revContent;
	
					row = table.insertRow();
					cell1 = row.insertCell();
					cell1.appendChild(reviewNo);
	
					cell2 = row.insertCell();
					cell2.appendChild(userName);
	
					cell3 = row.insertCell();
					cell3.appendChild(reviewCont);
				}
			} else {
				alert('더 이상 불러올 리뷰가 없습니다.');
			}
		})
	}
}

var star = 0;
var starArr = document.querySelectorAll('.star');

starArr.forEach(function(el) {
	el.addEventListener('click', function() {
		for (i = 0; i < starArr.length; i++) {
			starArr[i].src = 'http://localhost:8787/vgan/resources/image/after/portfolio/starN.png';
		}

		for (i = 0; i < el.id; i++) {
			starArr[i].src = 'http://localhost:8787/vgan/resources/image/after/portfolio/starY.png';
		}

		star = (el.id).substr(1);
	})
})

var content = document.querySelector('.area');
function addReview() {
	$.ajax({
		url : 'http://localhost:8787/vgan/info/addreview',
		data : {
			"star" : star,
			"menuId" : menuId,
			"content" : content.value
		},
		type : 'post',
		success : function(v) {
			if (v > 0) {
				alert('리뷰가 정상적으로 저장되었습니다.');
				location.reload();
			} else {
				alert('리뷰 작성 실패! 지속적으로 발생 시 고객센터로 문의 바랍니다.');
				location.reload();
			}
		}
	})
}