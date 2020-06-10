var reviewArr = null;
function getReview() {
	$.ajax({
		url: "/easyveggy/mypage/myreview.do",
		data: {
			"userId": myId
		},
		type: "post",
		success: function(v) {
			if(v.length > 0) {
				reviewArr = new Array();
				for(i = 0; i < v.length; i++) {
					reviewArr.push(v[i]);
				}
			} else {
				reviewArr = null;
			}
		}
	})
	
	.done(function() {
		var mediaList = document.querySelector('.media-list');
		mediaList.innerHTML = "";
		if(reviewArr != null) {
			if(reviewArr.length > 0) {
				for(i = 0; i < reviewArr.length; i++) {
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
					var change = document.createElement('button');
					var deleteBtn = document.createElement('button');
					
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
					change.className = 'btn btn-primary btn-sm text-uppercase js-scroll-trigger';
					change.id = 'c' + i;
					deleteBtn.className = 'btn btn-primary btn-sm text-uppercase js-scroll-trigger';
					deleteBtn.id = 'd' + i;
					
					var dateArr = reviewArr[i].revDate.split(" ");
					var mm = dateArr[0].substring(0, dateArr[0].length-1);
					if(mm < 10) {
						mm = '0' + mm;
					}
					var dd = dateArr[1].substring(0, dateArr[0].length-1);
					if(dd < 10) {
						dd = '0' + dd;
					}
					
					mediaUserName.textContent = reviewArr[i].nickName;
					mediaCont.textContent = reviewArr[i].revContent;
					dateDay.textContent = dd;
					dateMonth.textContent = mm;
					dateYear.textContent = dateArr[2];
					change.textContent = '수정하기';
					deleteBtn.textContent = '삭제하기';
					deleteBtn.style.marginLeft = '10px';
					
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
					wellLg.appendChild(change);
					wellLg.appendChild(deleteBtn);
					
				}
				btnClick();
			}
		} else {
			alert("아직 등록한 리뷰가 없습니다.");
		}
	})
}


function btnClick() {
	document.querySelectorAll('.btn').forEach(function(el) {
		el.addEventListener('click', function(v) {
			var idx = el.id.substring(1, el.id.length);
			
			if(el.textContent == '수정하기') {
				var list = document.querySelector('.media-list').children[idx].children[1].children[0];
				var input = document.createElement('input');
				var chgBtn = document.createElement('button');
				var backBtn = document.createElement('button');
				
				input.name = 'cont';
				input.id = 'cont' + idx;
				chgBtn.textContent = '저장';
				chgBtn.className = 'createBtn';
				backBtn.textContent = '취소';
				backBtn.className = 'createBtn';
				
				list.children[2].style.display = 'none';
				list.children[3].style.display = 'none';
				list.children[4].style.display = 'none';
				list.appendChild(input);
				list.appendChild(chgBtn);
				list.appendChild(backBtn);
				
				createBtn(idx);
			} else if(el.textContent == '삭제하기') {
				if(confirm("리뷰를 삭제하시겠어요?")) {
					$.ajax({
						url: "/easyveggy/mypage/delreview.do",
						data: {
							"revId": reviewArr[idx].revId
						},
						success: function(v) {
							if(v > 0) {
								alert("리뷰가 삭제됐어요!");
							} else {
								alert("삭제 중 오류가 발생했어요. 다시 시도해주세요.");
							}
						}
					})
					
					.done(function() {
						location.reload();
					})
				}
			}
		})
	})
}

function createBtn(idx) {
	document.querySelectorAll('.createBtn').forEach(function(el) {
		el.addEventListener('click', function(v) {
			if(el.textContent == '저장') {
				$.ajax({
					url: "/easyveggy/mypage/chgreview.do",
					data: {
						"revId": reviewArr[idx].revId,
						"cont": document.querySelector('#cont' + idx).value
					},
					success: function(v) {
						if(v > 0) {
							alert("리뷰가 정상적으로 수정됐어요!");
							location.reload();
						} else {
							alert("수정 중 오류가 발생했어요. 다시 시도해주세요.");
						}
					}
				})
			} else {
				var list = document.querySelector('.media-list').children[idx].children[1].children[0];
				list.children[2].style.display = 'block';
				list.children[3].style.display = 'inline-block';
				list.children[4].style.display = 'inline-block';
				list.removeChild(list.children[7]);
				list.removeChild(list.children[6]);
				list.removeChild(list.children[5]);
			}
		})
	})
}