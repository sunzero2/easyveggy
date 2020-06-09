var cnt = 0;
var ings = document.getElementsByName('ing');

ings.forEach(function(el) {
	el.addEventListener('click', function(v) {
		if(v.target.checked) {
			cnt++;
		} else {
			cnt--;
		}
		
		if(cnt > 3) {
			alert("재료는 3개까지 선택 가능합니다.");
			v.target.checked = false;
			cnt--;
		}
	})
})

function clearAll() {
	for (var i = 0; i < ings.length; i++) {
		ings[i].checked = false;
	}
	cnt = 0;
}

var ingArr;
var menuArr;
function choose() {
	ingArr = "";
	var vl;
	var vLevel;
	for (var i = 0; i < ings.length; i++) {
		if (ings[i].checked) {
			ingArr += ings[i].value + "/";
		}
	}
	
	if (cnt < 3) {
		alert("재료 3개를 선택해주세요!");
	} else {
		$.ajax({
			url : "/easyveggy/menu/vlevel.do",
			type : 'post',
			data : {
				"ingArr": ingArr
			},
			success : function(v) {
				if(v.includes("FTN")) {
					vLevel = "프루테리언";
					vl = "FTN";
				} else if(v.includes("VGN")) {
					vLevel = "비건";
					vl = "VGN";
				} else if(v.includes("OVO")){
					vLevel = "오보";
					vl = "OVO";
				} else if(v.includes("LTO")) {
					vLevel = "락토";
					vl = "LTO";
				} else if(v.includes("LOV")) {
					vLevel = "락토오보";
					vl = "LOV";
				} else if(v.includes("POL")) {
					vLevel = "폴로";
					vl = "POL";
				} else if(v.includes("PSC")) {
					vLevel = "페스코";
					vl = "PSC";
				} else if(v.includes("POP")) {
					vLevel = "폴로페스코";
					vl = "POP";
				} else if(v.includes("FXT")) {
					vLevel = "플렉시테리언";
					vl = "FXT";
				}
				
				document.getElementById("myLevel").innerHTML = "<h2 class='section-heading text-uppercase'>당신을 위한 추천 메뉴!</h2>" + 
				"<h3 id='levelInfo' class='section-subheading text-muted'>오늘 당신의 선택 : " + vLevel
				+ " 메뉴를 골라보세요!</h3>";
			}
		})
		
		.done(function() {
			$.ajax({
				url : "/easyveggy/menu/recommendmenu.do",
				type : 'post',
				data : {
					vlevel : vl
				},
				success : function(v) {
					menuArr = new Array();
					for(i = 0; i < v.length; i++) {
						menuArr.push(v[i]);
					}
				}
			})
			
			.done(function() {
				console.dir(menuArr);
				var row = document.querySelector('#row');
				row.innerHTML = "";
				for(i = 0; i < 6; i++) {
					var menuWrapper = document.createElement('div');
					var portfolioItem = document.createElement('div');
					var portfolioLink = document.createElement('a');
					var portfolioHover = document.createElement('div');
					var portfolioHoverContent = document.createElement('div');
					var portfolioIcon = document.createElement('i');
					var imgFluid = document.createElement('img');
					var portfolioCaption = document.createElement('div');
					var portfolioCaptionHeading = document.createElement('div');
					var portfolioCaptionSubheading = document.createElement('div');
					
					menuWrapper.className = "col-lg-4 col-sm-6 mb-4 menuWrapper";
					menuWrapper.id = i;
					portfolioItem.className = "portfolio-item";
					portfolioLink.className = "portfolio-link";
					portfolioLink.dataset.toggle = "modal";
					portfolioLink.href = "#menuInfo";
					portfolioHover.className = "portfolio-hover";
					portfolioHoverContent.className = "portfolio-hover-content";
					portfolioIcon.className = "fas fa-seedling fa-3x";
					imgFluid.className = "img-fluid";
					imgFluid.src = "/easyveggy/resources/image/after/portfolio/" + menuArr[i].MENUID + ".jpg";
					portfolioCaption.className = "portfolio-caption"
					portfolioCaptionHeading.className = "portfolio-caption-heading";
					portfolioCaptionHeading.textContent = menuArr[i].MENU;
					portfolioCaptionSubheading.className = "portfolio-caption-subheading";
					portfolioCaptionSubheading.textContent = menuArr[i].RESTNAME;
					
					row.appendChild(menuWrapper);
					menuWrapper.appendChild(portfolioItem);
					portfolioItem.appendChild(portfolioLink);
					portfolioLink.appendChild(portfolioHover);
					portfolioHover.appendChild(portfolioHoverContent);
					portfolioHoverContent.appendChild(portfolioIcon);
					portfolioLink.appendChild(imgFluid);
					portfolioItem.appendChild(portfolioCaption);
					portfolioCaption.appendChild(portfolioCaptionHeading);
					portfolioCaption.appendChild(portfolioCaptionSubheading);
				}
				
				document.querySelectorAll('.col-lg-4').forEach(function(el) {
					el.style.display = "block";
				})
				
				menuInfoBox();
			})
		})
	}
}


