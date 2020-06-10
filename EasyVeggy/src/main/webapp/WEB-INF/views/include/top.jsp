<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger topLogo" href="/easyveggy/index/index.do"><img src="/easyveggy/resources/image/after/vganlogo-1w.png" /></a>
		<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			Menu
			<i class="fas fa-bars ml-1"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav text-uppercase ml-auto">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#services">Choose</a></li>
				<c:if test="${loginInfo == null }">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#">Login</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#">Join</a></li>
				</c:if>
				<c:if test="${loginInfo != null}">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/easyveggy/mypage/main.do">Mypage</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/easyveggy/member/logout.do">Logout</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>