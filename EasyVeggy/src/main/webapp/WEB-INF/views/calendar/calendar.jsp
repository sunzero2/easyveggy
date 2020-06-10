<%@page import="com.hy.easyveggy.mypage.model.vo.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/include/top.css"/>
<link rel="stylesheet" href="../resources/css/mypage/myPageMain.css"/>
<link rel="stylesheet" href="../resources/css/mypage/iframe.css"/>
<link rel="stylesheet" href="../resources/css/mypage/calendar.css"/>
</head>
<body onload="build();">
	<%@ include file="../mypage/mypageNavi.jsp" %>
	<%@ include file="../include/top.jsp" %>
	<div class="mypageConWrapper"> 
		<div class="mainCalHeader">
			<div>
				<div class="mypageTitle">Calendar</div>
			</div>
			<span>이번 달 채식 횟수를 체크해보세요!</span>
		</div>
		
		<div>
			<table class="mainCalTable" id="calendar">
				<tr>
					<td class="tdTitle">
						<label onclick="beforeMonth();" id="before"></label>
					</td>
					<td class="tdTitle" colspan="5" id="yearmonth"></td>
					<td class="tdTitle">
						<label onclick="nextMonth();" id="next"></label>
					</td>
				</tr>
				<tr>
					<td class="tdTitle" style="color: #FF9090;">일</td>
					<td class="tdTitle">월</td>
					<td class="tdTitle">화</td>
					<td class="tdTitle">수</td>
					<td class="tdTitle">목</td>
					<td class="tdTitle">금</td>
					<td class="tdTitle" style="color: #7ED5E4;">토</td>
				</tr>
			</table>
		</div>
		<div class="mainCalTotal">
			<span class="mainCalTotalSum"></span>
			<span class="mainCalTotalTitle">이번 달 나의 채식 횟수 :</span>
		</div>
	</div>
	
	<c:if test="${loginInfo == null}">
		<script>
			alert("로그인이 종료되어 메인페이지로 이동합니다.");
			location.href = "/easyveggy/index/index.do";
		</script>
	</c:if>
	
	<c:if test="${calList.size() > 0 }">
		<%
			List list = (List)request.getAttribute("calList");
			List dayList = new ArrayList();
			String day = "";
			
			for(int i = 0; i < list.size(); i++) {
				day = ((Calendar)list.get(i)).getcDate();
				dayList.add(i, day.substring(day.length() - 2, day.length()));
			}
			
			String month = day.substring(5, 7);
			pageContext.setAttribute("dayList", dayList);
			pageContext.setAttribute("month", month);
		%>
	</c:if>
	<c:if test="${calList.size() <= 0 }">
		<%
		pageContext.setAttribute("dayList", 0);
		pageContext.setAttribute("month", 0);
		%>
	</c:if>
	 
	 <!-- iframe -->
	<div class="screenDiv"></div>
	<div class="innerDiv">
		<div class="iframeWrapper">
			<button class="closeBtn">X</button>
			<iframe class="iframe" src="/easyveggy/mypage/calsub.do"></iframe>
		</div>
	</div>
	
	<!-- script -->
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
	<script src="../resources/js/mypage/calendar.js"></script>
	<script src="../resources/js/mypage/iframe.js"></script>
	<script>
		var month = ${month};
		var dayList = ${dayList};
		var icon = "";
		var sum = 0;
		
		function addIcon() {
			if(dayList.length > 0 ) {
				document.querySelectorAll('.calendarTd').forEach(function(el) {
					for(var i = 0; i < dayList.length; i++) {
						if(dayList[i] == el.id) {
							$.ajax({
								url: "/easyveggy/mypage/getevent.do",
								data: {
									"day" : dayList[i],
									"month" : month
								},
								success: function(v) {
									sum++;
									el.children[0].style.background = "url('../resources/image/before/" + v.icon + ".jpg')";
									el.children[0].style.backgroundSize = "contain";
									document.querySelector('.mainCalTotalSum').textContent = sum;
								}
							})
						}
					}
				})
			}
		}
		
		function addData(data) {
			for(var i = 0; i < dayList.length; i++) {
				if(dayList[i] == data.id) {
					$.ajax({
						url: "/easyveggy/mypage/getevent.do",
						data: {
							"day" : dayList[i],
							"month" : month
						},
						success: function(v) {
							var menu = v.cMenu;
							var price = v.cPrice;
							var content = v.cCont;
							
							changeCont(menu, price, content);
						}
					})
					
				}
			}
		}
	</script>
</body>
</html>