var menuId;
var index = 0;
function menuInfoBox() {
	var menuName = document.querySelector('#infoMenuName');
	var menuPrice = document.querySelector('#infoMenuPrice');
	var restName = document.querySelector('#infoRestName');
	var restLoc = document.querySelector('#infoRestLoc');
	var restCell = document.querySelector('#infoRestCell');
	var restHour = document.querySelector('#infoRestHour');
	var area = document.querySelector('.area');
	
	document.querySelectorAll(".menuWrapper").forEach(function(el) {
		el.addEventListener("click", function(v) {
			menuId = menuArr[el.id].MENUID;
			var after = menuArr[el.id].RESTHOUR.replace("(", " ");
			after = after.replace(")", "");
			var hourArr = after.split(" ");
		
			for(i = 0; i < hourArr.length; i++) {
				switch(hourArr[i]) {
				case 'W-WD':
					hourArr[i] = '월-수';
					break;
				case 'M-WD':
					hourArr[i] = '월-수';
					break;
				case 'M-TH':
					hourArr[i] = '월-목';
					break;
				case 'W':
					hourArr[i] = '월-금';
					break;
				case 'M-SA':
					hourArr[i] = '월-토';
					break;
				case 'W-SA':
					hourArr[i] = '월-토';
					break;
				case 'TU':
					hourArr[i] = '화';
					break;
				case 'TU-F':
					hourArr[i] = '화-금';
					break;
				case 'TU-SA':
					hourArr[i] = '화-토';
					break;
				case 'TU-SU':
					hourArr[i] = '화-일';
					break;
				case 'WD-TH':
					hourArr[i] = '수-목';
					break;
				case 'WD-SA':
					hourArr[i] = '수-토';
					break;
				case 'F-SA':
					hourArr[i] = '금-토';
					break;
				case 'F-SU':
					hourArr[i] = '금-일';
					break;
				case 'SA':
					hourArr[i] = '토';
					break;
				case 'AS':
					hourArr[i] = '토';
					break;
				case 'SU':
					hourArr[i] = '일';
					break;
				case 'SU-TU':
					hourArr[i] = '일-화';
					break;
				case 'SU-WD':
					hourArr[i] = '일-수';
					break;
				case 'SU-TH':
					hourArr[i] = '일-목';
					break;
				case 'WE':
					hourArr[i] = '주말';
					break;
				case 'EW':
					hourArr[i] = '주말';
					break;
				case 'L':
					hourArr[i] = '점심';
					break;
				case 'H':
					hourArr[i] = '공휴일';
					break;
				case 'E':
					hourArr[i] = '매일';
					break;
				case 'L.O':
					hourArr[i] = 'LastOrder';
					break;
				case 'B.T':
					hourArr[i] = 'BreakTime';
					break;
				case 'NULL':
					hourArr[i] = '영업시간 비공개';
					break;
				}
			}
			
			var hour = "";
			for(i = 0; i < hourArr.length; i++) {
				hour += hourArr[i] + " ";
			}
			
			menuName.textContent = menuArr[el.id].MENU;
			menuPrice.textContent = "￦" + menuArr[el.id].MENUPRICE;
			restName.textContent = "Restaurant: " + menuArr[el.id].RESTNAME;
			restLoc.textContent = "Location: " + menuArr[el.id].RESTLOC;
			if(menuArr[el.id].전화번호 == 'NULL') {
				restCell.textContent = "매장번호가 비공개인 식당입니다.";
			} else {
				restCell.textContent = "Cell: " + menuArr[el.id].RESTPHONE;
			}
			restHour.textContent = "Opening: " + hour;
			area.value = "";
			getReview();
		})
	})
}



var arr = null;

function getReview() {
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
					arr = new Array;
					for(i = 0; i < jObj.length; i++) {
						arr.push(jObj[i]);
					}
				} else {
					arr = null;
				}
			}
		})

		.done(function() {
			var mediaList = document.querySelector('.media-list');
			mediaList.innerHTML = "";
			var revNo = 1;
			if(arr !=  null) {
				if(arr.length > 0) {
					for (i = 0; i < arr.length; i++) {
						var mediaLi = document.createElement('li');
						var userImgURL = document.createElement('a');
						var userImg = document.createElement('img');
						var mediaBody = document.createElement('div');
						var wellLg = document.createElement('div');
						var mediaUserName = document.createElement('h4');
						var dateWrapper = document.createElement('ul');
						var dateDay = document.createElement('li');
						var dateMonth = document.createElement('li');
						var dateYear = document.createElement('li');
						var mediaCont = document.createElement('p');
						
						mediaLi.className = 'media';
						userImgURL.className = 'pull-left';
						userImgURL.href = '#';
						userImg.className = 'media-object img-circle';
						userImg.src = "https://s3.amazonaws.com/uifaces/faces/twitter/dancounsell/128.jpg";
						userImg.alt = 'profile';
						mediaBody.className = 'media-body';
						wellLg.className = 'well well-lg';
						mediaUserName.id = 'revUserName';
						mediaUserName.className = 'media-heading text-uppercase reviews';
						dateWrapper.className = 'media-date text-uppercase reviews list-inline';
						dateDay.className = 'dd';
						dateMonth.className = 'mm';
						dateYear.className = 'aaaa';
						mediaCont.id = 'revUserCont';
						mediaCont.className = 'media-comment';
						
						var dateArr = arr[i].revDate.split(" ");
						var mm = dateArr[0].substring(0, dateArr[0].length-1);
						if(mm < 10) {
							mm = '0' + mm;
						}
						var dd = dateArr[1].substring(0, dateArr[0].length-1);
						if(dd < 10) {
							dd = '0' + dd;
						}
						
						mediaUserName.textContent = arr[i].nickName;
						mediaCont.textContent = arr[i].revContent;
						dateDay.textContent = dd;
						dateMonth.textContent = mm;
						dateYear.textContent = dateArr[2];
						
						mediaList.appendChild(mediaLi);
						mediaLi.appendChild(userImgURL);
						userImgURL.appendChild(userImg);
						mediaLi.appendChild(mediaBody);
						mediaBody.appendChild(wellLg);
						wellLg.appendChild(mediaUserName);
						wellLg.appendChild(dateWrapper);
						dateWrapper.appendChild(dateDay);
						dateWrapper.appendChild(dateMonth);
						dateWrapper.appendChild(dateYear);
						wellLg.appendChild(mediaCont);
					}
				}
			} else if(index == 0) {
				var div = document.createElement('div');
				div.className = 'centerText'
				div.textContent = "아직 등록된 리뷰가 없습니다.";
				mediaList.appendChild(div);
			} else {
				alert("마지막 페이지입니다.");
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
			} else {
				alert('리뷰 작성 실패! 지속적으로 발생 시 고객센터로 문의 바랍니다.');
			}
		}
	})
	
	.done(function() {
		getReview();
	})
}
